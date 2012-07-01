package org.fazio.simsports.baseball.builders;

import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.fazio.simsports.baseball.types.BaseballPosition;
import org.fazio.simsports.baseball.types.attributes.BaseballAttributes;
import org.fazio.simsports.baseball.types.attributes.BatterAttributes;
import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPA;
import org.fazio.simsports.core.types.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mockito.Mockito;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/25/12 2:33 PM
 */
public class JSONBaseballPlayerCreator {

	public BaseballPlayer createPlayer(final String fileName) {

		final InputStream stream = this.getClass().getClassLoader().getResourceAsStream(fileName);

		final StringBuilder sb = new StringBuilder();
		final Scanner scanner = new Scanner(stream);
		while(scanner.hasNext()) {
			sb.append(scanner.next());
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

			final JSONObject basicInfo = json.getJSONObject("basicInformation");
			final JSONObject nonContactRates = json.getJSONObject("nonContactRates");
			final JSONObject contactRates = json.getJSONObject("contactRates");

			final JSONObject groundBallRates = contactRates.getJSONObject("groundBallRates");
			final JSONObject flyBallRates = contactRates.getJSONObject("flyBallRates");
			final JSONObject lineDriveRates = contactRates.getJSONObject("lineDriveRates");

			final BatterAttributes batterAttributes
				= this.getBatterAttributes(nonContactRates, groundBallRates, flyBallRates, lineDriveRates);
			final BaseballAttributes baseballAttributes
				= new BaseballAttributes(batterAttributes, Mockito.mock(Attributes.class), Mockito.mock(Attributes.class));

			player = (BaseballPlayer) new BaseballPlayerBuilder()
				.setFirstName(basicInfo.getString("firstName"))
				.setLastName(basicInfo.getString("lastName"))
				.setNickname(basicInfo.getString("nickname"))
				.setNumber(basicInfo.getString("number"))
				.setPositions(this.findPosition(basicInfo.getJSONArray("position")))
				.setAttributes(baseballAttributes)
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
			.setStrikeoutChance(nonContactRates.getDouble("K%"))
			.setStrikeoutLookingChance(nonContactRates.getDouble("KL%"))
			.setWalkChance(nonContactRates.getDouble("BB%"))
			.setHitByPitchChance(nonContactRates.getDouble("HBP%"))
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

	private List<Position> findPosition(final JSONArray positionArray) {
		List<Position> positions = new ArrayList<Position>();

		try {
			for(int x=0;x<positionArray.length();x++) {
				positions.add(BaseballPosition.getPositionByShortName(positionArray.getString(x)));
			}
		} catch(JSONException e) {
			e.printStackTrace();
		}

		return positions;
	}
}
