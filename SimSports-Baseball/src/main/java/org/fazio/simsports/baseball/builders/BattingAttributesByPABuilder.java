package org.fazio.simsports.baseball.builders;

import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPA;

/**
 * @author Michael Fazio
 */
public class BattingAttributesByPABuilder {

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

	public BattingAttributesByPABuilder setContactChance(double contactChance) {
		this.contactChance = contactChance;
		return this;
	}

	public BattingAttributesByPABuilder setContactFlyBallChance(double contactFlyBallChance) {
		this.contactFlyBallChance = contactFlyBallChance;
		return this;
	}

	public BattingAttributesByPABuilder setContactGroundBallChance(double contactGroundBallChance) {
		this.contactGroundBallChance = contactGroundBallChance;
		return this;
	}

	public BattingAttributesByPABuilder setContactLineDriveChance(double contactLineDriveChance) {
		this.contactLineDriveChance = contactLineDriveChance;
		return this;
	}

	public BattingAttributesByPABuilder setFlyBallDoubleChance(double flyBallDoubleChance) {
		this.flyBallDoubleChance = flyBallDoubleChance;
		return this;
	}

	public BattingAttributesByPABuilder setFlyBallHomeRunChance(double flyBallHomeRunChance) {
		this.flyBallHomeRunChance = flyBallHomeRunChance;
		return this;
	}

	public BattingAttributesByPABuilder setFlyBallOutChance(double flyBallOutChance) {
		this.flyBallOutChance = flyBallOutChance;
		return this;
	}

	public BattingAttributesByPABuilder setFlyBallSingleChance(double flyBallSingleChance) {
		this.flyBallSingleChance = flyBallSingleChance;
		return this;
	}

	public BattingAttributesByPABuilder setFlyBallTripleChance(double flyBallTripleChance) {
		this.flyBallTripleChance = flyBallTripleChance;
		return this;
	}

	public BattingAttributesByPABuilder setGroundBallDoubleChance(double groundBallDoubleChance) {
		this.groundBallDoubleChance = groundBallDoubleChance;
		return this;
	}

	public BattingAttributesByPABuilder setGroundBallHomeRunChance(double groundBallHomeRunChance) {
		this.groundBallHomeRunChance = groundBallHomeRunChance;
		return this;
	}

	public BattingAttributesByPABuilder setGroundBallOutChance(double groundBallOutChance) {
		this.groundBallOutChance = groundBallOutChance;
		return this;
	}

	public BattingAttributesByPABuilder setGroundBallSingleChance(double groundBallSingleChance) {
		this.groundBallSingleChance = groundBallSingleChance;
		return this;
	}

	public BattingAttributesByPABuilder setGroundBallTripleChance(double groundBallTripleChance) {
		this.groundBallTripleChance = groundBallTripleChance;
		return this;
	}

	public BattingAttributesByPABuilder setHitByPitchChance(double hitByPitchChance) {
		this.hitByPitchChance = hitByPitchChance;
		return this;
	}

	public BattingAttributesByPABuilder setLineDriveDoubleChance(double lineDriveDoubleChance) {
		this.lineDriveDoubleChance = lineDriveDoubleChance;
		return this;
	}

	public BattingAttributesByPABuilder setLineDriveHomeRunChance(double lineDriveHomeRunChance) {
		this.lineDriveHomeRunChance = lineDriveHomeRunChance;
		return this;
	}

	public BattingAttributesByPABuilder setLineDriveOutChance(double lineDriveOutChance) {
		this.lineDriveOutChance = lineDriveOutChance;
		return this;
	}

	public BattingAttributesByPABuilder setLineDriveSingleChance(double lineDriveSingleChance) {
		this.lineDriveSingleChance = lineDriveSingleChance;
		return this;
	}

	public BattingAttributesByPABuilder setLineDriveTripleChance(double lineDriveTripleChance) {
		this.lineDriveTripleChance = lineDriveTripleChance;
		return this;
	}

	public BattingAttributesByPABuilder setStrikeoutChance(double strikeoutChance) {
		this.strikeoutChance = strikeoutChance;
		return this;
	}

	public BattingAttributesByPABuilder setStrikeoutLookingChance(double strikeoutLookingChance) {
		this.strikeoutLookingChance = strikeoutLookingChance;
		return this;
	}

	public BattingAttributesByPABuilder setStrikeoutSwingingChance(double strikeoutSwingingChance) {
		this.strikeoutSwingingChance = strikeoutSwingingChance;
		return this;
	}

	public BattingAttributesByPABuilder setWalkChance(double walkChance) {
		this.walkChance = walkChance;
		return this;
	}

	public BattingAttributesByPA build() {
		return new BattingAttributesByPA(
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
