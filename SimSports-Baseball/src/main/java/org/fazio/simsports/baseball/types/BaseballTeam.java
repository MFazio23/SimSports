package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.Player;
import org.fazio.simsports.core.types.Team;

import java.awt.*;
import java.util.List;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/18/12 11:13 AM
 */
public class BaseballTeam extends Team {

	private BaseballPlayer upToBat;

	public BaseballTeam(
		final String location,
		final String mainShortName,
		final String nickname,
		final List<Player> roster,
		final List<String> shortNameList,
		final List<Color> teamColors) {

			super(location, mainShortName, nickname, roster, shortNameList, teamColors);

			this.upToBat = this.roster.size() > 0 ? (BaseballPlayer) this.roster.get(0) : null;
	}

	public BaseballPlayer nextUpToBat() {
		final BaseballPlayer nowUpToBat = this.upToBat;

		int atBatIndex = this.roster.indexOf(this.upToBat) + 1;
		if(atBatIndex >= 9) {
			atBatIndex = 0;
		}

		this.upToBat = (BaseballPlayer) this.roster.get(atBatIndex);
		return nowUpToBat;
	}
}
