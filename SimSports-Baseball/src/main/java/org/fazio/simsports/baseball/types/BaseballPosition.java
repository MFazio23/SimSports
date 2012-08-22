package org.fazio.simsports.baseball.types;


import org.fazio.simsports.core.types.Position;

import java.util.ArrayList;
import java.util.List;

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
	Designated_Hitter("DH", false),
	Starting_Pitcher("SP", true),
	Relief_Pitcher("RP", true);

	private final String positionShortName;
	private final boolean isPitcher;
	
	private BaseballPosition(final String positionShortName, final boolean isPitcher) {
		this.positionShortName = positionShortName;
		this.isPitcher = isPitcher;
	}

	public static Position getPositionByName(final String name) {
		Position position = null;

		for(Position tempPosition : BaseballPosition.values()) {
			if(tempPosition.getPositionName().equals(name)) {
				position = tempPosition;
			}
		}

		return position;
	}

	public static Position getPositionByShortName(final String shortName) {
		Position position = null;

		for(Position tempPosition : BaseballPosition.values()) {
			if(tempPosition.getPositionShortName().equals(shortName)) {
				position = tempPosition;
			}
		}

		return position;
	}

	public static List<Position> getPositionListByNameList(final List<String> nameList) {
		final List<Position> positionList = new ArrayList<Position>();

		for(String name : nameList) {
			positionList.add(BaseballPosition.getPositionByName(name));
		}

		return positionList;
	}

	public static List<Position> getPositionListByShortNameList(final List<String> nameList) {
		final List<Position> positionList = new ArrayList<Position>();

		for(String name : nameList) {
			positionList.add(BaseballPosition.getPositionByShortName(name));
		}

		return positionList;
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
