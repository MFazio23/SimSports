package baseball;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;


/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/30/12 12:21 PM
 */
public class TestSchedule {

	private int gamesPlayed = 156;
	private int teamCount = 12;
	private int homeGames = this.gamesPlayed / 2;
	private int divisions = 2;
	private int inDivGames = 24;
	private int nonDivGames = 6;
	private List<String> division1 = new ArrayList<String>();
	private List<String> division2 = new ArrayList<String>();
	Map<Matchup, Integer> matchups = new HashMap<Matchup, Integer>();

	private List<String> teams = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {
		for(int x=0;x<teamCount;x++) {
			final String team = "Team " + (x + 1);
			teams.add(team);
			if(x<6) division1.add(team);
			else division2.add(team);
		}
		for(String mainTeam : division1) {
			for(String inDivTeam : division1) {
				if(!mainTeam.equals(inDivTeam)) {
					Matchup homeMatchup = new Matchup(mainTeam, inDivTeam);
					Matchup awayMatchup = new Matchup(inDivTeam, mainTeam);
					if(!matchups.containsKey(homeMatchup)) matchups.put(homeMatchup, this.inDivGames/6);
					if(!matchups.containsKey(awayMatchup)) matchups.put(awayMatchup, this.inDivGames/6);
				}
			}
			for(String nonDivTeam : division2) {
				Matchup homeMatchup = new Matchup(mainTeam, nonDivTeam);
				Matchup awayMatchup = new Matchup(nonDivTeam, mainTeam);
				if(!matchups.containsKey(homeMatchup)) matchups.put(homeMatchup, this.nonDivGames/6);
				if(!matchups.containsKey(awayMatchup)) matchups.put(awayMatchup, this.nonDivGames/6);
			}
		}

		for(String mainTeam : division2) {
			for(String inDivTeam : division2) {
				if(!mainTeam.equals(inDivTeam)) {
					Matchup homeMatchup = new Matchup(mainTeam, inDivTeam);
					Matchup awayMatchup = new Matchup(inDivTeam, mainTeam);
					if(!matchups.containsKey(homeMatchup)) matchups.put(homeMatchup, this.inDivGames/6);
					if(!matchups.containsKey(awayMatchup)) matchups.put(awayMatchup, this.inDivGames/6);
				}
			}
			for(String nonDivTeam : division1) {
				Matchup homeMatchup = new Matchup(mainTeam, nonDivTeam);
				Matchup awayMatchup = new Matchup(nonDivTeam, mainTeam);
				if(!matchups.containsKey(homeMatchup)) matchups.put(homeMatchup, this.nonDivGames/6);
				if(!matchups.containsKey(awayMatchup)) matchups.put(awayMatchup, this.nonDivGames/6);
			}
		}
	}

	@Test
	public void testMatchupCount() throws Exception {
		int matchupCount = 0;
		for(Integer value : matchups.values()) matchupCount += value;

		assertEquals(312, matchupCount);
		System.out.println("Games Played : " + ((this.inDivGames * 5) + (this.nonDivGames * 6)));
	}

	@Test
	public void testMatchupTemplates() throws Exception {

	}

	private class Matchup {
		private final String home;
		private final String away;

		public Matchup(final String home, final String away) {
			this.home = home;
			this.away = away;
		}

		public String getHome() {
			return home;
		}

		public String getAway() {
			return away;
		}

		@Override
		public boolean equals(final Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			final Matchup matchup = (Matchup) o;

			if (away != null ? !away.equals(matchup.away) : matchup.away != null) return false;
			if (home != null ? !home.equals(matchup.home) : matchup.home != null) return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = home != null ? home.hashCode() : 0;
			result = 31 * result + (away != null ? away.hashCode() : 0);
			return result;
		}

		@Override
		public String toString() {
			return this.away + "@" + this.home;
		}
	}

}
