package org.fazio.simsports.baseball.builders;

import org.fazio.simsports.baseball.types.BatterAttributes;

/**
 * @author Michael Fazio
 */
public class BatterAttributesBuilder {

	private double batterPitchStrikeRate;
	private double batterPitchHBPRate;
	private double batterPitchSwingRate;
	//batterPitchStrikeRate is everything else

	private double batterSwingStrikeRate;
	private double batterSwingFoulRate;
	private double batterSwingHitRate;
	//batterSwingOutRate is everything else

	private double batterHitDoubleRate;
	private double batterHitTripleRate;
	private double batterHitHomeRunRate;
	//batterHitSingleRate is everything else

	private double batterContactFlyBallRate;
	private double batterContactGroundBallRate;
	//batterContactLineDriveRate is everything else
	
	public BatterAttributesBuilder setBatterPitchStrikeRate(final double batterPitchStrikeRate) {
		this.batterPitchStrikeRate = batterPitchStrikeRate;
		return this;
	}
	public BatterAttributesBuilder setBatterPitchHBPRate(final double batterPitchHBPRate) {
		this.batterPitchHBPRate = batterPitchHBPRate;
		return this;
	}
	public BatterAttributesBuilder setBatterPitchSwingRate(final double batterPitchSwingRate) {
		this.batterPitchSwingRate = batterPitchSwingRate;
		return this;
	}
	public BatterAttributesBuilder setBatterSwingStrikeRate(final double batterSwingStrikeRate) {
		this.batterSwingStrikeRate = batterSwingStrikeRate;
		return this;
	}
	public BatterAttributesBuilder setBatterSwingFoulRate(final double batterSwingFoulRate) {
		this.batterSwingFoulRate = batterSwingFoulRate;
		return this;
	}
	public BatterAttributesBuilder setBatterSwingHitRate(final double batterSwingHitRate) {
		this.batterSwingHitRate = batterSwingHitRate;
		return this;
	}
	public BatterAttributesBuilder setBatterHitDoubleRate(final double batterHitDoubleRate) {
		this.batterHitDoubleRate = batterHitDoubleRate;
		return this;
	}
	public BatterAttributesBuilder setBatterHitTripleRate(final double batterHitTripleRate) {
		this.batterHitTripleRate = batterHitTripleRate;
		return this;
	}
	public BatterAttributesBuilder setBatterHitHomeRunRate(final double batterHitHomeRunRate) {
		this.batterHitHomeRunRate = batterHitHomeRunRate;
		return this;
	}
	public BatterAttributesBuilder setBatterContactFlyBallRate(final double batterContactFlyBallRate) {
		this.batterContactFlyBallRate = batterContactFlyBallRate;
		return this;
	}
	public BatterAttributesBuilder setBatterContactGroundBallRate(final double batterContactGroundBallRate) {
		this.batterContactGroundBallRate = batterContactGroundBallRate;
		return this;
	}
	
	public BatterAttributes build() {
		return new BatterAttributes(
				this.batterPitchStrikeRate,
				this.batterPitchHBPRate,
				this.batterPitchSwingRate,
				this.batterSwingStrikeRate,
				this.batterSwingFoulRate,
				this.batterSwingHitRate,
				this.batterHitDoubleRate,
				this.batterHitTripleRate,
				this.batterHitHomeRunRate,
				this.batterContactFlyBallRate,
				this.batterContactGroundBallRate);
		}
	
}
