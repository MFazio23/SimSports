package org.fazio.simsports.baseball.types.ratings;

import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Ratings;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/18/12 3:17 PM
 */
public class PitchingRatings implements Ratings {

	private final Attributes pitchingAttrs;

	public PitchingRatings(final Attributes pitchingAttrs) {
		this.pitchingAttrs = pitchingAttrs;
	}

	public Attributes getPitchingAttrs() {
		return pitchingAttrs;
	}
}
