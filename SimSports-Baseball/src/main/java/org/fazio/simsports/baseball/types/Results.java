package org.fazio.simsports.baseball.types;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/15/12 10:23 AM
 */
public enum Results {

	FlyBall("Fly Ball"),
	GroundBall("Ground Ball"),
	LineDrive("Line Drive"),
	Single(),
	Double(),
	Triple(),
	HomeRun("Home Run"),
	Out(),
	HBP("Hit by Pitch"),
	BB("Walk"),
	StrikeoutSwinging("Strikeout Swinging", true),
	StrikeoutLooking("Strikeout Looking", true);
	
	protected final String text;
	protected final boolean strikeout;
	
	private Results() {
		this.text = this.name();
		this.strikeout = false;
	}
	
	private Results(final String text) {
		this.text = text;
		this.strikeout = false;
	}
	
	private Results(final String text, final boolean strikeout) {
		this.text = text;
		this.strikeout = strikeout;
	}
	
	public String getText() {
		return this.text;
	}
	
	public boolean isStrikeout() {
		return this.strikeout;
	}
	
}
