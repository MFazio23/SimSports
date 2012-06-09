package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.PlayResult;

/**
 * @author Michael Fazio
 */
public class PlateAppearanceResult implements PlayResult {

	protected final int bases;

	protected final Results nonContactResult;
	protected final Results contactType;
	protected final Results hitType;
	
	public PlateAppearanceResult(final int bases) {
		this(bases, null, null, null);
	}
	
	public PlateAppearanceResult(final Results nonContactResult) {
		this(0, nonContactResult, null, null);
	}

	public PlateAppearanceResult(final Results contactType, final Results hitType) {
		this(0, null, contactType, hitType);
	}

	public PlateAppearanceResult(final Results nonContactResult, final Results contactType, final Results hitType) {
		this(0, nonContactResult, contactType, hitType);
	}

	public PlateAppearanceResult(final int bases, final Results nonContactResult, final Results contactType, final Results hitType) {
		this.nonContactResult = nonContactResult;
		this.contactType = contactType;
		this.hitType = hitType;

		this.bases = bases;
	}

	public Results getSingleResult() {
		return nonContactResult == null ? hitType : nonContactResult;
	}

	public int outsMade() {
		if(this.hitType.equals(Results.Out)) {

		}
		//TODO: Finish this.
		return 0;
	}
	
	public int getBases() {
		return this.bases;
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
			.append(this.bases)
			.toString();
	}
}
