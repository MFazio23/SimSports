package org.fazio.simsports.basketball.prep;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 11/28/12 1:04 AM
 */
@Entity("brplayers")
public class BRPlayer {

	@Id
	private String id;
	private String name;
	private String team;
	private String fieldGoalPct;
	private String threePointPct;
	private String freeThrowPct;
	private String offensiveReb;
	private String defensiveReb;
	private String totalReboundPct;
	private String assistPct;
	private String stealPct;
	private String blockPct;
	private String turnoverPct;
	private String usagePct;

	public BRPlayer(final String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.team + " (" + this.id + ")";
	}
}
