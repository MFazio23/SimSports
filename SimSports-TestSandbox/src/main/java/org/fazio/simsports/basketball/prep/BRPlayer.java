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
	private String positions;
	private String offensiveReb;
	private String offensiveRebRate;
	private String defensiveReb;
	private String defensiveRebRate;
	private String totalReboundPct;
	private String assistPct;
	private String stealPct;
	private String blockPct;
	private String turnoverPct;
	private String usagePct;
	private String defenseRate;
	private String ftPct;
	private String ftRate;
	private String atRimPct;
	private String atRimAstPct;
	private String threeToNinePct;
	private String threeToNineAstPct;
	private String tenToFifteenPct;
	private String tenToFifteenAstPct;
	private String sixteenTo3PTPct;
	private String sixteenTo3PTAstPct;
	private String threePtPct;
	private String threePtAstPct;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(final String team) {
		this.team = team;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(final String positions) {
		this.positions = positions;
	}

	public String getOffensiveReb() {
		return offensiveReb;
	}

	public void setOffensiveReb(final String offensiveReb) {
		this.offensiveReb = offensiveReb;
	}

	public String getOffensiveRebRate() {
		return offensiveRebRate;
	}

	public void setOffensiveRebRate(final String offensiveRebRate) {
		this.offensiveRebRate = offensiveRebRate;
	}

	public String getDefensiveReb() {
		return defensiveReb;
	}

	public void setDefensiveReb(final String defensiveReb) {
		this.defensiveReb = defensiveReb;
	}

	public String getDefensiveRebRate() {
		return defensiveRebRate;
	}

	public void setDefensiveRebRate(final String defensiveRebRate) {
		this.defensiveRebRate = defensiveRebRate;
	}

	public String getTotalReboundPct() {
		return totalReboundPct;
	}

	public void setTotalReboundPct(final String totalReboundPct) {
		this.totalReboundPct = totalReboundPct;
	}

	public String getAssistPct() {
		return assistPct;
	}

	public void setAssistPct(final String assistPct) {
		this.assistPct = assistPct;
	}

	public String getStealPct() {
		return stealPct;
	}

	public void setStealPct(final String stealPct) {
		this.stealPct = stealPct;
	}

	public String getBlockPct() {
		return blockPct;
	}

	public void setBlockPct(final String blockPct) {
		this.blockPct = blockPct;
	}

	public String getTurnoverPct() {
		return turnoverPct;
	}

	public void setTurnoverPct(final String turnoverPct) {
		this.turnoverPct = turnoverPct;
	}

	public String getUsagePct() {
		return usagePct;
	}

	public void setUsagePct(final String usagePct) {
		this.usagePct = usagePct;
	}

	public String getDefenseRate() {
		return defenseRate;
	}

	public void setDefenseRate(final String defenseRate) {
		this.defenseRate = defenseRate;
	}

	public String getFtPct() {
		return ftPct;
	}

	public void setFtPct(final String ftPct) {
		this.ftPct = ftPct;
	}

	public String getFtRate() {
		return ftRate;
	}

	public void setFtRate(final String ftRate) {
		this.ftRate = ftRate;
	}

	public String getAtRimPct() {
		return atRimPct;
	}

	public void setAtRimPct(final String atRimPct) {
		this.atRimPct = atRimPct;
	}

	public String getAtRimAstPct() {
		return atRimAstPct;
	}

	public void setAtRimAstPct(final String atRimAstPct) {
		this.atRimAstPct = atRimAstPct;
	}

	public String getThreeToNinePct() {
		return threeToNinePct;
	}

	public void setThreeToNinePct(final String threeToNinePct) {
		this.threeToNinePct = threeToNinePct;
	}

	public String getThreeToNineAstPct() {
		return threeToNineAstPct;
	}

	public void setThreeToNineAstPct(final String threeToNineAstPct) {
		this.threeToNineAstPct = threeToNineAstPct;
	}

	public String getTenToFifteenPct() {
		return tenToFifteenPct;
	}

	public void setTenToFifteenPct(final String tenToFifteenPct) {
		this.tenToFifteenPct = tenToFifteenPct;
	}

	public String getTenToFifteenAstPct() {
		return tenToFifteenAstPct;
	}

	public void setTenToFifteenAstPct(final String tenToFifteenAstPct) {
		this.tenToFifteenAstPct = tenToFifteenAstPct;
	}

	public String getSixteenTo3PTPct() {
		return sixteenTo3PTPct;
	}

	public void setSixteenTo3PTPct(final String sixteenTo3PTPct) {
		this.sixteenTo3PTPct = sixteenTo3PTPct;
	}

	public String getSixteenTo3PTAstPct() {
		return sixteenTo3PTAstPct;
	}

	public void setSixteenTo3PTAstPct(final String sixteenTo3PTAstPct) {
		this.sixteenTo3PTAstPct = sixteenTo3PTAstPct;
	}

	public String getThreePtPct() {
		return threePtPct;
	}

	public void setThreePtPct(final String threePtPct) {
		this.threePtPct = threePtPct;
	}

	public String getThreePtAstPct() {
		return threePtAstPct;
	}

	public void setThreePtAstPct(final String threePtAstPct) {
		this.threePtAstPct = threePtAstPct;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.team + " (" + this.id + ")";
	}

	public String toFullString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("BRPlayer");
		sb.append("{id='").append(id).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", team='").append(team).append('\'');
		sb.append(", positions='").append(positions).append('\'');
		sb.append(", offensiveReb='").append(offensiveReb).append('\'');
		sb.append(", offensiveRebRate='").append(offensiveRebRate).append('\'');
		sb.append(", defensiveReb='").append(defensiveReb).append('\'');
		sb.append(", defensiveRebRate='").append(defensiveRebRate).append('\'');
		sb.append(", totalReboundPct='").append(totalReboundPct).append('\'');
		sb.append(", assistPct='").append(assistPct).append('\'');
		sb.append(", stealPct='").append(stealPct).append('\'');
		sb.append(", blockPct='").append(blockPct).append('\'');
		sb.append(", turnoverPct='").append(turnoverPct).append('\'');
		sb.append(", usagePct='").append(usagePct).append('\'');
		sb.append(", defenseRate='").append(defenseRate).append('\'');
		sb.append(", ftPct='").append(ftPct).append('\'');
		sb.append(", ftRate='").append(ftRate).append('\'');
		sb.append(", atRimPct='").append(atRimPct).append('\'');
		sb.append(", atRimAstPct='").append(atRimAstPct).append('\'');
		sb.append(", threeToNinePct='").append(threeToNinePct).append('\'');
		sb.append(", threeToNineAstPct='").append(threeToNineAstPct).append('\'');
		sb.append(", tenToFifteenPct='").append(tenToFifteenPct).append('\'');
		sb.append(", tenToFifteenAstPct='").append(tenToFifteenAstPct).append('\'');
		sb.append(", sixteenTo3PTPct='").append(sixteenTo3PTPct).append('\'');
		sb.append(", sixteenTo3PTAstPct='").append(sixteenTo3PTAstPct).append('\'');
		sb.append(", threePtPct='").append(threePtPct).append('\'');
		sb.append(", threePtAstPct='").append(threePtAstPct).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
