package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.Player;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/14/12 2:43 PM
 */
public class Diamond {

	private Player[] bases = new Player[3];
	private PlateAppearance upToBat;

	public int runPlateAppearance() {
		PlateAppearanceResult result = (PlateAppearanceResult) this.upToBat.getPlayResult();

		//TODO: Finish this.

		return 0;
	}

	public int moveRunners(final Hit hit) {
		int runsScored = 0;
		
		for(int x=bases.length - 1 ; x >= 0 ; x--) {
			BaseballPlayer player = (BaseballPlayer) bases[x];
			int basesMoved = player.moveBases(hit);
			if(x + basesMoved > 3) {
				runsScored++;
			} else {
				bases[x + basesMoved] = player;
				bases[x] = null;
			}
		}
		
		return runsScored;
	}

	public Player getFirstBase() {
		return this.bases[0];
	}

	public void setFirstBase(final Player firstBase) {
		this.bases[0] = firstBase;
	}

	public Player getSecondBase() {
		return this.bases[1];
	}

	public void setSecondBase(final Player secondBase) {
		this.bases[2] = secondBase;
	}

	public Player getThirdBase() {
		return this.bases[2];
	}

	public void setThirdBase(final Player thirdBase) {
		this.bases[2] = thirdBase;
	}

	public PlateAppearance getUpToBat() {
		return upToBat;
	}

	public void setUpToBat(final PlateAppearance upToBat) {
		this.upToBat = upToBat;
	}
}
