package org.fazio.simsports.baseball.types.attributes;

import org.fazio.simsports.core.types.Attributes;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/12/12 3:47 PM
 */
public class BatterAttributes implements Attributes {
	
	private final Attributes battingAttributes;
	private final Attributes fieldingAttributes;
	private final Attributes runningAttributes;

	public BatterAttributes(
		final Attributes battingAttributes,
		final Attributes fieldingAttributes,
		final Attributes runningAttributes) {
			this.battingAttributes = battingAttributes;
			this.fieldingAttributes = fieldingAttributes;
			this.runningAttributes = runningAttributes;
	}

	public Attributes getBattingAttributes() {
		return battingAttributes;
	}

	public Attributes getFieldingAttributes() {
		return fieldingAttributes;
	}

	public Attributes getRunningAttributes() {
		return runningAttributes;
	}
}
