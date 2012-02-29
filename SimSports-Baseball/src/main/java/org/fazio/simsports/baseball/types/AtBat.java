package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.Game;
import org.fazio.simsports.core.types.Play;
import org.fazio.simsports.core.types.Player;

/**
 * @author Michael Fazio
 */
public class AtBat extends Play {

	private final Player pitcher;
	private final Player batter;
	
	public AtBat(final Game game, final Player pitcher, final Player batter) {
		super(game);
		this.pitcher = pitcher;
		this.batter = batter;
	}
	
}
