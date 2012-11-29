package basketball;

import org.fazio.utils.map.CountingHashMap;
import org.fazio.utils.map.CountingMap;
import org.fazio.utils.range.RangeGroup;
import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 11/23/12 12:50 PM
 */
public class TestBasketball {

	final NumberFormat numFormat = NumberFormat.getInstance();

	@Before
	public void setUp() throws Exception {
		this.numFormat.setMinimumFractionDigits(3);
		this.numFormat.setMaximumFractionDigits(3);
	}

	@Test
	public void testBasketball() throws Exception {

		RangeGroup<String> rangeRim = new RangeGroup<String>(32.9)
			.addRangeValue("Rim Make", 76.1)
			.setDefaultRangeValue("Rim Miss");
		RangeGroup<String> rangeClose = new RangeGroup<String>(15.2)
			.addRangeValue("Close Make", 46.5)
			.setDefaultRangeValue("Close Miss");
		RangeGroup<String> rangeMid = new RangeGroup<String>(13.4)
			.addRangeValue("Mid Make", 48)
			.setDefaultRangeValue("Mid Miss");
		RangeGroup<String> rangeLong = new RangeGroup<String>(24.6)
			.addRangeValue("Long Make", 37.2)
			.setDefaultRangeValue("Long Miss");
		RangeGroup<String> range3PT = new RangeGroup<String>(14)
			.addRangeValue("3PT Make", 32.5)
			.setDefaultRangeValue("3PT Miss");

		RangeGroup<String> shotRange = new RangeGroup<String>()
			.addToRangeGroup(rangeRim)
			.addToRangeGroup(rangeClose)
			.addToRangeGroup(rangeMid)
			.addToRangeGroup(rangeLong)
			.addToRangeGroup(range3PT);

		RangeGroup<String> foul = new RangeGroup<String>(30)
			.addRangeValue("FT Make", 77.1)
			.setDefaultRangeValue("FT Miss");

		RangeGroup<String> shotFoul = new RangeGroup<String>()
			.addToRangeGroup(foul)
			.setDefaultRange(shotRange);

		RangeGroup<String> leBron = new RangeGroup<String>(32)
			.addRangeValue("Turnover", 13.3)
			.setDefaultRange(shotFoul);

		RangeGroup<String> team = new RangeGroup<String>()
			.addToRangeGroup(leBron)
			.setDefaultRangeValue("Someone Else");

		final CountingMap<String, Long> countMap = new CountingHashMap<String, Long>();

		final double testFactor = 10000.0;
		final double rate = 91.2 * testFactor;

		for(int x=0;x<rate;x++) {
			countMap.increaseCount(team.getRangeValue());
		}

		for(String key : countMap.keySet()) {
			System.out.println(key + " = " + countMap.get(key));
		}

		final double makes =
				countMap.get("Rim Make").doubleValue()
				+ countMap.get("Close Make").doubleValue()
				+ countMap.get("Mid Make").doubleValue()
				+ countMap.get("Long Make").doubleValue()
				+ countMap.get("3PT Make").doubleValue();

		final double misses =
				countMap.get("Rim Miss").doubleValue()
				+ countMap.get("Close Miss").doubleValue()
				+ countMap.get("Mid Miss").doubleValue()
				+ countMap.get("Long Miss").doubleValue()
				+ countMap.get("3PT Miss").doubleValue();

		System.out.println("Rim Shooting Pct = " + this.numFormat.format(
			countMap.get("Rim Make").doubleValue() / (countMap.get("Rim Make").doubleValue() + countMap.get("Rim Miss").doubleValue())
		));
		System.out.println("Close Shooting Pct = " + this.numFormat.format(
			countMap.get("Close Make").doubleValue() / (countMap.get("Close Make").doubleValue() + countMap.get("Close Miss").doubleValue())
		));
		System.out.println("Mid Shooting Pct = " + this.numFormat.format(
			countMap.get("Mid Make").doubleValue() / (countMap.get("Mid Make").doubleValue() + countMap.get("Mid Miss").doubleValue())
		));
		System.out.println("Long Shooting Pct = " + this.numFormat.format(
			countMap.get("Long Make").doubleValue() / (countMap.get("Long Make").doubleValue() + countMap.get("Long Miss").doubleValue())
		));
		System.out.println("3PT Shooting Pct = " + this.numFormat.format(
			countMap.get("3PT Make").doubleValue() / (countMap.get("3PT Make").doubleValue() + countMap.get("3PT Miss").doubleValue())
		));
		System.out.println("Free Throw Pct = " + this.numFormat.format(
			countMap.get("FT Make").doubleValue()/(countMap.get("FT Make").doubleValue() + countMap.get("FT Miss").doubleValue())
		));
		System.out.println("Shooting Pct = " + this.numFormat.format(
			makes/(makes + misses)
		));
		System.out.println("Turnover Rate = " + this.numFormat.format(
			countMap.get("Turnover").doubleValue() / (rate - countMap.get("Someone Else").doubleValue())
		));
		System.out.println("Usage Rate = " + this.numFormat.format(
			(rate - countMap.get("Someone Else").doubleValue()) / rate)
		);

		System.out.println("//// GAME SIM ////");

		final List<Double> pointList = new ArrayList<Double>();

		double gamesPlayed = 10000000.0;

		for(int x=0;x<gamesPlayed;x++) {
			double points = 0.0;
			for(int p=0;p<91;p++) {
				final String value = team.getRangeValue();
				if(value.contains("Make")) points += 2;
				if(value.equals("FT Make")) points -= 1;
				if(value.equals("3PT Make")) points += 1;
			}
			pointList.add(points);
		}

		Collections.sort(pointList);
		System.out.println("High Points = " + pointList.get(pointList.size() - 1));
		System.out.println("Low Points = " + pointList.get(0));
		int totalPoints = 0;
		for(Double game : pointList) totalPoints += game;
		System.out.println("Average Points = " + (totalPoints / gamesPlayed));
	}
}
