package org.fazio.simsports.core;

import org.fazio.simsports.core.Position;

/**
 * @author Michael Fazio
 */
public enum TestPosition implements Position {
	
	GENERIC("Generic", "GEN");
	
	private final String name;
	private final String shortName;
	
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
}
