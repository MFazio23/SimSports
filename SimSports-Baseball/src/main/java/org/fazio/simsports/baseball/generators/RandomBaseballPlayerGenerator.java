package org.fazio.simsports.baseball.generators;

import org.fazio.simsports.baseball.types.BaseballPosition;
import org.fazio.simsports.core.RandomPlayerGenerator;
import org.fazio.simsports.core.types.Player;
import org.fazio.simsports.core.util.JSONLoader;
import org.fazio.utils.pair.Pair;
import org.fazio.utils.range.RangeGroup;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Michael Fazio
 */
public class RandomBaseballPlayerGenerator implements RandomPlayerGenerator {

	public static final String FIRST_NAME_FOLDER = "names/firstnames/";
	public static final String LAST_NAME_FOLDER = "names/lastnames/";
	public static final String FIRST_NAME_FILE = "FirstNames.txt";
	public static final String LAST_NAME_FILE = "LastNames.txt";
	public static final String RANDOM_NUMBER_FILE = "randomizers/random-numbers.json";
	public static final String RANDOM_POSITION_FILE = "randomizers/random-positions.json";

	public Player generateRandomPlayer() {
		return this.generateRandomPlayer(this.getRandomPositions().get(0));
	}

	public Player generateRandomPlayer(final BaseballPosition position) {
		final String[] name = this.getRandomName();
		final int number = this.getRandomNumber(position.isPitcher());



		return null;
	}

	protected String[] getRandomName() {
		final String[] randomName = new String[2];
		final RangeGroup<NameType> nameTypes = new RangeGroup<NameType>()
			.addRangeValue(NameType.Hispanic, 25)
			.addRangeValue(NameType.Japanese, 5)
			.setDefaultRangeValue(NameType.American);

		final NameType nameType = (NameType) nameTypes.getRangeValue();

		final List<String> firstNameList = createNameList(FIRST_NAME_FOLDER + nameType.name() + FIRST_NAME_FILE);
		final List<String> lastNameList = createNameList(LAST_NAME_FOLDER + nameType.name() + LAST_NAME_FILE);

		randomName[0] = firstNameList.get((int)(Math.random() * firstNameList.size()));
		randomName[1] = lastNameList.get((int)(Math.random() * lastNameList.size()));

		return randomName;
	}

	protected int getRandomNumber(final boolean isPitcher) {
		return this.getRandomNumber(isPitcher, new ArrayList<Integer>());
	}

	protected int getRandomNumber(final boolean isPitcher, final List<Integer> invalidNumbers) {
		int randomNumber = -1;
		try {
			final JSONObject numberJSON = new JSONLoader().loadJSONObjectFromFile(RANDOM_NUMBER_FILE);

			final String positionType = isPitcher ? "pitchers" : "batters";
			final JSONArray numberArray = numberJSON.getJSONArray(positionType);
			final RangeGroup<Integer> numberGroup = new RangeGroup<Integer>();
			for(int x=0;x<numberArray.length();x++) {
				final JSONObject jsonRange = numberArray.getJSONObject(x);
				final RangeGroup<Integer> rangeGroup = new RangeGroup<Integer>(jsonRange.getInt("chance"));

				final int low = jsonRange.getInt("low");
				final int high = jsonRange.getInt("high");

				if(low == high) {
					rangeGroup.addRangeValue(low, 100);
				} else {
					for(int v=low;v<=high;v++) {
						rangeGroup.addRangeValue(v, (100 / (high - low)));
					}
				}

				numberGroup.addToRangeGroup(rangeGroup);
			}

			while(randomNumber == -1 || invalidNumbers.contains(randomNumber)) {
				randomNumber = (Integer)numberGroup.getRangeValue();
			}
		} catch(JSONException e) {
			e.printStackTrace();
		}

		return randomNumber;
	}

	protected List<String> createNameList(final String filePath) {
		final List<String> nameList = new ArrayList<String>();
		final InputStream firstNameFileStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
		final Scanner scanner = new Scanner(firstNameFileStream);
		while(scanner.hasNext()) {
			final String[] line = scanner.nextLine().split(" - ");

			for(int x=0;x<Integer.parseInt(line[1]);x++) {
				nameList.add(line[0]);
			}
		}

		return nameList;
	}

	protected List<BaseballPosition> getRandomPositions() {
		final List<BaseballPosition> positionList = new ArrayList<BaseballPosition>();
		final RangeGroup<Pair<String, JSONObject>> positionsRangeGroup = new RangeGroup<Pair<String, JSONObject>>();
		try {
			final JSONObject positionJSON = new JSONLoader().loadJSONObjectFromFile(RANDOM_POSITION_FILE);

			final Iterator positionIterator = positionJSON.keys();
			while(positionIterator.hasNext()) {
				final String positionString = (String) positionIterator.next();
				final JSONObject positionInfoJSON = positionJSON.getJSONObject(positionString);
				final int chance = positionInfoJSON.getInt("chance");
				positionsRangeGroup.addRangeValue(
					new Pair<String, JSONObject>(positionString, positionInfoJSON.getJSONObject("alternates")),
					chance
				);
			}

			//TODO: Add an actual list of positions.  Give chances for 1 -> x number of positions then pick that many.
			positionList.add((BaseballPosition)BaseballPosition.getPositionByShortName(positionsRangeGroup.getRangeValue().getLeft()));
		} catch(JSONException e) {
			e.printStackTrace();
		}

		return positionList;
	}

	protected enum NameType {American, Hispanic, Japanese}

}
