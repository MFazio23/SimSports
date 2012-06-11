package org.fazio.simsports.builders;

import org.fazio.simsports.baseball.builders.BatterAttributesByPABuilder;
import org.fazio.simsports.baseball.types.BaseballPosition;
import org.fazio.simsports.core.builders.PlayerBuilder;
import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Position;

/**
 * @author Michael Fazio
 */
public class TestPlayerRyanBraunBuilder extends TestPlayerBuilder {

	@Override
	public TestPlayerBuilder setFirstName(final String firstName) {
		this.firstName = "Ryan";
		return this;
	}

	@Override
	public PlayerBuilder setLastName(final String lastName) {
		this.lastName = "Braun";
		return this;
	}

	@Override
	public PlayerBuilder setNickname(final String nickname) {
		this.nickname = "Brauny";
		return this;
	}

	@Override
	public PlayerBuilder setPosition(final Position position) {
		this.position = BaseballPosition.Left_Field;
		return this;
	}

	@Override
	public TestPlayerBuilder setAttributes(final Attributes attributes) {
		this.attributes	= new BatterAttributesByPABuilder()
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

		return this;
	}
}
