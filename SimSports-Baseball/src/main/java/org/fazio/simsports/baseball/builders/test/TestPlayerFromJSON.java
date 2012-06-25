package org.fazio.simsports.baseball.builders.test;

import org.fazio.simsports.baseball.builders.BaseballPlayerBuilder;
import org.fazio.simsports.baseball.builders.BattingAttributesByPABuilder;
import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.fazio.simsports.baseball.types.attributes.BatterAttributes;
import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPA;
import org.fazio.simsports.core.types.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/13/12 2:59 PM
 */
public class TestPlayerFromJSON {

	public BaseballPlayer createPlayer(final String playerName, final int year) {

		final String filename = new StringBuilder()
			.append(playerName.replaceAll(" ", ""))
			.append(year)
			.append(".json")
			.toString();

		final InputStream stream = this.getClass().getClassLoader().getResourceAsStream("testplayers/" + filename);

		final StringBuilder sb = new StringBuilder();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

		char[] buf = new char[1024];
		int numRead = 0;
		try {
			while ((numRead = reader.read(buf)) != -1) {
				final String readData = String.valueOf(buf, 0, numRead);
				sb.append(readData);
				buf = new char[1024];
			}

			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

		return this.convertJSONToBaseballPlayer(sb.toString());

	}

	private BaseballPlayer convertJSONToBaseballPlayer(final String jsonString) {

		BaseballPlayer player = null;

		try {
			final JSONObject json = new JSONObject(jsonString);

			player = this.createPlayerFromJSONObject(json);
		} catch(JSONException e) {
			e.printStackTrace();
		}

		return player;

	}

	private BaseballPlayer createPlayerFromJSONObject(final JSONObject json) {
		BaseballPlayer player = null;

		try {

			final JSONObject playerInfo = json.getJSONObject("playerInfo");
			final JSONObject nonContactRates = json.getJSONObject("nonContactRates");

			final JSONObject contactRates = json.getJSONObject("contactRates");

			final JSONObject groundBallRates = contactRates.getJSONObject("groundBallRates");
			final JSONObject flyBallRates = contactRates.getJSONObject("flyBallRates");
			final JSONObject lineDriveRates = contactRates.getJSONObject("lineDriveRates");

			final Attributes batterAttributes = this.getBatterAttributes(nonContactRates, groundBallRates, flyBallRates, lineDriveRates);

			final String[] playerName = playerInfo.getString("name").split(" ");

			player = (BaseballPlayer) new BaseballPlayerBuilder()
				.setFirstName(playerName[0])
				.setLastName(playerName[1])
				.setNickname(playerName[1] + "y")
				.setAttributes(batterAttributes)
				.setTeam(Mockito.mock(Team.class))
				.setPosition(Mockito.mock(Position.class))
				.setStatistics(Mockito.mock(Statistics.class))
				.setRatings(Mockito.mock(Ratings.class))
				.build();

		} catch(JSONException e) {
			e.printStackTrace();
		}

		return player;
	}

	private BatterAttributes getBatterAttributes(final JSONObject nonContactRates, final JSONObject groundBallRates, final JSONObject flyBallRates, final JSONObject lineDriveRates) throws JSONException {
		final BattingAttributesByPA attributesByPA = new BattingAttributesByPABuilder()
			.setStrikeoutChance(nonContactRates.getDouble("SO%"))
			.setStrikeoutLookingChance(nonContactRates.getDouble("L/SO"))
			.setWalkChance(nonContactRates.getDouble("BB%"))
			.setHitByPitchChance(nonContactRates.getDouble("hbpRate"))
			.setContactFlyBallChance(flyBallRates.getDouble("contactRate"))
			.setContactGroundBallChance(groundBallRates.getDouble("contactRate"))
			.setContactLineDriveChance(lineDriveRates.getDouble("contactRate"))
			.setGroundBallSingleChance(groundBallRates.getDouble("singleRate"))
			.setGroundBallDoubleChance(groundBallRates.getDouble("doubleRate"))
			.setGroundBallTripleChance(groundBallRates.getDouble("tripleRate"))
			.setGroundBallHomeRunChance(groundBallRates.getDouble("homeRunRate"))
			.setFlyBallSingleChance(flyBallRates.getDouble("singleRate"))
			.setFlyBallDoubleChance(flyBallRates.getDouble("doubleRate"))
			.setFlyBallTripleChance(flyBallRates.getDouble("tripleRate"))
			.setFlyBallHomeRunChance(flyBallRates.getDouble("homeRunRate"))
			.setLineDriveSingleChance(lineDriveRates.getDouble("singleRate"))
			.setLineDriveDoubleChance(lineDriveRates.getDouble("doubleRate"))
			.setLineDriveTripleChance(lineDriveRates.getDouble("tripleRate"))
			.setLineDriveHomeRunChance(lineDriveRates.getDouble("homeRunRate"))
			.build();

		return new BatterAttributes(attributesByPA, Mockito.mock(Attributes.class));
	}
}
