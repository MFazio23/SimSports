package org.fazio.simsports.baseball.types.ratings;

import org.fazio.simsports.baseball.types.attributes.BaseballAttributes;
import org.fazio.simsports.core.types.Ratings;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/18/12 3:09 PM
 */
public class BaseballRatings implements Ratings {

	private final OffenseRatings offense;
	private final DefenseRatings defense;
	private final PitchingRatings pitching;

	public BaseballRatings(final BaseballAttributes attrs) {
		this.offense = new OffenseRatings(attrs.getBatterAttributes());
		this.defense = new DefenseRatings(attrs.getFielderAttributes());
		this.pitching = new PitchingRatings(attrs.getPitcherAttributes());
	}

	public Ratings getOffense() {
		return offense;
	}

	public Ratings getDefense() {
		return defense;
	}

	public Ratings getPitching() {
		return pitching;
	}
}
