package org.fazio.simsports.baseball.builders;

import org.fazio.simsports.baseball.types.attributes.BatterAttributesByPitch;

/**
 * @author Michael Fazio
 */
public class BatterAttributesByPitchBuilder {

	private double pitchSwing;
	//pitchNoSwing is everything else

	private double noSwingStrike;
	private double noSwingHBP;
	//noSwingBall is everything else

	private double swingContact;
	//swingStrike is everything else

	private double contactFoul;
	//contactInPlay is everything else

	private double inPlayHit;
	//inPlayOut is everything else

	private double hitDouble;
	private double hitTriple;
	private double hitHomeRun;
	//hitSingle is everything else

	private double flyBallRate;
	private double groundBallRate;
	//lineDriveRate is everything else


	public BatterAttributesByPitchBuilder setContactFoul(double contactFoul) {
		this.contactFoul = contactFoul;
		return this;
	}

	public BatterAttributesByPitchBuilder setFlyBallRate(double flyBallRate) {
		this.flyBallRate = flyBallRate;
		return this;
	}

	public BatterAttributesByPitchBuilder setGroundBallRate(double groundBallRate) {
		this.groundBallRate = groundBallRate;
		return this;
	}

	public BatterAttributesByPitchBuilder setHitDouble(double hitDouble) {
		this.hitDouble = hitDouble;
		return this;
	}

	public BatterAttributesByPitchBuilder setHitHomeRun(double hitHomeRun) {
		this.hitHomeRun = hitHomeRun;
		return this;
	}

	public BatterAttributesByPitchBuilder setHitTriple(double hitTriple) {
		this.hitTriple = hitTriple;
		return this;
	}

	public BatterAttributesByPitchBuilder setInPlayHit(double inPlayHit) {
		this.inPlayHit = inPlayHit;
		return this;
	}

	public BatterAttributesByPitchBuilder setNoSwingHBP(double noSwingHBP) {
		this.noSwingHBP = noSwingHBP;
		return this;
	}

	public BatterAttributesByPitchBuilder setNoSwingStrike(double noSwingStrike) {
		this.noSwingStrike = noSwingStrike;
		return this;
	}

	public BatterAttributesByPitchBuilder setPitchSwing(double pitchSwing) {
		this.pitchSwing = pitchSwing;
		return this;
	}

	public BatterAttributesByPitchBuilder setSwingContact(double swingContact) {
		this.swingContact = swingContact;
		return this;
	}

	public BatterAttributesByPitch build() {
		return new BatterAttributesByPitch(
			this.contactFoul,
			this.flyBallRate,
			this.groundBallRate,
			this.hitDouble,
			this.hitHomeRun,
			this.hitTriple,
			this.inPlayHit,
			this.noSwingHBP,
			this.noSwingStrike,
			this.pitchSwing,
			this.swingContact);
		}
	
}
