package org.fazio.simsports.core.builders;

import org.fazio.simsports.core.types.Player;
import org.fazio.simsports.core.types.Team;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Michael Fazio
 */
public class TeamBuilder {

	protected String location;
	protected String nickname;
	protected String mainShortName;
	protected final List<String> shortNameList = new ArrayList<String>();
	protected final List<Player> roster = new ArrayList<Player>();
	protected final List<Color> teamColors = new ArrayList<Color>();
	
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

	public TeamBuilder addToShortNameList(final Collection<String> shortNames) {
		this.shortNameList.addAll(shortNames);
		return this;
	}
	
	public TeamBuilder addToTeamColors(final Color color) {
		this.teamColors.add(color);
		return this;
	}

	public TeamBuilder addToTeamColors(final Collection<Color> colors) {
		this.teamColors.addAll(colors);
		return this;
	}
	
	public Team build() {
		return new Team(
			this.location,
			this.mainShortName,
			this.nickname,
			this.roster,
			this.shortNameList,
			this.teamColors);
	}
}
