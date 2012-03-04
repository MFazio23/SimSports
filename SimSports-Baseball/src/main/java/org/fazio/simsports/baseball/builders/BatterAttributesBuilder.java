package org.fazio.simsports.baseball.builders;

import org.fazio.simsports.baseball.types.BatterAttributes;

/**
 * @author Michael Fazio
 */
public class BatterAttributesBuilder {

	private double batterPitchBallRate;
	private double batterInPlayRate;
	private double batterWalkPercentage;
	private double batterStrikeoutPercentage;
	private double batterAverage;
	private double batterDoubleRate;
	private double batterTripleRate;
	private double batterHomeRunRate;
	
	public BatterAttributesBuilder setBatterPitchBallRate(final double batterPitchBallRate) {
		this.batterPitchBallRate = batterPitchBallRate;
		return this;
	}

	public BatterAttributesBuilder setBatterInPlayRate(final double batterInPlayRate) {
		this.batterInPlayRate = batterInPlayRate;
		return this;
	}

	public BatterAttributesBuilder setBatterWalkPercentage(final double batterWalkPercentage) {
		this.batterWalkPercentage = batterWalkPercentage;
		return this;
	}

	public BatterAttributesBuilder setBatterStrikeoutPercentage(final double batterStrikeoutPercentage) {
		this.batterStrikeoutPercentage = batterStrikeoutPercentage;
		return this;
	}

	public BatterAttributesBuilder setBatterAverage(final double batterAverage) {
		this.batterAverage = batterAverage;
		return this;
	}

	public BatterAttributesBuilder setBatterDoubleRate(final double batterDoubleRate) {
		this.batterDoubleRate = batterDoubleRate;
		return this;
	}

	public BatterAttributesBuilder setBatterTripleRate(final double batterTripleRate) {
		this.batterTripleRate = batterTripleRate;
		return this;
	}

	public BatterAttributesBuilder setBatterHomeRunRate(final double batterHomeRunRate) {
		this.batterHomeRunRate = batterHomeRunRate;
		return this;
	}
	
	public BatterAttributes build() {
		return new BatterAttributes(
			this.batterPitchBallRate,
			this.batterInPlayRate,
			this.batterAverage,
			this.batterDoubleRate,
			this.batterHomeRunRate,
			this.batterStrikeoutPercentage,
			this.batterTripleRate,
			this.batterWalkPercentage);
	}
	
}
