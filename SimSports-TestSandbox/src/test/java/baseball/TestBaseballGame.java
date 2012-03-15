package baseball;

import org.fazio.simsports.baseball.types.BaseballGame;
import org.fazio.simsports.core.types.Player;
import org.fazio.simsports.core.types.Team;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		while(!this.game.isGameOver()) {

		}
	}

}
