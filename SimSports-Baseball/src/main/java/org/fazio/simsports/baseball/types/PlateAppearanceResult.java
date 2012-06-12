package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.PlayResult;

/**
 * @author Michael Fazio
 */
public class PlateAppearanceResult implements PlayResult {

	protected final Results nonContactResult;
	protected final Results contactType;
	protected final Results hitType;
	
	public PlateAppearanceResult(final Results nonContactResult) {
		this(nonContactResult, null, null);
	}

	public PlateAppearanceResult(final Results contactType, final Results hitType) {
		this(null, contactType, hitType);
	}

	public PlateAppearanceResult(final Results nonContactResult, final Results contactType, final Results hitType) {
		this.nonContactResult = nonContactResult;
		this.contactType = contactType;
		this.hitType = hitType;
	}

	public Results getSingleResult() {
		return nonContactResult == null ? hitType : nonContactResult;
	}
	
	public int getBases() {
		int bases = 0;

		switch(this.getSingleResult()) {
			case HBP: bases = 1; break;
			case BB: bases = 1; break;
			case Single: bases = 1; break;
			case Double: bases = 2; break;
			case Triple: bases = 3; break;
			case HomeRun: bases = 4; break;
			default: bases = 0; break;
		}

		return bases;
	}

	public boolean isOut() {
		boolean out = false;

		switch(this.getSingleResult()) {
			case Out: out = true; break;
			case StrikeoutLooking: out = true; break;
			case StrikeoutSwinging: out = true; break;
			default: out = false; break;
		}

		return out;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append("Play Result: ")
			.append("[")
			.append(this.nonContactResult)
			.append(",")
			.append(this.contactType)
			.append(",")
			.append(this.hitType)
			.append("]")
			.append(", Bases: ")
			.append(this.getBases())
			.toString();
	}
}
