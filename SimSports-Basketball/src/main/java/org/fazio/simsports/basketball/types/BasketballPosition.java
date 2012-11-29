package org.fazio.simsports.basketball.types;

import org.fazio.simsports.core.types.Position;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 11/23/12 1:09 PM
 */
public enum BasketballPosition implements Position {

	Guard("G"),
	Forward("F"),
	Point_Guard("PG"),
	Shooting_Guard("SG"),
	Small_Forward("SF"),
	Power_Forward("PF"),
	Center("C");

	private final String positionShortName;

	private BasketballPosition(final String positionShortName) {
		this.positionShortName = positionShortName;
	}

	public static Position getPositionByName(final String name) {
		Position position = null;

		for(Position tempPosition : BasketballPosition.values()) {
			if(tempPosition.getPositionName().equals(name)) {
				position = tempPosition;
			}
		}

		return position;
	}

	public static Position getPositionByShortName(final String shortName) {
		Position position = null;

		for(Position tempPosition : BasketballPosition.values()) {
			if(tempPosition.getPositionShortName().equals(shortName)) {
				position = tempPosition;
			}
		}

		return position;
	}

	@Override
	public String getPositionName() {
		return this.name().replaceAll("_", " ");
	}

	@Override
	public String getPositionShortName() {
		return this.positionShortName;
	}

	@Override
	public String toString() {
		return this.getPositionName();
	}
}
