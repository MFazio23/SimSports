package org.fazio.simsports.baseball.schedule;

import org.fazio.simsports.core.types.Schedule;
import org.fazio.simsports.core.types.Team;

import java.util.List;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/30/12 10:50 PM
 */
public class Baseball12TeamScheduler {

	private final List<Team> east;
	private final List<Team> west;

	public Baseball12TeamScheduler(final List<Team> east, final List<Team> west) {
		this.east = east;
		this.west = west;
	}

	public Schedule compileSchedule() {
		//TODO: Complete this.

		this.getRandomInDivisionMatchups();
		this.getRandomInDivisionMatchups();
		this.getRandomOutOfDivisionMatchups();
		this.getRandomInDivisionMatchups();
		this.getRandomInDivisionMatchups();
		this.getAllStarBreak();
		this.getRandomInDivisionMatchups();
		this.getRandomInDivisionMatchups();
		this.getRandomOutOfDivisionMatchups();
		this.getRandomInDivisionMatchups();
		this.getRandomInDivisionMatchups();
		
		return null;
	}
	
	protected void getRandomInDivisionMatchups() {
		System.out.println("D");
	}
	
	protected void getRandomOutOfDivisionMatchups() {
		System.out.println("I");
	}

	protected void getAllStarBreak() {
		System.out.println("ASB");
	}

	public List<Team> getEast() {
		return east;
	}

	public List<Team> getWest() {
		return west;
	}
}
