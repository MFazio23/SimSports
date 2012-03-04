package org.fazio.simsports.baseball.types;

/**
 * @author Michael Fazio
 */
public class BatterAttributes {

	private final double batterPitchBallRate;

	private final double batterInPlayRate;
	
	private final double batterStrikeoutPercentage;
	private final double batterWalkPercentage;
	private final double batterAverage;
	private final double batterDoubleRate;
	private final double batterTripleRate;
	private final double batterHomeRunRate;

	public BatterAttributes(
		double batterPitchBallRate,
		double batterInPlayRate,
		double batterAverage,
		double batterDoubleRate,
		double batterHomeRunRate,
		double batterStrikeoutPercentage,
		double batterTripleRate,
		double batterWalkPercentage) {
			this.batterPitchBallRate = batterPitchBallRate;
			this.batterInPlayRate = batterInPlayRate;
			this.batterAverage = batterAverage;
			this.batterDoubleRate = batterDoubleRate;
			this.batterHomeRunRate = batterHomeRunRate;
			this.batterStrikeoutPercentage = batterStrikeoutPercentage;
			this.batterTripleRate = batterTripleRate;
			this.batterWalkPercentage = batterWalkPercentage;
	}

	public double getBatterPitchBallRate() {
		return batterPitchBallRate;
	}

	public double getBatterInPlayRate() {
		return batterInPlayRate;
	}

	public double getBatterAverage() {
		return batterAverage;
	}

	public double getBatterDoubleRate() {
		return batterDoubleRate;
	}

	public double getBatterHomeRunRate() {
		return batterHomeRunRate;
	}

	public double getBatterStrikeoutPercentage() {
		return batterStrikeoutPercentage;
	}

	public double getBatterTripleRate() {
		return batterTripleRate;
	}

	public double getBatterWalkPercentage() {
		return batterWalkPercentage;
	}
}
