package org.fazio.simsports.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Michael Fazio
 */
public class TeamBuilder {

	private String location;
	private String nickname;
	private String mainShortName;
	private final List<String> shortNameList = new ArrayList<String>();
	private final List<Player> roster = new ArrayList<Player>();
	
	public TeamBuilder setLocation(final String location) {
		this.location = location;
		return this;
	}

	public TeamBuilder setMainShortName(final String mainShortName) {
		this.mainShortName = mainShortName;
		this.shortNameList.add(mainShortName);
		return this;
	}

	public TeamBuilder setNickname(final String nickname) {
		this.nickname = nickname;
		return this;
	}

	public TeamBuilder addToRoster(final Player player) {
		this.roster.add(player);
		return this;
	}
	
	public TeamBuilder addToRoster(final Collection<Player> roster) {
		this.roster.addAll(roster);
		return this;
	}
	
	public TeamBuilder addToShortNameList(final String shortName) {
		this.shortNameList.add(shortName);
		return this;
	}

	public TeamBuilder addToShortNameList(final Collection<String> shortNameList) {
		this.shortNameList.addAll(shortNameList);
		return this;
	}
	
	public Team build() {
		return new Team(this.location, this.mainShortName, this.nickname, this.roster, this.shortNameList);
	}
}
