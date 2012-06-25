package baseball;

import org.fazio.simsports.baseball.builders.test.TestPlayerFromJSON;
import org.fazio.simsports.baseball.types.*;
import org.fazio.simsports.core.types.Player;
import org.fazio.simsports.core.types.Team;
import org.fazio.simsports.core.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/13/12 3:52 PM
 */
public class TestBaseballGame {

	private BaseballGame game;
	
	private String testLocationA = "Milwaukee";
	private String testMainShortNameA = "MIL";
	private String testNicknameA = "Brewers (2011)";
	private List<String> testShortNameListA = new ArrayList<String>();

	private String testLocationB = "Milwaukee";
	private String testMainShortNameB = "MIL";
	private String testNicknameB = "Brewers (Fazio)";
	private List<String> testShortNameListB = new ArrayList<String>();

	private final int tests = 50000;

	@Before
	public void setUp() throws Exception {

		final List<Player> testRosterA = this.setUpTeamRosters(this.setUpPlayerListA());
		final List<Player> testRosterB = this.setUpTeamRosters(this.setUpPlayerListB());

		final Team teamA = new BaseballTeam(this.testLocationA, this.testMainShortNameA, this.testNicknameA, testRosterA, this.testShortNameListA);
		final Team teamB = new BaseballTeam(this.testLocationB, this.testMainShortNameB, this.testNicknameB, testRosterA, this.testShortNameListB);
		
		this.game = new BaseballGame(teamA, teamB);
	}

	@Test
	public void testGames() throws Exception {
		this.testBaseballGame();

	}

	public void testBaseballGame() throws Exception {
		final BaseballTeam awayTeam = (BaseballTeam) this.game.getAwayTeam();
		final BaseballTeam homeTeam = (BaseballTeam) this.game.getHomeTeam();

		final Map<BaseballTeam, Integer> winTotals = new HashMap<BaseballTeam, Integer>();
		winTotals.put(awayTeam, 0);
		winTotals.put(homeTeam, 0);

		final Map<BaseballTeam, Integer> runTotals = new HashMap<BaseballTeam, Integer>();
		runTotals.put(awayTeam, 0);
		runTotals.put(homeTeam, 0);

		final Map<BaseballTeam, Integer> hitTotals = new HashMap<BaseballTeam, Integer>();
		hitTotals.put(awayTeam, 0);
		hitTotals.put(homeTeam, 0);

		final Bases bases = new Bases();

		for(int x=0;x<this.tests;x++) {
			int outs = 0;
			int inning = 1;
			InningPart partOfInning = InningPart.Top;

			BaseballTeam teamUpToBat = awayTeam;
			Map<Team, Integer> runMap = new HashMap<Team, Integer>() {
				{
					put(awayTeam , 0);
					put(homeTeam, 0);
				}
			};

			while(!this.isGameOver(inning, partOfInning, runMap.get(awayTeam), runMap.get(homeTeam))) {
				if(this.tests == 1) System.out.println("=== " + partOfInning + " of " + inning + " ===");
				//testMap.put(teamUpToBat, testMap.get(teamUpToBat) + 1);

				while(outs < 3) {
					if(inning >= 9 && teamUpToBat.equals(homeTeam) && (runMap.get(homeTeam) > runMap.get(awayTeam))) {
						break;
					}
					final BaseballPlayer upToBat = teamUpToBat.nextUpToBat();
					final PlateAppearanceResult hit = upToBat.getPlayResult();
					if(!hit.isOut() && (!hit.getSingleResult().equals(Results.BB) && !hit.getSingleResult().equals(Results.HBP))) hitTotals.put(teamUpToBat, hitTotals.get(teamUpToBat) + 1);
					if(this.tests == 1) System.out.println("PA Result = " + hit.getSingleResult());

					if(hit.isOut()) outs++;

					runMap.put(teamUpToBat, runMap.get(teamUpToBat) + bases.moveRunners(upToBat, hit));

					if(this.tests == 1) System.out.println("Runs = " + runMap.get(teamUpToBat) + ", Bases = " + bases);
				}

				outs = 0;
				bases.resetBases();
				if(this.tests == 1) System.out.print(awayTeam.getFullTeamName() + " " + runMap.get(awayTeam) + ", ");
				if(this.tests == 1) System.out.println(homeTeam.getFullTeamName() + " " + runMap.get(homeTeam));

				if(teamUpToBat.equals(awayTeam)) {
					teamUpToBat = homeTeam;
					partOfInning = InningPart.Bottom;
				} else {
					teamUpToBat = awayTeam;
					inning++;
					partOfInning = InningPart.Top;
				}
			}

			final int awayScore = runMap.get(awayTeam);
			final int homeScore = runMap.get(homeTeam);

			if(this.tests == 1) {
				System.out.print("Game " + (x + 1) + ": ");
				System.out.print(awayTeam.getFullTeamName() + " " + awayScore + ", ");
				System.out.print(homeTeam.getFullTeamName() + " " + homeScore);
				if((inning - 1) > 9) System.out.print(" (" + (inning - 1) + " innings)");
				System.out.println();
			}

			runTotals.put(awayTeam, runTotals.get(awayTeam) + awayScore);
			runTotals.put(homeTeam, runTotals.get(homeTeam) + homeScore);

			if(awayScore > homeScore) winTotals.put(awayTeam, winTotals.get(awayTeam) + 1);
			else if(homeScore > awayScore) winTotals.put(homeTeam, winTotals.get(homeTeam) + 1);

			if(x%(this.tests / 10) == 0 && x > 0) {
				System.out.println(x + " games played.");
				printGameTotals(awayTeam, homeTeam, winTotals, runTotals, hitTotals, false);
			}
		}

		printGameTotals(awayTeam, homeTeam, winTotals, runTotals, hitTotals, true);

		//if(testMap.get(awayTeam).intValue() != testMap.get(homeTeam).intValue()) {
		//	System.out.println("!!FAZIO TEST VALUES WRONG!!");
		//	this.wrong = true;
		//}
		//System.out.println("Test Value for " + awayTeam.getFullTeamName() + ": " + testMap.get(awayTeam));
		//System.out.println("Test Value for " + homeTeam.getFullTeamName() + ": " + testMap.get(homeTeam));

	}

