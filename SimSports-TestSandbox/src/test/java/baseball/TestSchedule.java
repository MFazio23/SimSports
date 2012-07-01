package baseball;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
			final String team = String.valueOf((char)(x + Character.valueOf('A')));
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
		final String matchupJSON = new StringBuilder()
			.append("{\"matchups\":[")
			.append("[").append("[1,2],").append("[3,4],").append("[5,6]").append("],")
			.append("[").append("[1,3],").append("[2,5],").append("[4,6]").append("],")
			.append("[").append("[1,4],").append("[2,6],").append("[3,5]").append("],")
			.append("[").append("[1,5],").append("[2,4],").append("[3,6]").append("],")
			.append("[").append("[1,6],").append("[2,3],").append("[4,5]").append("]")
			.append("]}")
			.toString();

		System.out.println(matchupJSON);
		JSONArray matchups = new JSONObject(matchupJSON).getJSONArray("matchups");
		List<JSONArray> matchupList = new LinkedList<JSONArray>();
		for(int x=0;x<matchups.length();x++) {
			JSONArray matchup = matchups.getJSONArray(x);
			matchupList.add(matchup);
		}

		while(matchupList.size() > 0) {
			int matchupInd = (int)(Math.random() * matchupList.size());
			JSONArray selectedMatchup = matchupList.get(matchupInd);
			System.out.println("Matchup #" + (matchupInd + 1));
			for(int x=0;x<selectedMatchup.length();x++) {
				String teamA = division1.get(selectedMatchup.getJSONArray(x).getInt(0) - 1);
				String teamB = division1.get(selectedMatchup.getJSONArray(x).getInt(1) - 1);
				int homeAway = (int)(Math.random() * 2);
				if(homeAway == 0) System.out.print(teamA + "@" + teamB + " ");
				else System.out.print(teamB + "@" + teamA + " ");
			}
			System.out.println();
			matchupList.remove(matchupInd);
		}
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

	@Test
	public void testScheduleFormat() throws Exception {
		System.out.println(this.getRandomInDivisionMatchups());
		System.out.println(this.getRandomInDivisionMatchups());
		System.out.println(this.getRandomOutOfDivisionMatchups());
		System.out.println(this.getRandomInDivisionMatchups());
		System.out.println(this.getRandomInDivisionMatchups());

		System.out.println(this.getRandomInDivisionMatchups());
		System.out.println(this.getRandomInDivisionMatchups());
		System.out.println(this.getRandomOutOfDivisionMatchups());
		System.out.println(this.getRandomInDivisionMatchups());
		System.out.println(this.getRandomInDivisionMatchups());
	}

	private String getRandomInDivisionMatchups() {
		return "D";
	}

	private String getRandomOutOfDivisionMatchups() {
		return "I";
	}

	public class Scheduler {

		private final List<String> teams;

		public Scheduler(final List<String> teams) {
			this.teams = teams;
		}

	}

}
