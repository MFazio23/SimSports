package org.fazio.simsports.basketball.types;

import org.fazio.simsports.core.types.Position;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 11/23/12 1:09 PM
 */
public enum BasketballPosition implements Position {

	PointGuard("PG"),
	ShootingGuard("SG"),
	SmallForward("SF"),
	PowerForward("PF"),
	Center("C");

	private final String positionShortName;

	private BasketballPosition(final String positionShortName) {
		this.positionShortName = positionShortName;
	}

	@Override
	public String getPositionName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getPositionShortName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
