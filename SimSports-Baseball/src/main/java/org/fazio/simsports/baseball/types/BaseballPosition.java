package org.fazio.simsports.baseball.types;


import org.fazio.simsports.core.types.Position;

/**
 * @author Michael Fazio
 */
public enum BaseballPosition implements Position {

	Catcher("C", false),
	First_Base("1B", false),
	Second_Base("2B", false),
	Third_Base("3B", false),
	Shortstop("SS", false),
	Left_Field("LF", false),
	Center_Field("CF", false),
	Right_Field("RF", false),
	Starting_Pitcher("SP", true),
	Relief_Pitcher("RP", true);

	private final String positionShortName;
	private final boolean isPitcher;
	
	private BaseballPosition(final String positionShortName, final boolean isPitcher) {
		this.positionShortName = positionShortName;
		this.isPitcher = isPitcher;
	}
	
	@Override
	public String getPositionName() {
		return this.name().replaceAll("_", " ");
	}

	@Override
	public String getPositionShortName() {
		return this.positionShortName;
	}

	public boolean isPitcher() {
		return this.isPitcher;
	}

	@Override
	public String toString() {
		return this.getPositionName();
	}
}
