package org.fazio.simsports.baseball.types.ratings;

import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Ratings;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/18/12 3:15 PM
 */
public class OffenseRatings implements Ratings {

	private final Attributes offenseAttrs;

	private final int contact;
	private final int power;
	private final int eye;
	private final int patience;

	public OffenseRatings(final Attributes offenseAttrs) {
		this.offenseAttrs = offenseAttrs;

		this.contact = this.calculateContactRating();
		this.power = this.calculatePowerRating();
		this.eye = this.calculateEyeRating();
		this.patience = this.calculatePatienceRating();
	}

	private int calculateContactRating() {
		return 0;
	}

	private int calculatePowerRating() {
		return 0;
	}

	private int calculateEyeRating() {
		return 0;
	}

	private int calculatePatienceRating() {
		return 0;
	}

	public Attributes getOffenseAttrs() {
		return offenseAttrs;
	}
}
