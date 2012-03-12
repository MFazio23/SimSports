package org.fazio.simsports.baseball.types;

/**
 * @author Michael Fazio
 */
public class BatterAttributesByPA {

	private final double hitByPitchChance;
	private final double walkChance;
	private final double strikeoutChance;
	private final double contactChance;

	private final double strikeoutLookingChance;
	private final double strikeoutSwingingChance;
	
	private final double contactGroundBallChance;
	private final double contactLineDriveChance;
	private final double contactFlyBallChance;

	private final double groundBallOutChance;
	private final double groundBallSingleChance;
	private final double groundBallDoubleChance;
	private final double groundBallTripleChance;
	private final double groundBallHomeRunChance;

	private final double lineDriveOutChance;
	private final double lineDriveSingleChance;
	private final double lineDriveDoubleChance;
	private final double lineDriveTripleChance;
	private final double lineDriveHomeRunChance;

	private final double flyBallOutChance;
	private final double flyBallSingleChance;
	private final double flyBallDoubleChance;
	private final double flyBallTripleChance;
	private final double flyBallHomeRunChance;

	public BatterAttributesByPA(
		double contactChance,
		double contactFlyBallChance,
		double contactGroundBallChance,
		double contactLineDriveChance,
		double flyBallDoubleChance,
		double flyBallHomeRunChance,
		double flyBallOutChance,
		double flyBallSingleChance,
		double flyBallTripleChance,
		double groundBallDoubleChance,
		double groundBallHomeRunChance,
		double groundBallOutChance,
		double groundBallSingleChance,
		double groundBallTripleChance,
		double hitByPitchChance,
		double lineDriveDoubleChance,
		double lineDriveHomeRunChance,
		double lineDriveOutChance,
		double lineDriveSingleChance,
		double lineDriveTripleChance,
		double strikeoutChance,
		double strikeoutLookingChance,
		double strikeoutSwingingChance,
		double walkChance) {
			this.contactChance = contactChance;
			this.contactFlyBallChance = contactFlyBallChance;
			this.contactGroundBallChance = contactGroundBallChance;
			this.contactLineDriveChance = contactLineDriveChance;
			this.flyBallDoubleChance = flyBallDoubleChance;
			this.flyBallHomeRunChance = flyBallHomeRunChance;
			this.flyBallOutChance = flyBallOutChance;
			this.flyBallSingleChance = flyBallSingleChance;
			this.flyBallTripleChance = flyBallTripleChance;
			this.groundBallDoubleChance = groundBallDoubleChance;
			this.groundBallHomeRunChance = groundBallHomeRunChance;
			this.groundBallOutChance = groundBallOutChance;
			this.groundBallSingleChance = groundBallSingleChance;
			this.groundBallTripleChance = groundBallTripleChance;
			this.hitByPitchChance = hitByPitchChance;
			this.lineDriveDoubleChance = lineDriveDoubleChance;
			this.lineDriveHomeRunChance = lineDriveHomeRunChance;
			this.lineDriveOutChance = lineDriveOutChance;
			this.lineDriveSingleChance = lineDriveSingleChance;
			this.lineDriveTripleChance = lineDriveTripleChance;
			this.strikeoutChance = strikeoutChance;
			this.strikeoutLookingChance = strikeoutLookingChance;
			this.strikeoutSwingingChance = strikeoutSwingingChance;
			this.walkChance = walkChance;
	}

	public double getContactChance() {
		return contactChance;
	}

	public double getContactFlyBallChance() {
		return contactFlyBallChance;
	}

	public double getContactGroundBallChance() {
		return contactGroundBallChance;
	}

	public double getContactLineDriveChance() {
		return contactLineDriveChance;
	}

	public double getFlyBallDoubleChance() {
		return flyBallDoubleChance;
	}

	public double getFlyBallHomeRunChance() {
		return flyBallHomeRunChance;
	}

	public double getFlyBallOutChance() {
		return flyBallOutChance;
	}

	public double getFlyBallSingleChance() {
		return flyBallSingleChance;
	}

	public double getFlyBallTripleChance() {
		return flyBallTripleChance;
	}

	public double getGroundBallDoubleChance() {
		return groundBallDoubleChance;
	}

	public double getGroundBallHomeRunChance() {
		return groundBallHomeRunChance;
	}

	public double getGroundBallOutChance() {
		return groundBallOutChance;
	}

	public double getGroundBallSingleChance() {
		return groundBallSingleChance;
	}

	public double getGroundBallTripleChance() {
		return groundBallTripleChance;
	}

	public double getHitByPitchChance() {
		return hitByPitchChance;
	}

	public double getLineDriveDoubleChance() {
		return lineDriveDoubleChance;
	}

	public double getLineDriveHomeRunChance() {
		return lineDriveHomeRunChance;
	}

	public double getLineDriveOutChance() {
		return lineDriveOutChance;
	}

	public double getLineDriveSingleChance() {
		return lineDriveSingleChance;
	}

	public double getLineDriveTripleChance() {
		return lineDriveTripleChance;
	}

	public double getStrikeoutChance() {
		return strikeoutChance;
	}

	public double getStrikeoutLookingChance() {
		return strikeoutLookingChance;
	}

	public double getStrikeoutSwingingChance() {
		return strikeoutSwingingChance;
	}

	public double getWalkChance() {
		return walkChance;
	}
}
