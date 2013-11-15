package org.fazio.simsports.baseball.prep;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 4/1/13 12:15 PM
 */
public class BRScraper {

	public static final String BR_SPLITS_PAGE = "http://www.baseball-reference.com/players/split.cgi?year=2012&id=";
	public static final String RYAN_BRAUN_ID = "braunry02";
	public static final String ALEX_AMARISTA_ID = "amarial01";

	final WebClient webClient;

	public BRScraper() {
		this.webClient = new WebClient();

	}

	public BRScraper(final String proxyHost, final String proxyPortString, final String username, final String password) {
		final int proxyPort = Integer.valueOf(proxyPortString);
		System.out.println("Starting scraper (w/ proxy)...");
		this.webClient = new WebClient(BrowserVersion.FIREFOX_10, proxyHost, proxyPort);
		((DefaultCredentialsProvider) webClient.getCredentialsProvider()).addCredentials(username, password);
		this.webClient.getOptions().setJavaScriptEnabled(false);

		final String id = ALEX_AMARISTA_ID;

		try {
			this.loadSplitsData(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	void loadSplitsData(final String id) throws Exception {
		final HtmlPage splitsPage = this.webClient.getPage(BR_SPLITS_PAGE + id);

		this.loadInfoBox(splitsPage);
	}

	void loadInfoBox(final HtmlPage page) {
		final HtmlDivision infoBoxDiv = (HtmlDivision) page.getElementById("info_box");
		final String name = infoBoxDiv.getElementsByTagName("h1").get(0).asText();
		final DomNodeList<HtmlElement> pTagElements = (DomNodeList<HtmlElement>) infoBoxDiv.getElementsByTagName("p");

		final Map<String, String> infoBoxMap = this.handlePositionAttrs((HtmlParagraph) pTagElements.get(1));

		System.out.println("DONE");
	}

	Map<String, String> handlePositionAttrs(final HtmlParagraph posAttrsP) {
		final Map<String, String> valMap = new HashMap<String, String>();

		final Scanner scanner = new Scanner(posAttrsP.asText());

		System.out.println("Position Line = " + scanner.nextLine());
		System.out.println("B/T Line = " + scanner.nextLine());
		System.out.println("H/W Line = " + scanner.nextLine());

		return valMap;
	}

	public static void main(String[] args) {
		if(args.length > 3) {
			new BRScraper(args[0], args[1], args[2], args[3]);
		} else {
			new BRScraper();
		}
	}

}
