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
	
	public PlateAppearanceResult(final Results hitType) {
		this(0, null, null, hitType);
	}

	public PlateAppearanceResult(final Results nonContactResult, final Results contactType) {
		this(0, nonContactResult, contactType, null);
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
	
	public int outsMade() {
		if(this.hitType.equals(Results.Out)) {

		}
		//TODO: Finish this.
		return 0;
	}
	
	public int getBases() {
		return this.bases;
	}

}
