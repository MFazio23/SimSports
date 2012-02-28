package org.fazio.simsports.baseball.types;


import org.fazio.simsports.core.Position;

/**
 * @author Michael Fazio
 */
public enum BaseballPosition implements Position {

	CATCHER("Catcher", "C", false),
	FIRST_BASE("First Base", "1B", false),
	SECOND_BASE("Second Base", "2B", false),
	THIRD_BASE("Third Base", "C", false),
	SHORTSTOP("Shortstop", "SS", false),
	LEFT_FIELD("Left Field", "LF", false),
	CENTER_FIELD("Center Field", "CF", false),
	RIGHT_FIELD("Right Field", "RF", false),
	STARTING_PITCHER("Starting Pitcher", "SP", true),
	RELIEF_PITCHER("Relief Pitcher", "RP", true);

	private final String positionName;
	private final String positionShortName;
	private final boolean isPitcher;
	
	private BaseballPosition(final String positionName, final String positionShortName, final boolean isPitcher) {
		this.positionName = positionName;
		this.positionShortName = positionShortName;
		this.isPitcher = isPitcher;
	}
	
	@Override
	public String getPositionName() {
		return this.positionName;
	}

	@Override
	public String getPositionShortName() {
		return this.positionShortName;
	}

	public boolean isPitcher() {
		return this.isPitcher;
	}
}
