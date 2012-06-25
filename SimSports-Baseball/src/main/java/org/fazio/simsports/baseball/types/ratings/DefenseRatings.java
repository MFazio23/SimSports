package org.fazio.simsports.baseball.types.ratings;

import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Ratings;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/18/12 3:16 PM
 */
public class DefenseRatings implements Ratings {

	private final Attributes defenseAttrs;

	public DefenseRatings(final Attributes defenseAttrs) {
		this.defenseAttrs = defenseAttrs;

	}

	public Attributes getDefenseAttrs() {
		return defenseAttrs;
	}
}
