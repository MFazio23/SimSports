package org.fazio.simsports.baseball.builders;

import org.fazio.simsports.baseball.types.BatterAttributes;

/**
 * @author Michael Fazio
 */
public class BatterAttributesBuilder {

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


	public BatterAttributesBuilder setContactFoul(double contactFoul) {
		this.contactFoul = contactFoul;
		return this;
	}

	public BatterAttributesBuilder setFlyBallRate(double flyBallRate) {
		this.flyBallRate = flyBallRate;
		return this;
	}

	public BatterAttributesBuilder setGroundBallRate(double groundBallRate) {
		this.groundBallRate = groundBallRate;
		return this;
	}

	public BatterAttributesBuilder setHitDouble(double hitDouble) {
		this.hitDouble = hitDouble;
		return this;
	}

	public BatterAttributesBuilder setHitHomeRun(double hitHomeRun) {
		this.hitHomeRun = hitHomeRun;
		return this;
	}

	public BatterAttributesBuilder setHitTriple(double hitTriple) {
		this.hitTriple = hitTriple;
		return this;
	}

	public BatterAttributesBuilder setInPlayHit(double inPlayHit) {
		this.inPlayHit = inPlayHit;
		return this;
	}

	public BatterAttributesBuilder setNoSwingHBP(double noSwingHBP) {
		this.noSwingHBP = noSwingHBP;
		return this;
	}

	public BatterAttributesBuilder setNoSwingStrike(double noSwingStrike) {
		this.noSwingStrike = noSwingStrike;
		return this;
	}

	public BatterAttributesBuilder setPitchSwing(double pitchSwing) {
		this.pitchSwing = pitchSwing;
		return this;
	}

	public BatterAttributesBuilder setSwingContact(double swingContact) {
		this.swingContact = swingContact;
		return this;
	}

	public BatterAttributes build() {
		return new BatterAttributes(
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
