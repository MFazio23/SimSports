package org.fazio.simsports.core;

import java.util.List;

/**
 * @author Michael Fazio
 */
public class Team {
	
	private final String location;
	private final String nickname;
	private final String mainShortName;
	private final List<String> shortNameList;
	private final List<Player> roster;

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
}
