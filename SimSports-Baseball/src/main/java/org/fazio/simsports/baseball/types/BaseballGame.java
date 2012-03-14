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
	
	public BaseballGame(final Team homeTeam, final Team awayTeam) {
		super(homeTeam, awayTeam);
	}

	private void checkOuts() {
		if(this.outs >= 3) {
			if(this.topOfInning) {
				this.topOfInning = false;
			} else {
				this.inning++;
				this.topOfInning = true;
			}
			this.outs = 0;
		}
	}
	
	public void addOut() {
		this.addOuts(1);
	}
	
	public void addOuts(final int outs) {
		this.outs += outs;
		this.checkOuts();
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
