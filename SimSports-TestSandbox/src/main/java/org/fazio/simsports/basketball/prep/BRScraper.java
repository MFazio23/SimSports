package org.fazio.simsports.basketball.prep;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Fazio
 * @since 11/28/12 12:35 AM
 */
public class BRScraper {

	public static final String TOTALS_URL = "http://www.basketball-reference.com/leagues/NBA_2012_totals.html";
	public static final String ADVANCED_URL = "http://www.basketball-reference.com/leagues/NBA_2012_advanced.html";

	final WebClient webClient;

	public BRScraper() throws Exception {
		System.out.println("Starting scraper (no proxy)...");
		this.webClient = new WebClient(BrowserVersion.FIREFOX_10);
		this.webClient.getOptions().setJavaScriptEnabled(false);
		this.getPlayerList();
	}

	public BRScraper(final String proxyURL, final String proxyPort, final String username, final String password) throws Exception {
		System.out.println("Starting scraper (w/ proxy)...");
		this.webClient = new WebClient(BrowserVersion.FIREFOX_10, proxyURL, Integer.valueOf(proxyPort));
		((DefaultCredentialsProvider) webClient.getCredentialsProvider()).addCredentials(username, password);
		this.webClient.getOptions().setJavaScriptEnabled(false);
		this.getPlayerList();
	}

	@SuppressWarnings("unchecked")
	public void getPlayerList() throws Exception {
		final HtmlPage totalsPage = this.webClient.getPage(TOTALS_URL);
		final Map<String, BRPlayer> players = new HashMap<String, BRPlayer>();
		for(HtmlTableRow row : (List<HtmlTableRow>)totalsPage.getByXPath("//tr[@class='full_table']")) {
			final BRPlayer player = this.convertRowIntoBRPlayer(row);
			players.put(player.getId(), player);
		}

		final HtmlPage advPage = this.webClient.getPage(ADVANCED_URL);
		for(HtmlTableRow row : (List<HtmlTableRow>)advPage.getByXPath("//tr[@class='full_table']")) {
			final BRPlayer player = this.convertRowIntoBRPlayerAdv(row, players);
			players.put(player.getId(), player);
		}

		for(BRPlayer player : players.values()) {
			BRMongo.getInstance().save(this.convertShootingIntoBRPlayer(player));
			System.out.println("Saved = " + player.toString());
		}
	}

	public BRPlayer convertRowIntoBRPlayer(final HtmlTableRow row) {
		final List<HtmlTableCell> cells = row.getCells();
		final String name = cells.get(1).getTextContent();
		final String url = ((HtmlAnchor)cells.get(1).getFirstChild()).getHrefAttribute();
		final String id = StringUtils.substringAfterLast(url, "/").replace(".html", "");
		final String team = cells.get(3).getTextContent();
		final String fga = cells.get(8).getTextContent();
		final String fgm = cells.get(7).getTextContent();
		final String fta = cells.get(14).getTextContent();
		final String ftm = cells.get(13).getTextContent();
		final String foulRate = Double.toString((Double.valueOf(fta) * 1.5) / Double.valueOf(fga));
		final String ftPct = cells.get(15).getTextContent();
		final String oReb = cells.get(16).getTextContent();
		final String dReb = cells.get(17).getTextContent();

		final BRPlayer player = new BRPlayer();
		player.setId(id);
		player.setName(name);
		player.setTeam(team);
		player.setFtPct(ftPct);
		player.setFtRate(foulRate);
		player.setOffensiveReb(oReb);
		player.setDefensiveReb(dReb);

		return player;
	}

	public BRPlayer convertRowIntoBRPlayerAdv(final HtmlTableRow row, final Map<String, BRPlayer> players) {
		final List<HtmlTableCell> cells = row.getCells();
		final String url = ((HtmlAnchor)cells.get(1).getFirstChild()).getHrefAttribute();
		final String id = StringUtils.substringAfterLast(url, "/").replace(".html", "");

		final BRPlayer player = players.get(id);

		final String oRebPct = cells.get(9).getTextContent();
		final String dRebPct = cells.get(10).getTextContent();
		final String tRebPct = cells.get(11).getTextContent();
		final String astPct = cells.get(12).getTextContent();
		final String stlPCt = cells.get(13).getTextContent();
		final String blkPct = cells.get(14).getTextContent();
		final String toPct = cells.get(15).getTextContent();
		final String usagePct = cells.get(16).getTextContent();
		final String defRtg = cells.get(18).getTextContent();

		player.setOffensiveRebRate(oRebPct);
		player.setDefensiveRebRate(dRebPct);
		player.setTotalReboundPct(tRebPct);
		player.setAssistPct(astPct);
		player.setStealPct(stlPCt);
		player.setBlockPct(blkPct);
		player.setTurnoverPct(toPct);
		player.setUsagePct(usagePct);
		player.setDefenseRate(defRtg);

		return player;
	}

	public BRPlayer convertShootingIntoBRPlayer(final BRPlayer player) {
		//http://www.basketball-reference.com/players/a/adrieje01/shooting/2012/
		final String id = player.getId();
		final String url = "http://www.basketball-reference.com/players/" + id.substring(0, 1) + "/" + id + "/shooting/2012";

		try {
			final HtmlPage page = (HtmlPage) this.webClient.getPage(url);

			final HtmlParagraph p = (HtmlParagraph) page.getElementById("info_box").getElementsByTagName("p").get(1);
			final String[] textSplit = p.asText().split(" ");
			final String positions = textSplit[0].contains("Position") ? p.asText().split(" ")[1] : "N/A";
			final Map<String, String> distances = new HashMap<String, String>();
			player.setPositions(positions);

			final List<HtmlElement> bodies = page.getElementById("stats").getElementsByTagName("tbody");
			for(HtmlElement element : bodies) {
				final HtmlTableBody body = (HtmlTableBody) element;
				final List<HtmlElement> elements = body.getElementsByTagName("td");
				if("Shot Distance".equals(elements.get(0).getTextContent())) {
					player.setAtRimPct(elements.size() >= 4 ? elements.get(4).getTextContent() : ".000");
					player.setAtRimAstPct(elements.size() >= 10 ? elements.get(10).getTextContent() : ".000");
					player.setThreeToNinePct(elements.size() >= 15 ? elements.get(15).getTextContent() : ".000");
					player.setThreeToNineAstPct(elements.size() >= 21 ? elements.get(21).getTextContent() : ".000");
					player.setTenToFifteenPct(elements.size() >= 26 ? elements.get(26).getTextContent() : ".000");
					player.setTenToFifteenAstPct(elements.size() >= 32 ? elements.get(32).getTextContent() : ".000");
					player.setSixteenTo3PTPct(elements.size() >= 37 ? elements.get(37).getTextContent() : ".000");
					player.setSixteenTo3PTAstPct(elements.size() >= 43 ? elements.get(43).getTextContent() : ".000");
					player.setThreePtPct(elements.size() >= 48 ? elements.get(48).getTextContent() : ".000");
					player.setThreePtAstPct(elements.size() >= 54 ? elements.get(54).getTextContent() : ".000");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return player;
		
	}

	public static void main(String[] args) throws Exception {
		if(args.length == 0) new BRScraper();
		else new BRScraper(args[0], args[1], args[2], args[3]);
	}
}
