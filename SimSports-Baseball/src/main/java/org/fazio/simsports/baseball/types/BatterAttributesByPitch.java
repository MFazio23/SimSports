package org.fazio.simsports.baseball.types;

/**
 * @author Michael Fazio
 */
public class BatterAttributesByPitch {

	private final double pitchSwing;
	//pitchNoSwing is everything else

	private final double noSwingStrike;
	private final double noSwingHBP;
	//noSwingBall is everything else

	private final double swingContact;
	//swingStrike is everything else

	private final double contactFoul;
	//contactInPlay is everything else

	private final double inPlayHit;
	//inPlayOut is everything else

	private final double hitDouble;
	private final double hitTriple;
	private final double hitHomeRun;
	//hitSingle is everything else

	private final double flyBallRate;
	private final double groundBallRate;
	//lineDriveRate is everything else


	public BatterAttributesByPitch(double contactFoul, double flyBallRate, double groundBallRate, double hitDouble, double hitHomeRun, double hitTriple, double inPlayHit, double noSwingHBP, double noSwingStrike, double pitchSwing, double swingContact) {
		this.contactFoul = contactFoul;
		this.flyBallRate = flyBallRate;
		this.groundBallRate = groundBallRate;
		this.hitDouble = hitDouble;
		this.hitHomeRun = hitHomeRun;
		this.hitTriple = hitTriple;
		this.inPlayHit = inPlayHit;
		this.noSwingHBP = noSwingHBP;
		this.noSwingStrike = noSwingStrike;
		this.pitchSwing = pitchSwing;
		this.swingContact = swingContact;
	}

	public double getContactFoul() {
		return contactFoul;
	}

	public double getFlyBallRate() {
		return flyBallRate;
	}

	public double getGroundBallRate() {
		return groundBallRate;
	}

	public double getHitDouble() {
		return hitDouble;
	}

	public double getHitHomeRun() {
		return hitHomeRun;
	}

	public double getHitTriple() {
		return hitTriple;
	}

	public double getInPlayHit() {
		return inPlayHit;
	}

	public double getNoSwingHBP() {
		return noSwingHBP;
	}

	public double getNoSwingStrike() {
		return noSwingStrike;
	}

	public double getPitchSwing() {
		return pitchSwing;
	}

	public double getSwingContact() {
		return swingContact;
	}
}