	private void printGameTotals(
		final BaseballTeam awayTeam,
		final BaseballTeam homeTeam,
		final Map<BaseballTeam, Integer> winTotals,
		final Map<BaseballTeam, Integer> runTotals,
		final Map<BaseballTeam, Integer> hitTotals,
		final boolean printFullTotals) {

		System.out.println(awayTeam.getFullTeamName() + " wins: " + winTotals.get(awayTeam));
		System.out.println(homeTeam.getFullTeamName() + " wins: " + winTotals.get(homeTeam));

		if(printFullTotals) {
			System.out.println(awayTeam.getFullTeamName() + " runs scored: " + runTotals.get(awayTeam) + " (" + ((double)runTotals.get(awayTeam) / (double)this.tests) + " per game)");
			System.out.println(homeTeam.getFullTeamName() + " runs scored: " + runTotals.get(homeTeam) + " (" + ((double)runTotals.get(homeTeam) / (double)this.tests) + " per game)");
			System.out.println(awayTeam.getFullTeamName() + " hits: " + hitTotals.get(awayTeam) + " (" + ((double)hitTotals.get(awayTeam) / (double)this.tests) + " per game)");
			System.out.println(homeTeam.getFullTeamName() + " hits: " + hitTotals.get(homeTeam) + " (" + ((double)hitTotals.get(homeTeam) / (double)this.tests) + " per game)");
		}
		System.out.println();
	}

	private List<Player> setUpTeamRosters(final List<Pair<String, Integer>> playerInfo) throws Exception {

		final List<Player> players = new ArrayList<Player>();

		for(Pair<String, Integer> info : playerInfo) {
			final BaseballPlayer testPlayer = new TestPlayerFromJSON().createPlayer(info.getLeft(), info.getRight());
			players.add(testPlayer);
		}

		return players;
	}

	private boolean isGameOver(final int inning, final InningPart partOfInning, final int awayScore, final int homeScore) {
		boolean gameOver = false;

		if(inning > 9 && partOfInning.equals(InningPart.Top) && (awayScore != homeScore)) gameOver = true;

		return gameOver;
	}

	private List<Pair<String, Integer>> setUpPlayerListA() throws Exception {
		final int year = 2011;

		final List<Pair<String, Integer>> playerList = new ArrayList<Pair<String, Integer>>(){{
			add(new Pair<String, Integer>("Corey Hart", year));
			add(new Pair<String, Integer>("Nyjer Morgan", year));
			add(new Pair<String, Integer>("Ryan Braun", year));
			add(new Pair<String, Integer>("Prince Fielder", year));
			add(new Pair<String, Integer>("Rickie Weeks", year));
			add(new Pair<String, Integer>("Casey McGehee", year));
			add(new Pair<String, Integer>("Yuniesky Betancourt", year));
			add(new Pair<String, Integer>("Carlos Gomez", year));
			add(new Pair<String, Integer>("Jonathan Lucroy", year));
		}};

		return playerList;
	}
	private List<Pair<String, Integer>> setUpPlayerListB() throws Exception {
		final int year = 2011;

		final List<Pair<String, Integer>> playerList = new ArrayList<Pair<String, Integer>>(){{
			add(new Pair<String, Integer>("Jonathan Lucroy", year));
			add(new Pair<String, Integer>("Casey McGehee", year));
			add(new Pair<String, Integer>("Ryan Braun", year));
			add(new Pair<String, Integer>("League Totals", year));
			add(new Pair<String, Integer>("Carlos Gomez", year));
			add(new Pair<String, Integer>("Nyjer Morgan", year));
			add(new Pair<String, Integer>("Corey Hart", year));
			add(new Pair<String, Integer>("Rickie Weeks", year));
			add(new Pair<String, Integer>("Yuniesky Betancourt", year));
			//add(new Pair<String, Integer>("Prince Fielder", year));
		}};

		return playerList;
	}

	protected enum InningPart {Top, Bottom};

}
