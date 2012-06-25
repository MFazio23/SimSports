package org.fazio.simsports.core.types;

import java.util.List;

/**
 * @author Michael Fazio
 */
public class Team {
	
	protected final String location;
	protected final String nickname;
	protected final String mainShortName;
	protected final List<String> shortNameList;
	protected final List<Player> roster;

	public Team(final String location, final String mainShortName, final String nickname, final List<Player> roster, final List<String> shortNameList) {
		this.location = location;
		this.mainShortName = mainShortName;
		this.nickname = nickname;
		this.roster = roster;
		this.shortNameList = shortNameList;
	}

	public String getLocation() {
		return location;
	}

	public String getMainShortName() {
		return mainShortName;
	}

	public String getNickname() {
		return nickname;
	}

	public List<Player> getRoster() {
		return roster;
	}

	public List<String> getShortNameList() {
		return shortNameList;
	}

	public String getFullTeamName() {
		return location + " " + nickname;
	}
}
