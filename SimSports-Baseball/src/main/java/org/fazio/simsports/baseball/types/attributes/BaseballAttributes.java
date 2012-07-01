package org.fazio.simsports.baseball.types.attributes;

import org.fazio.simsports.core.types.Attributes;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/29/12 5:57 PM
 */
public class BaseballAttributes implements Attributes {

	private final BatterAttributes batterAttributes;
	private final Attributes pitcherAttributes;
	private final Attributes fielderAttributes;

	public BaseballAttributes(final BatterAttributes batterAttributes, final Attributes pitcherAttributes, final Attributes fielderAttributes) {
		this.batterAttributes = batterAttributes;
		this.pitcherAttributes = pitcherAttributes;
		this.fielderAttributes = fielderAttributes;
	}

	public BatterAttributes getBatterAttributes() {
		return batterAttributes;
	}

	public Attributes getPitcherAttributes() {
		return pitcherAttributes;
	}

	public Attributes getFielderAttributes() {
		return fielderAttributes;
	}
}
