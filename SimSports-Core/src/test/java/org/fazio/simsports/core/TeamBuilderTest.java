package org.fazio.simsports.core;

import org.fazio.simsports.core.builders.TeamBuilder;
import org.fazio.simsports.core.types.Player;
import org.fazio.simsports.core.types.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Michael Fazio
 */
public class TeamBuilderTest {
	
	private final String testLocation = "Milwaukee";
	private final String testNickname = "Brewers";
	private final String testShortName = "MIL";
	private final Set<Player> testRoster = this.buildTestRoster();
	private final Set<String> testShortNameList = this.buildTestShortNameList();
	
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void testProperTeamBuilder() throws Exception {
		Team testTeam
			= new TeamBuilder()
				.addToRoster(this.testRoster)
				.addToShortNameList(this.testShortNameList)
				.setLocation(this.testLocation)
				.setMainShortName(this.testShortName)
				.setNickname(this.testNickname)
				.build();

		this.validateTestValues(testTeam);
	}

	private void validateTestValues(Team testTeam) {
		assertEquals("The locations are not equal.", this.testLocation, testTeam.getLocation());
		assertEquals("The nicknames are not equal.", this.testNickname, testTeam.getNickname());
		assertEquals("The shortened team names are not equal.", this.testShortName, testTeam.getMainShortName());
		assertEquals("The sizes of the rosters are not equal.", this.testRoster.size(), testTeam.getRoster().size());

		//The main short name for a team is automatically added to the short name list.  If the name is already part of the short name list, then
		int shortNameListSize = this.testShortNameList.size();
		if(!this.testShortNameList.contains(this.testShortName)) {
			shortNameListSize++;
		}
		assertEquals("The sizes of the short name lists are not equal.", shortNameListSize, testTeam.getShortNameList().size());
	}

	private Set<Player> buildTestRoster() {
		final Set<Player> testRoster = new HashSet<Player>();
		
		testRoster.add(new Player(TestPosition.GENERIC, "Test Player", "Test", "Player"));
		
		return testRoster;
	}
	
	private Set<String> buildTestShortNameList() {
		final Set<String> testShortNameList = new HashSet<String>();

		testShortNameList.add("GNN");
		testShortNameList.add("BAS");
		testShortNameList.add("GTN");

		return testShortNameList;
	}
}
