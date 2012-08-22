package org.fazio.simsports.baseball.builders;

import org.apache.commons.lang3.StringUtils;
import org.fazio.simsports.baseball.types.BaseballTeam;
import org.fazio.simsports.core.types.Player;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/28/12 5:43 PM
 */
public class JSONBaseballTeamCreator {

	public final static String TEAM_PATH = "teams";

	public BaseballTeam createTeam(final String fileName) {

		final InputStream stream
			= this
				.getClass()
				.getClassLoader()
				.getResourceAsStream(JSONBaseballTeamCreator.TEAM_PATH + "/" + StringUtils.remove(fileName, " ") + ".json");

		final StringBuilder sb = new StringBuilder();
		final Scanner scanner = new Scanner(stream);
		while(scanner.hasNext()) {
			sb.append(scanner.next());
		}

		return this.convertJSONToBaseballTeam(sb.toString());

	}

	private BaseballTeam convertJSONToBaseballTeam(final String jsonString) {

		BaseballTeam team = null;

		try {
			final JSONObject json = new JSONObject(jsonString);

			team = this.createTeamFromJSONObject(json);
		} catch(JSONException e) {
			e.printStackTrace();
		}

		return team;

	}

	private BaseballTeam createTeamFromJSONObject(final JSONObject json) {
		BaseballTeam team = null;

		try {

			final String location = json.getString("location");
			final String nickname = json.getString("nickname");
			final String mainShortName = json.getString("mainShortName");
			final JSONArray shortNameList = json.getJSONArray("shortNameList");
			final JSONArray colors = json.getJSONArray("colors");
			final boolean randomRoster = json.getBoolean("randomRoster");
			List<Player> roster = null;
			if(randomRoster) {
				roster = this.getRandomTeamRoster();
			} else {
				final String rosterFolder = json.getString("rosterFolder");
				final JSONArray rosterNames = json.getJSONArray("roster");

				roster = this.getTeamRoster(rosterFolder, rosterNames);
			}

			team = (BaseballTeam) new BaseballTeamBuilder()
				.setLocation(location)
				.setNickname(nickname)
				.setMainShortName(mainShortName)
				.addToRoster(roster)
				.addToShortNameList(this.getShortNameList(mainShortName, shortNameList))
				.addToTeamColors(this.getTeamColors(colors))
				.build();

		} catch(JSONException e) {
			e.printStackTrace();
		}

		return team;
	}

	private List<Color> getTeamColors(final JSONArray colors) {
		final List<Color> teamColors = new ArrayList<Color>();

		for(int x=0;x<colors.length();x++) {
			try {
				final JSONArray colorValues = colors.getJSONArray(x);

				if(colorValues.length() == 3) {
					teamColors.add(new Color(colorValues.getInt(0), colorValues.getInt(1), colorValues.getInt(2)));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		return teamColors;
	}

	private List<String> getShortNameList(final String mainShortName, final JSONArray shortNameListJSON) {
		final List<String> shortNameList = new ArrayList<String>();

		for(int x=0;x<shortNameListJSON.length();x++) {
			try {
				final String shortName = shortNameListJSON.getString(x);
				if(!shortName.equalsIgnoreCase(mainShortName)) {
					shortNameList.add(shortName);
				}
			} catch(JSONException e) {
				e.printStackTrace();
			}
		}

		return shortNameList;
	}

	private List<Player> getTeamRoster(final String rosterFolder, final JSONArray rosterNames) {
		final List<Player> roster = new ArrayList<Player>();
		final JSONBaseballPlayerCreator playerCreator = new JSONBaseballPlayerCreator();

		for(int x=0;x<rosterNames.length();x++) {
			try {
				final StringBuilder fileName = new StringBuilder()
					.append(JSONBaseballTeamCreator.TEAM_PATH)
					.append("/")
					.append(rosterFolder)
					.append("/")
					.append(this.getPlayerNamePath(rosterNames.getJSONObject(x)))
					.append(".json");
				roster.add(playerCreator.createPlayer(fileName.toString()));
			} catch(JSONException e) {
				e.printStackTrace();
			}
		}

		return roster;
	}

	private List<Player> getRandomTeamRoster() {
		//TODO: Complete this.
		final List<Player> roster = new ArrayList<Player>();


		return roster;
	}

	private String getPlayerNamePath(final JSONObject playerInfo) throws JSONException {
		return StringUtils.remove(playerInfo.getString("playerName"), "	");
	}
}
