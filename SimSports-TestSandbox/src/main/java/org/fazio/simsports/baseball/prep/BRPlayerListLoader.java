package org.fazio.simsports.baseball.prep;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 4/1/13 1:20 PM
 */
public class BRPlayerListLoader {

	public static final String STATS_PAGE_2012 = "http://www.baseball-reference.com/leagues/MLB/2012-standard-batting.shtml";
	public static final String BATTING_TABLE_ID = "players_standard_batting";

	private final WebClient webClient;

	public BRPlayerListLoader() {
		this.webClient = new WebClient(BrowserVersion.FIREFOX_10);
	}

	public BRPlayerListLoader(final String proxyHost, final String proxyPortString, final String username, final String password) {
		final int proxyPort = Integer.valueOf(proxyPortString);
		System.out.println("Starting list loader (w/ proxy)...");
		this.webClient = new WebClient(BrowserVersion.FIREFOX_10, proxyHost, proxyPort);
		((DefaultCredentialsProvider) webClient.getCredentialsProvider()).addCredentials(username, password);
		this.webClient.getOptions().setJavaScriptEnabled(false);

		try {
			final List<String> playersList = this.getListOfPlayerIDs();
			//System.out.println(playersList);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	List<String> getListOfPlayerIDs() throws Exception {
		final List<String> playerList = new ArrayList<String>();

		final HtmlPage page = (HtmlPage) this.webClient.getPage(STATS_PAGE_2012);
		final HtmlTable battingStatsTable = (HtmlTable) page.getElementById(BATTING_TABLE_ID);

		final List<HtmlTableRow> statRows = (List<HtmlTableRow>) battingStatsTable.getByXPath("//tr[contains(@class, 'full_table')]");
		for(HtmlTableRow row : statRows) {
			final DomNodeList<HtmlElement> dataCells = (DomNodeList<HtmlElement>) row.getElementsByTagName("td");
			final HtmlAnchor playerLink = (HtmlAnchor) dataCells.get(1).getElementsByTagName("a").get(0);
			playerList.add(StringUtils.substringAfterLast(playerLink.getHrefAttribute().replace(".shtml", ""), "/"));
		}

		return playerList;
	}

	public static void main(String[] args) {
		if(args.length > 3) {
			new BRPlayerListLoader(args[0], args[1], args[2], args[3]);
		} else {
			new BRPlayerListLoader();
		}
	}

}
