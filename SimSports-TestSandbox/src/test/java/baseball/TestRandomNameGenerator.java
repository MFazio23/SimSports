package baseball;

import org.fazio.simsports.core.ranges.Range;
import org.fazio.simsports.core.ranges.RangeGroup;
import org.fazio.simsports.core.ranges.RangeValue;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.*;

/**
 * @author Michael Fazio
 */
public class TestRandomNameGenerator {

	//Yes, this is extremely simplified.  And yes, I know "American" isn't a race.
	//This was just the easiest way to get some random players into the game, and is
	//not any kind of racial statement.  Lazy coding?  Sure!  But no intentional
	//racial undertones.
	private enum Race {American, Hispanic, Japanese};

	@Test
	public void testRandomRace() throws Exception {
		RangeGroup races = new RangeGroup()
			.addToRangeGroup(new RangeValue(25, Race.Hispanic))
			.addToRangeGroup(new RangeValue(5, Race.Japanese))
			.setDefaultRange(new RangeValue(Race.American));

		Map<Race, Integer> raceMap = new HashMap<Race, Integer>(){{
			put(Race.American, 0);
			put(Race.Hispanic, 0);
			put(Race.Japanese, 0);
		}};

		for(int x=0;x<50000;x++) {
			Race race = (Race) races.getRangeValue();
			raceMap.put(race, raceMap.get(race) + 1);
		}

		for(Map.Entry<Race, Integer> raceCount : raceMap.entrySet()) {
			System.out.println(raceCount.getKey() + " = " + raceCount.getValue() + " (" + (int)((raceCount.getValue().doubleValue()/50000d)*100) + "%)");
		}
	}

	@Test
	public void testNameList() throws Exception {
		final Map<String, Integer> nameCounts = new TreeMap<String, Integer>();
		final InputStream fileStream = this.getClass().getClassLoader().getResourceAsStream("names/lastnames/HispanicLastNames.txt");
		final Scanner scanner = new Scanner(fileStream);
		while(scanner.hasNext()) {
			final String name = scanner.next();
			if(!nameCounts.containsKey(name)) nameCounts.put(name, 0);
			nameCounts.put(name, nameCounts.get(name) + 1);
		}

		for(Map.Entry<String, Integer> count : nameCounts.entrySet()) {
			System.out.println(count.getKey() + " - " + count.getValue());
		}
	}

	@Test
	public void testNameGenerator() throws Exception {
		final List<String> firstNameList = this.createNameList("names/firstnames/AmericanFirstNames.txt");
		final List<String> lastNameList = this.createNameList("names/lastnames/AmericanLastNames.txt");

		for(int x=0;x<20;x++) {
			final int firstNameInd = (int)(Math.random() * firstNameList.size());
			final int lastNameInd = (int)(Math.random() * lastNameList.size());

			System.out.println(firstNameList.get(firstNameInd) + " " + lastNameList.get(lastNameInd));
		}

	}

	private List<String> createNameList(final String filePath) {
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

}
