package org.fazio.simsports.core.types;

/**
 * @author Michael Fazio
 */
public abstract class Play {

	protected Game game;
	
	protected Play(final Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return this.game;
	}
	
	public Team getHomeTeam() {
		return this.game.getHomeTeam();
	}
	
	public Team getAwayTeam() {
		return this.game.getAwayTeam();
	}

	public abstract PlayResult getPlayResult();

}
