package org.fazio.simsports.baseball.types.ratings;

import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Ratings;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/18/12 3:09 PM
 */
public class BaseballRatings implements Ratings {

	private final Ratings offense;
	private final Ratings defense;
	private final Ratings pitching;

	public BaseballRatings(final Attributes offenseAttrs, final Attributes defenseAttrs, final Attributes pitchingAttrs) {
		this.offense = new OffenseRatings(offenseAttrs);
		this.defense = new DefenseRatings(defenseAttrs);
		this.pitching = new PitchingRatings(pitchingAttrs);
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
