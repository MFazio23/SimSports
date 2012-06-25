package org.fazio.simsports.core.util;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/11/12 12:17 PM
 */
public class Pair<L, R> {

	private final L left;
	private final R right;

	public Pair(final L left, final R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}
}
