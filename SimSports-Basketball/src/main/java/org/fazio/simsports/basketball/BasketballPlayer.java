package org.fazio.simsports.basketball;

import org.fazio.simsports.core.types.*;

import java.util.List;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 11/23/12 1:00 PM
 */
public class BasketballPlayer extends Player {

	public BasketballPlayer(
		final Attributes attributes,
		final String firstName,
		final String lastName,
		final String nickname,
		final String number,
		final List<Position> positions,
		final Statistics statistics) {

		super(attributes, firstName, lastName, nickname, number, positions, statistics);
	}

	@Override
	public Ratings calculateRatings() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
