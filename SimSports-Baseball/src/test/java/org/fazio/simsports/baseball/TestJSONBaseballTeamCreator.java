package org.fazio.simsports.baseball;

import org.fazio.simsports.baseball.builders.JSONBaseballTeamCreator;
import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.fazio.simsports.baseball.types.BaseballTeam;
import org.fazio.simsports.core.types.Player;
import org.junit.Test;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/29/12 8:50 AM
 */
public class TestJSONBaseballTeamCreator {

	@Test
	public void testTeamCreator() throws Exception {
		JSONBaseballTeamCreator creator = new JSONBaseballTeamCreator();

		BaseballTeam novas = creator.createTeam("Wisconsin Knights");
		BaseballTeam sonics = creator.createTeam("Oklahoma City Sonics");

		System.out.println(novas);

		for(Player player : novas.getRoster()) {
			final BaseballPlayer baseballPlayer = (BaseballPlayer) player;
			System.out.println(baseballPlayer.getRatingsAndInfo());
		}
	}
}
