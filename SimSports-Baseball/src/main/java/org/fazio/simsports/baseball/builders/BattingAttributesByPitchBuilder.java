package org.fazio.simsports.baseball.builders;

import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPitch;

/**
 * @author Michael Fazio
 */
public class BattingAttributesByPitchBuilder {

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


	public BattingAttributesByPitchBuilder setContactFoul(double contactFoul) {
		this.contactFoul = contactFoul;
		return this;
	}

	public BattingAttributesByPitchBuilder setFlyBallRate(double flyBallRate) {
		this.flyBallRate = flyBallRate;
		return this;
	}

	public BattingAttributesByPitchBuilder setGroundBallRate(double groundBallRate) {
		this.groundBallRate = groundBallRate;
		return this;
	}

	public BattingAttributesByPitchBuilder setHitDouble(double hitDouble) {
		this.hitDouble = hitDouble;
		return this;
	}

	public BattingAttributesByPitchBuilder setHitHomeRun(double hitHomeRun) {
		this.hitHomeRun = hitHomeRun;
		return this;
	}

	public BattingAttributesByPitchBuilder setHitTriple(double hitTriple) {
		this.hitTriple = hitTriple;
		return this;
	}

	public BattingAttributesByPitchBuilder setInPlayHit(double inPlayHit) {
		this.inPlayHit = inPlayHit;
		return this;
	}

	public BattingAttributesByPitchBuilder setNoSwingHBP(double noSwingHBP) {
		this.noSwingHBP = noSwingHBP;
		return this;
	}

	public BattingAttributesByPitchBuilder setNoSwingStrike(double noSwingStrike) {
		this.noSwingStrike = noSwingStrike;
		return this;
	}

	public BattingAttributesByPitchBuilder setPitchSwing(double pitchSwing) {
		this.pitchSwing = pitchSwing;
		return this;
	}

	public BattingAttributesByPitchBuilder setSwingContact(double swingContact) {
		this.swingContact = swingContact;
		return this;
	}

	public BattingAttributesByPitch build() {
		return new BattingAttributesByPitch(
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
