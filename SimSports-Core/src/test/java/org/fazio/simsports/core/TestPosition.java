package org.fazio.simsports.core;

import org.fazio.simsports.core.types.Position;

/**
 * @author Michael Fazio
 */
public enum TestPosition implements Position {
	
	GENERIC("Generic", "GEN");

	protected final String name;
	protected final String shortName;
	
	private TestPosition(final String name, final String shortName) {
		this.name = name;
		this.shortName = shortName;
	}

	@Override
	public String getPositionName() {
		return this.name;
	}

	@Override
	public String getPositionShortName() {
		return this.shortName;
	}

	public static Position getPositionByName(final String name) {
		Position position = null;

		for(Position tempPosition : TestPosition.values()) {
			if(tempPosition.getPositionName().equals(name)) {
				position = tempPosition;
			}
		}

		return position;
	}

	public static Position getPositionByShortName(final String shortName) {
		Position position = null;

		for(Position tempPosition : TestPosition.values()) {
			if(tempPosition.getPositionShortName().equals(shortName)) {
				position = tempPosition;
			}
		}

		return position;
	}
}
