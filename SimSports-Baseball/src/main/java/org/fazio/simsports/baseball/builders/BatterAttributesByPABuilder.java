package org.fazio.simsports.baseball.builders;

import org.fazio.simsports.baseball.types.BatterAttributesByPA;

/**
 * @author Michael Fazio
 */
public class BatterAttributesByPABuilder {

	private double hitByPitchChance;
	private double walkChance;
	private double strikeoutChance;
	private double contactChance;

	private double strikeoutLookingChance;
	private double strikeoutSwingingChance;

	private double contactGroundBallChance;
	private double contactLineDriveChance;
	private double contactFlyBallChance;

	private double groundBallOutChance;
	private double groundBallSingleChance;
	private double groundBallDoubleChance;
	private double groundBallTripleChance;
	private double groundBallHomeRunChance;

	private double lineDriveOutChance;
	private double lineDriveSingleChance;
	private double lineDriveDoubleChance;
	private double lineDriveTripleChance;
	private double lineDriveHomeRunChance;

	private double flyBallOutChance;
	private double flyBallSingleChance;
	private double flyBallDoubleChance;
	private double flyBallTripleChance;
	private double flyBallHomeRunChance;

	public BatterAttributesByPABuilder setContactChance(double contactChance) {
		this.contactChance = contactChance;
		return this;
	}

	public BatterAttributesByPABuilder setContactFlyBallChance(double contactFlyBallChance) {
		this.contactFlyBallChance = contactFlyBallChance;
		return this;
	}

	public BatterAttributesByPABuilder setContactGroundBallChance(double contactGroundBallChance) {
		this.contactGroundBallChance = contactGroundBallChance;
		return this;
	}

	public BatterAttributesByPABuilder setContactLineDriveChance(double contactLineDriveChance) {
		this.contactLineDriveChance = contactLineDriveChance;
		return this;
	}

	public BatterAttributesByPABuilder setFlyBallDoubleChance(double flyBallDoubleChance) {
		this.flyBallDoubleChance = flyBallDoubleChance;
		return this;
	}

	public BatterAttributesByPABuilder setFlyBallHomeRunChance(double flyBallHomeRunChance) {
		this.flyBallHomeRunChance = flyBallHomeRunChance;
		return this;
	}

	public BatterAttributesByPABuilder setFlyBallOutChance(double flyBallOutChance) {
		this.flyBallOutChance = flyBallOutChance;
		return this;
	}

	public BatterAttributesByPABuilder setFlyBallSingleChance(double flyBallSingleChance) {
		this.flyBallSingleChance = flyBallSingleChance;
		return this;
	}

	public BatterAttributesByPABuilder setFlyBallTripleChance(double flyBallTripleChance) {
		this.flyBallTripleChance = flyBallTripleChance;
		return this;
	}

	public BatterAttributesByPABuilder setGroundBallDoubleChance(double groundBallDoubleChance) {
		this.groundBallDoubleChance = groundBallDoubleChance;
		return this;
	}

	public BatterAttributesByPABuilder setGroundBallHomeRunChance(double groundBallHomeRunChance) {
		this.groundBallHomeRunChance = groundBallHomeRunChance;
		return this;
	}

	public BatterAttributesByPABuilder setGroundBallOutChance(double groundBallOutChance) {
		this.groundBallOutChance = groundBallOutChance;
		return this;
	}

	public BatterAttributesByPABuilder setGroundBallSingleChance(double groundBallSingleChance) {
		this.groundBallSingleChance = groundBallSingleChance;
		return this;
	}

	public BatterAttributesByPABuilder setGroundBallTripleChance(double groundBallTripleChance) {
		this.groundBallTripleChance = groundBallTripleChance;
		return this;
	}

	public BatterAttributesByPABuilder setHitByPitchChance(double hitByPitchChance) {
		this.hitByPitchChance = hitByPitchChance;
		return this;
	}

	public BatterAttributesByPABuilder setLineDriveDoubleChance(double lineDriveDoubleChance) {
		this.lineDriveDoubleChance = lineDriveDoubleChance;
		return this;
	}

	public BatterAttributesByPABuilder setLineDriveHomeRunChance(double lineDriveHomeRunChance) {
		this.lineDriveHomeRunChance = lineDriveHomeRunChance;
		return this;
	}

	public BatterAttributesByPABuilder setLineDriveOutChance(double lineDriveOutChance) {
		this.lineDriveOutChance = lineDriveOutChance;
		return this;
	}

	public BatterAttributesByPABuilder setLineDriveSingleChance(double lineDriveSingleChance) {
		this.lineDriveSingleChance = lineDriveSingleChance;
		return this;
	}

	public BatterAttributesByPABuilder setLineDriveTripleChance(double lineDriveTripleChance) {
		this.lineDriveTripleChance = lineDriveTripleChance;
		return this;
	}

	public BatterAttributesByPABuilder setStrikeoutChance(double strikeoutChance) {
		this.strikeoutChance = strikeoutChance;
		return this;
	}

	public BatterAttributesByPABuilder setStrikeoutLookingChance(double strikeoutLookingChance) {
		this.strikeoutLookingChance = strikeoutLookingChance;
		return this;
	}

	public BatterAttributesByPABuilder setStrikeoutSwingingChance(double strikeoutSwingingChance) {
		this.strikeoutSwingingChance = strikeoutSwingingChance;
		return this;
	}

	public BatterAttributesByPABuilder setWalkChance(double walkChance) {
		this.walkChance = walkChance;
		return this;
	}

	public BatterAttributesByPA build() {
		return new BatterAttributesByPA(
			this.contactChance,
			this.contactFlyBallChance,
			this.contactGroundBallChance,
			this.contactLineDriveChance,
			this.flyBallDoubleChance,
			this.flyBallHomeRunChance,
			this.flyBallOutChance,
			this.flyBallSingleChance,
			this.flyBallTripleChance,
			this.groundBallDoubleChance,
			this.groundBallHomeRunChance,
			this.groundBallOutChance,
			this.groundBallSingleChance,
			this.groundBallTripleChance,
			this.hitByPitchChance,
			this.lineDriveDoubleChance,
			this.lineDriveHomeRunChance,
			this.lineDriveOutChance,
			this.lineDriveSingleChance,
			this.lineDriveTripleChance,
			this.strikeoutChance,
			this.strikeoutLookingChance,
			this.strikeoutSwingingChance,
			this.walkChance);
	}
}
