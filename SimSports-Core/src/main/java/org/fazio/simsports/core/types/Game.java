package org.fazio.simsports.core.types;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 2/28/12 6:22 PM
 */
public abstract class Game {
	
	protected final Team homeTeam;
	protected final Team awayTeam;
	
	protected int homeScore;
	protected int awayScore;

	protected boolean gameOver = false;
	
	public Game(final Team homeTeam, final Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}
	
	public Team getWinningTeam() {
		Team winningTeam = null;
		
		if(this.homeScore > this.awayScore) {
			winningTeam = this.homeTeam;
		} else if(this.homeScore < this.awayScore) {
			winningTeam = this.awayTeam;
		}

		return winningTeam;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}
	
	public void addToHomeScore(final int addedPoints) {
		this.homeScore += addedPoints;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(final int homeScore) {
		this.homeScore = homeScore;
	}

	public void addToAwayScore(final int addedPoints) {
		this.awayScore += addedPoints;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(final int awayScore) {
		this.awayScore = awayScore;
	}

	public boolean isGameOver() {
		return this.gameOver;
	}
}
