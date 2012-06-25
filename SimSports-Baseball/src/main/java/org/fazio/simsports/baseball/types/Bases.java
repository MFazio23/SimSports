package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.Player;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/14/12 2:43 PM
 */
public class Bases {

	private Player[] bases = new Player[4];

	public int moveRunners(final BaseballPlayer batter, final PlateAppearanceResult hit) {

		int runsScored = 0;

		if(hit.getBases() > 0) {
			this.bases[0] = batter;

			for(int x=bases.length - 1 ; x >= 0 ; x--) {
				BaseballPlayer player = (BaseballPlayer) bases[x];
				if(player != null) {
					int basesMoved = player.moveBases(hit);
					if(x + basesMoved  > 3) {
						runsScored++;
						bases[x] = null;
					} else {
						bases[x + basesMoved] = player;
						bases[x] = null;
					}
				}
			}
		}
		
		return runsScored;
	}

	public boolean resetBases() {
		for(int x=0;x<this.bases.length;x++) {
			this.bases[x] = null;
		}

		return true;
	}

	public Player getFirstBase() {
		return this.bases[1];
	}

	public void setFirstBase(final Player firstBase) {
		this.bases[1] = firstBase;
	}

	public Player getSecondBase() {
		return this.bases[2];
	}

	public void setSecondBase(final Player secondBase) {
		this.bases[2] = secondBase;
	}

	public Player getThirdBase() {
		return this.bases[3];
	}

	public void setThirdBase(final Player thirdBase) {
		this.bases[3] = thirdBase;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append("First Base = [")
			.append(this.bases[1])
			.append("], Second Base = [")
			.append(this.bases[2])
			.append("], Third Base = [")
			.append(this.bases[3])
			.append("]")
			.toString();
	}
}
