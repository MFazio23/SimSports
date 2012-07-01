package org.fazio.simsports.baseball.builders;

import org.fazio.simsports.baseball.types.BaseballTeam;
import org.fazio.simsports.core.builders.TeamBuilder;
import org.fazio.simsports.core.types.Team;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/29/12 8:42 AM
 */
public class BaseballTeamBuilder extends TeamBuilder {

	@Override
	public Team build() {
		return new BaseballTeam(
			this.location,
			this.mainShortName,
			this.nickname,
			this.roster,
			this.shortNameList,
			this.teamColors);
	}
}
