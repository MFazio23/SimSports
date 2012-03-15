package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.Game;
import org.fazio.simsports.core.types.Team;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/13/12 3:49 PM
 */
public class BaseballGame extends Game {
	
	private int inning = 1;
	private boolean topOfInning = true;
	private int outs = 0;

	private Diamond diamond;

	private enum Event {NoEvent, EndOfHalfInning, EndOfInning, EndOfGame}
	
	public BaseballGame(final Team homeTeam, final Team awayTeam) {
		super(homeTeam, awayTeam);
	}

	private void checkForEvent() {
		switch (this.findEvent()) {
			case EndOfHalfInning:
				this.topOfInning = false;
				this.outs = 0;
				break;
			case EndOfInning:
				this.topOfInning = true;
				this.outs = 0;
				this.inning++;
				break;
			case EndOfGame:
				this.gameOver = true;
				break;
			case NoEvent:
				break;
			default:
				break;
		}
	}
	
	private Event findEvent() {
		Event event = Event.NoEvent;
		
		if(this.outs >= 3) {
			event = Event.EndOfHalfInning;

			if(!this.topOfInning) {
				event = Event.EndOfInning;
				
				if(this.inning >= 9 && (this.homeScore != this.awayScore)) {
					event = Event.EndOfGame;
				}
			}
		}
		
		return event;
	}
	
	public void addOut() {
		this.addOuts(1);
	}
	
	public void addOuts(final int outs) {
		this.outs += outs;
		this.checkForEvent();
	}

	@Override
	public void addToHomeScore(final int addedPoints) {
		super.addToHomeScore(addedPoints);
		this.checkForEvent();
	}

	public int getInning() {
		return this.inning;
	}

	public int getOuts() {
		return this.outs;
	}
	
	public boolean isTopOfInning() {
		return this.topOfInning;
	}
}
