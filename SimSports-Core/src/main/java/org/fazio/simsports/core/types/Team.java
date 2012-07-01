package org.fazio.simsports.core.types;

import java.awt.*;
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
	protected final List<Color> teamColors;

	public Team(
		final String location,
		final String mainShortName,
		final String nickname,
		final List<Player> roster,
		final List<String> shortNameList,
		final List<Color> teamColors) {
			this.location = location;
			this.mainShortName = mainShortName;
			this.nickname = nickname;
			this.roster = roster;
			this.shortNameList = shortNameList;
			this.teamColors = teamColors;
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

	public List<Color> getTeamColors() {
		return teamColors;
	}

	public Color getPrimaryColor() {
		Color color = Color.BLACK;
		if(this.teamColors.size() > 0) color = this.teamColors.get(0);
		return color;
	}

	public Color getSecondaryColor() {
		Color color = Color.WHITE;
		if(this.teamColors.size() > 1) color = this.teamColors.get(1);
		return color;
	}

	public Color getTertiaryColor() {
		Color color = Color.BLACK;
		if(this.teamColors.size() > 2) color = this.teamColors.get(2);
		return color;
	}
}
