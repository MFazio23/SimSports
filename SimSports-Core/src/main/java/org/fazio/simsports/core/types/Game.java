package org.fazio.simsports.core.types;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 2/28/12 6:22 PM
 */
public abstract class Game {
	
	protected final Team homeTeam;
	protected final Team awayTeam;
	
	protected Map<Team, Integer> scoreMap = new HashMap<Team, Integer>();
	
	public Game(final Team homeTeam, final Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public PlayResult playNextEvent() {
		PlayResult result = null;

		if(!isGameOver()) {
			this.playNextGameEvent();
		}

		return result;
	}

	protected abstract PlayResult playNextGameEvent();
	public abstract boolean isGameOver();
	
	public Team getWinningTeam() {
		Team winningTeam = null;

		final int homeScore = this.scoreMap.get(homeTeam);
		final int awayScore = this.scoreMap.get(awayTeam);

		if(homeScore > awayScore) {
			winningTeam = this.homeTeam;
		} else if(homeScore < awayScore) {
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
		this.scoreMap.put(this.homeTeam, this.getHomeScore() + addedPoints);
	}

	public int getHomeScore() {
		return this.scoreMap.get(this.homeTeam);
	}

	public void setHomeScore(final int homeScore) {
		this.scoreMap.put(this.homeTeam, homeScore);
	}

	public void addToAwayScore(final int addedPoints) {
		this.scoreMap.put(this.awayTeam, this.getAwayScore() + addedPoints);
	}

	public int getAwayScore() {
		return this.scoreMap.get(this.awayTeam);
	}

	public void setAwayScore(final int awayScore) {
		this.scoreMap.put(this.awayTeam, awayScore);
	}
}
