package baseball;

import org.fazio.simsports.baseball.builders.test.RyanBraunTestPlayerBuilder;
import org.fazio.simsports.baseball.types.BaseballGame;
import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.fazio.simsports.baseball.types.Bases;
import org.fazio.simsports.baseball.types.PlateAppearanceResult;
import org.fazio.simsports.core.types.Player;
import org.fazio.simsports.core.types.Team;
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
	private String testNicknameA = "Brewers";
	private List<Player> testRosterA = new LinkedList<Player>();
	private List<String> testShortNameListA = new ArrayList<String>();

	private String testLocationB = "Atlanta";
	private String testMainShortNameB = "ATL";
	private String testNicknameB = "Braves";
	private List<Player> testRosterB = new LinkedList<Player>();
	private List<String> testShortNameListB = new ArrayList<String>();
	
	public void setUp() throws Exception {
		
		Team teamA = new Team(this.testLocationA, this.testMainShortNameA, this.testNicknameA, this.testRosterA, this.testShortNameListA);
		Team teamB = new Team(this.testLocationB, this.testMainShortNameB, this.testNicknameB, this.testRosterB, this.testShortNameListB);
		
		this.game = new BaseballGame(teamA, teamB);
	}

	@Test
	public void testBaseballGame() throws Exception {
		final Bases bases = new Bases();
		int outs = 0;
		int inning = 1;
		Teams team = Teams.Away;
		Map<Teams, Integer> runMap = new HashMap<Teams, Integer>() {
			{
				put(Teams.Home, 0);
				put(Teams.Away, 0);
			}
		};

		while(inning <= 9) {
			System.out.println("=== Inning " + inning + " ===");
			while(outs < 3) {
				final BaseballPlayer braun = new RyanBraunTestPlayerBuilder().build();
				final PlateAppearanceResult hit = (PlateAppearanceResult)braun.getPlayResult();

				System.out.println("PA Result = " + hit);

				if(hit.isOut()) outs++;

				runMap.put(team, runMap.get(team) + bases.moveRunners(braun, hit));

				System.out.println("Runs = " + runMap.get(team) + ", Bases = " + bases);
			}

			outs = 0;

			if(team.equals(Teams.Away)) {
				team = Teams.Home;
			} else {
				team = Teams.Away;
				System.out.println("Inning Over");
				inning++;
			}
		}

		System.out.println("Away Team = " + runMap.get(Teams.Away));
		System.out.println("Home Team = " + runMap.get(Teams.Home));
	}

	public enum Teams {Home, Away};

}
