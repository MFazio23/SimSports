package org.fazio.simsports.baseball.builders.test;

import org.fazio.simsports.baseball.builders.BattingAttributesByPABuilder;
import org.fazio.simsports.baseball.types.BaseballPosition;
import org.fazio.simsports.baseball.types.attributes.BatterAttributes;
import org.fazio.simsports.core.builders.TeamBuilder;
import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Team;
import org.mockito.Mockito;

/**
 * @author Michael Fazio
 */
public class RyanBraunTestPlayerBuilder extends TestPlayerBuilder {

	public RyanBraunTestPlayerBuilder() {
		super();
	}

	@Override
	protected void setUpTestPlayer() {
		super.setUpTestPlayer();
		this.firstName = "Ryan";
		this.lastName = "Braun";
		this.nickname = "Brauny";
		this.team = this.setUpTeam();
		this.position = BaseballPosition.Left_Field;
		this.attributes = this.setUpAttributes();
	}

	public Team setUpTeam() {

		return new TeamBuilder()
			.setLocation("Milwaukee")
			.setNickname("Brewers")
			.setMainShortName("MIL")
			.build();
	}

	public Attributes setUpAttributes() {
		final Attributes battingAttributes	= new BattingAttributesByPABuilder()
			.setStrikeoutChance(14.8)
			.setWalkChance(9.2)
			.setStrikeoutLookingChance(15)
			.setHitByPitchChance(0.8)
			.setContactFlyBallChance(35.1)
			.setContactGroundBallChance(42.8)
			.setContactLineDriveChance(22.1)
			.setFlyBallSingleChance(3.64)
			.setFlyBallDoubleChance(7.88)
			.setFlyBallTripleChance(0)
			.setFlyBallHomeRunChance(16.97)
			.setGroundBallSingleChance(26.37)
			.setGroundBallDoubleChance(1.49)
			.setGroundBallTripleChance(0)
			.setGroundBallHomeRunChance(0)
			.setLineDriveSingleChance(49.04)
			.setLineDriveDoubleChance(21.15)
			.setLineDriveTripleChance(5.77)
			.setLineDriveHomeRunChance(4.81)
			.build();

		return new BatterAttributes(battingAttributes, Mockito.mock(Attributes.class), Mockito.mock(Attributes.class));
	}
}
