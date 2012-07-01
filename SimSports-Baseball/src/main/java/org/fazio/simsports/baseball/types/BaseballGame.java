package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.Game;
import org.fazio.simsports.core.types.PlayResult;
import org.fazio.simsports.core.types.Team;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/13/12 3:49 PM
 */
public class BaseballGame extends Game {

	private final Map<Team, Integer> scoreMap = new HashMap<Team, Integer>();
	private final Bases bases = new Bases();

	private int inning = 1;
	private boolean topOfInning = true;
	private int outs = 0;

	public BaseballGame(final Team homeTeam, final Team awayTeam) {
		super(homeTeam, awayTeam);

		scoreMap.put(this.awayTeam, 0);
		scoreMap.put(this.homeTeam, 0);
	}

	@Override
	protected PlayResult playNextGameEvent() {
		PlayResult result = null;

		BaseballTeam teamUpToBat = (BaseballTeam) this.awayTeam;
		final BaseballPlayer playerUpToBat = teamUpToBat.nextUpToBat();
		result = playerUpToBat.getPlayResult();

		this.getOuts(result);


		return result;
	}

	protected int getOuts(final PlayResult result) {
		//TODO: Actually implement this.
		int outs = 0;
		if(((PlateAppearanceResult)result).isOut()) outs = 1;
		return outs;
	}

	@Override
	public boolean isGameOver() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Map<Team, Integer> getScoreMap() {
		return scoreMap;
	}

	public int getHomeScore() {
		return this.scoreMap.get(this.homeTeam);
	}

	public int getAwayScore() {
		return this.scoreMap.get(this.awayTeam);
	}

	public Bases getBases() {
		return bases;
	}

	public int getInning() {
		return inning;
	}

	public boolean isTopOfInning() {
		return topOfInning;
	}

	public int getOuts() {
		return outs;
	}

	private enum HalfOfInning {Top, Bottom};
}
