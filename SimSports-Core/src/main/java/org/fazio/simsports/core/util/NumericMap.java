package org.fazio.simsports.core.util;

import java.util.HashMap;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/18/12 1:33 PM
 */
public class NumericMap<K, V> extends HashMap<K, Number> {

	public NumericMap() {
		super();
	}

	public void increment(final K key) {
		this.increment(key, 1);
	}

	public void increment(final K key, final double increaseValue) {
		final Number value = this.get(key);

		this.put(key, (value.doubleValue() + increaseValue));
	}
}
