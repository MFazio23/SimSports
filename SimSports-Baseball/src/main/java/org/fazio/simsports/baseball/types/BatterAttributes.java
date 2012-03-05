package org.fazio.simsports.baseball.types;

/**
 * @author Michael Fazio
 */
public class BatterAttributes {

	private final double batterPitchStrikeRate;
	private final double batterPitchHBPRate;
	//batterPitchBallRate is everything else
	private final double batterPitchSwingRate;

	private final double batterSwingStrikeRate;
	private final double batterSwingFoulRate;
	private final double batterSwingHitRate;
	//batterSwingOutRate is everything else

	private final double batterHitDoubleRate;
	private final double batterHitTripleRate;
	private final double batterHitHomeRunRate;
	//batterHitSingleRate is everything else

	private final double batterContactFlyBallRate;
	private final double batterContactGroundBallRate;
	//batterContactLineDriveRate is everything else


	public BatterAttributes(double batterPitchStrikeRate, double batterPitchHBPRate, double batterPitchSwingRate, double batterSwingStrikeRate, double batterSwingFoulRate, double batterSwingHitRate, double batterHitDoubleRate, double batterHitTripleRate, double batterHitHomeRunRate, double batterContactFlyBallRate, double batterContactGroundBallRate) {
		this.batterPitchStrikeRate = batterPitchStrikeRate;
		this.batterPitchHBPRate = batterPitchHBPRate;
		this.batterPitchSwingRate = batterPitchSwingRate;
		this.batterSwingStrikeRate = batterSwingStrikeRate;
		this.batterSwingFoulRate = batterSwingFoulRate;
		this.batterSwingHitRate = batterSwingHitRate;
		this.batterHitDoubleRate = batterHitDoubleRate;
		this.batterHitTripleRate = batterHitTripleRate;
		this.batterHitHomeRunRate = batterHitHomeRunRate;
		this.batterContactFlyBallRate = batterContactFlyBallRate;
		this.batterContactGroundBallRate = batterContactGroundBallRate;
	}

	public double getBatterPitchStrikeRate() {
		return batterPitchStrikeRate;
	}

	public double getBatterPitchHBPRate() {
		return batterPitchHBPRate;
	}

	public double getBatterPitchSwingRate() {
		return batterPitchSwingRate;
	}

	public double getBatterSwingStrikeRate() {
		return batterSwingStrikeRate;
	}

	public double getBatterSwingFoulRate() {
		return batterSwingFoulRate;
	}

	public double getBatterSwingHitRate() {
		return batterSwingHitRate;
	}

	public double getBatterHitDoubleRate() {
		return batterHitDoubleRate;
	}

	public double getBatterHitTripleRate() {
		return batterHitTripleRate;
	}

	public double getBatterHitHomeRunRate() {
		return batterHitHomeRunRate;
	}

	public double getBatterContactFlyBallRate() {
		return batterContactFlyBallRate;
	}

	public double getBatterContactGroundBallRate() {
		return batterContactGroundBallRate;
	}
}
