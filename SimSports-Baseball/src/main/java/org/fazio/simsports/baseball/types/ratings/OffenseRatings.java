package org.fazio.simsports.baseball.types.ratings;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.ExponentialDistributionImpl;
import org.fazio.simsports.baseball.types.attributes.BatterAttributes;
import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPA;
import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Ratings;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/18/12 3:15 PM
 */
public class OffenseRatings implements Ratings {

	private final BattingAttributesByPA offenseAttrs;

	private final int contact;
	private final int power;
	private final int eye;

	public OffenseRatings(final BatterAttributes offenseAttrs) {
		this.offenseAttrs = (BattingAttributesByPA) offenseAttrs.getBattingAttributes();

		this.contact = this.calculateContactRating();
		this.power = this.calculatePowerRating();
		this.eye = this.calculateEyeRating();
	}

	private int calculateContactRating() {
		final double nonWalkRate = (100 - (this.offenseAttrs.getWalkChance() + this.offenseAttrs.getHitByPitchChance()))/100.0;
		final double contactRate = (100 - (this.offenseAttrs.getStrikeoutChance()/nonWalkRate));

		final double gbHit = ((this.offenseAttrs.getContactGroundBallChance()/100) * (this.offenseAttrs.getGroundBallSingleChance() + this.offenseAttrs.getGroundBallDoubleChance() + this.offenseAttrs.getGroundBallTripleChance())) / 100;
		final double ldHit = ((this.offenseAttrs.getContactLineDriveChance()/100) * (this.offenseAttrs.getLineDriveSingleChance() + this.offenseAttrs.getLineDriveDoubleChance() + this.offenseAttrs.getLineDriveTripleChance() + this.offenseAttrs.getLineDriveHomeRunChance())) / 100;
		final double fbHit = ((this.offenseAttrs.getContactFlyBallChance()/100) * (this.offenseAttrs.getFlyBallSingleChance() + this.offenseAttrs.getFlyBallDoubleChance() + this.offenseAttrs.getFlyBallTripleChance() + this.offenseAttrs.getFlyBallHomeRunChance())) / 100;

		final double hitRate = (gbHit + ldHit + fbHit)/100;
		final double contactHitRate = hitRate * contactRate * 1000;

		double dRating = contactHitRate;
		if(dRating < 200.0) dRating = 200.0;
		if(dRating > 330.0) dRating = 330.0;
		dRating -= 200.0;
		dRating /= 130;
		dRating *= 60;
		dRating += 40;

		return (int) dRating;
	}

	private int calculatePowerRating() {
		int rating = 40;

		try {
			final double fb = (this.offenseAttrs.getContactFlyBallChance()/100);
			final double ld = (this.offenseAttrs.getContactLineDriveChance()/100);
			final int ldHR = (int)(this.offenseAttrs.getLineDriveHomeRunChance() * 1000);
			final int fbHR = (int)(this.offenseAttrs.getFlyBallHomeRunChance() * 1000);
			final int ldDBL = (int)(this.offenseAttrs.getLineDriveDoubleChance() * 1000);
			final int fbDBL = (int)(this.offenseAttrs.getFlyBallDoubleChance() * 1000);
			final int ldTRPL = (int)(this.offenseAttrs.getLineDriveTripleChance() * 1000);
			final int fbTRPL = (int)(this.offenseAttrs.getFlyBallTripleChance() * 1000);

			final int xbh = (int)((ldDBL + ldTRPL) * ld + (fbDBL + fbTRPL) * fb)/4;
			final int hr = (int)((ld * ldHR) + (fb * fbHR));//(int)(2 * (hr + (xbh * .18)));

			final int basicRating = (int)(xbh * .2 + hr * .8);

			rating = (int)(Math.ceil((new ExponentialDistributionImpl(3825).cumulativeProbability(basicRating) + .01) * 100));
		} catch (MathException e) {
			e.printStackTrace();
		}

		return rating;
	}

	private int calculateEyeRating() {
		int rating = 40;

		try {
			final int walkKRate = (int) ((this.offenseAttrs.getWalkChance() - this.offenseAttrs.getStrikeoutChance()) * 1000) + 20000;

			final int basicRating = (int)Math.round(new ExponentialDistributionImpl(9500).cumulativeProbability(walkKRate) * 100);//fullRating / 500;

			rating = (int)Math.round(basicRating * .6) + 40;
		} catch (MathException e) {
			e.printStackTrace();
		}

		return rating;
	}

	public int getContact() {
		return contact;
	}

	public int getPower() {
		return power;
	}

	public int getEye() {
		return eye;
	}

	public Attributes getOffenseAttrs() {
		return this.offenseAttrs;
	}

	public String toString() {
		return new StringBuilder()
			.append("Ratings:\n\tContact = ")
			.append(this.getContact())
			.append(", Power = ")
			.append(this.getPower())
			.append(", Eye = ")
			.append(this.calculateEyeRating())
			.toString();
	}
}
