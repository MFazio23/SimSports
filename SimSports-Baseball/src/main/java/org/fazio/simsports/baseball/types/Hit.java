package org.fazio.simsports.baseball.types;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/15/12 9:55 AM
 */
public enum Hit {

	Single(1),
	Double(2),
	Triple(3),
	HomeRun(4);
	
	protected final int bases;
	
	private Hit(final int bases) {
		this.bases = bases;
	}
	
	public int getBases() {
		return this.bases;
	}

}
