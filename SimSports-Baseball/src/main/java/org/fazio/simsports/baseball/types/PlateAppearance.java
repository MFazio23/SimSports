package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.Game;
import org.fazio.simsports.core.types.Play;
import org.fazio.simsports.core.types.PlayResult;
import org.fazio.simsports.core.types.Player;

/**
 * @author Michael Fazio
 */
public class PlateAppearance extends Play {

	private final Player pitcher;
	private final Player batter;
	
	public PlateAppearance(final Game game, final Player pitcher, final Player batter) {
		super(game);
		this.pitcher = pitcher;
		this.batter = batter;
	}

	@Override
	public PlayResult getPlayResult() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
