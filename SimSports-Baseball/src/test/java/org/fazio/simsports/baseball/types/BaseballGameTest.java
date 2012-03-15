package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/13/12 3:56 PM
 */
public class BaseballGameTest {

	private BaseballGame game;
	
	@Before
	public void setUp() throws Exception {
		this.game = new BaseballGame(mock(Team.class), mock(Team.class));
	}
	
	@Test
	public void testBaseballGameStart() throws Exception {
		assertEquals("The away team's runs do not start at 0", 0, this.game.getAwayScore());
		assertEquals("The home team's runs do not start at 0", 0, this.game.getHomeScore());
		
		assertEquals("The inning does not start at 1", 1, this.game.getInning());
		assertEquals("The outs do not start at 0", 0, this.game.getOuts());
		assertEquals("The inning does not start at the top", true, this.game.isTopOfInning());
	}
	
	@Test
	public void testBaseballGameAddScores() throws Exception {
		this.game.addToAwayScore(3);
		assertEquals("The away score is incorrect.", 3, this.game.getAwayScore());
		assertEquals("The home score is incorrect.", 0, this.game.getHomeScore());
		
		this.game.addToHomeScore(1);
		assertEquals("The away score is incorrect.", 3, this.game.getAwayScore());
		assertEquals("The home score is incorrect.", 1, this.game.getHomeScore());

		this.game.addToAwayScore(2);
		this.game.addToAwayScore(1);
		this.game.addToAwayScore(1);
		this.game.addToHomeScore(3);
		this.game.addToHomeScore(4);
		this.game.addToAwayScore(2);
		assertEquals("The away score is incorrect.", 9, this.game.getAwayScore());
		assertEquals("The home score is incorrect.", 8, this.game.getHomeScore());
	}
	
	@Test
	public void testBaseballGameAddOuts() throws Exception {
		assertEquals("The game did not default to 0 outs.", 0, this.game.getOuts());
		
		this.game.addOut();
		assertEquals("The out count is not correct.", 1, this.game.getOuts());
		assertEquals("The top/bottom of the inning indicator is incorrect.", true, this.game.isTopOfInning());
		assertEquals("The inning is incorrect", 1, this.game.getInning());
		
		this.game.addOuts(1);
		assertEquals("The out count is not correct.", 2, this.game.getOuts());
		assertEquals("The top/bottom of the inning indicator is incorrect.", true, this.game.isTopOfInning());
		assertEquals("The inning is incorrect", 1, this.game.getInning());

		this.game.addOuts(1);
		assertEquals("The out count is not correct.", 0, this.game.getOuts());
		assertEquals("The top/bottom of the inning indicator is incorrect.", false, this.game.isTopOfInning());
		assertEquals("The inning is incorrect", 1, this.game.getInning());

		this.game.addOuts(2);
		assertEquals("The out count is not correct.", 2, this.game.getOuts());
		assertEquals("The top/bottom of the inning indicator is incorrect.", false, this.game.isTopOfInning());
		assertEquals("The inning is incorrect", 1, this.game.getInning());

		this.game.addOut();
		assertEquals("The out count is not correct.", 0, this.game.getOuts());
		assertEquals("The top/bottom of the inning indicator is incorrect.", true, this.game.isTopOfInning());
		assertEquals("The inning is incorrect", 2, this.game.getInning());

		this.game.addOut();
		this.game.addOut();
		assertEquals("The out count is not correct.", 2, this.game.getOuts());
		assertEquals("The top/bottom of the inning indicator is incorrect.", true, this.game.isTopOfInning());
		assertEquals("The inning is incorrect", 2, this.game.getInning());

		this.game.addOuts(4);
		assertEquals("The out count is not correct.", 0, this.game.getOuts());
		assertEquals("The top/bottom of the inning indicator is incorrect.", false, this.game.isTopOfInning());
		assertEquals("The inning is incorrect", 2, this.game.getInning());

		this.game.addOuts(3);
		assertEquals("The out count is not correct.", 0, this.game.getOuts());
		assertEquals("The top/bottom of the inning indicator is incorrect.", true, this.game.isTopOfInning());
		assertEquals("The inning is incorrect", 3, this.game.getInning());

	}

}
