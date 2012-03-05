import org.fazio.simsports.baseball.builders.BatterAttributesBuilder;
import org.fazio.simsports.baseball.types.BatterAttributes;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * @author Michael Fazio
 */
public class TestPitchByPitch {

	private BatterAttributes attrs
		= new BatterAttributesBuilder()
			.setBatterPitchStrikeRate(62.02)
			.setBatterPitchHBPRate(0.2)
			.setBatterPitchSwingRate(44.6)
			.setBatterSwingFoulRate()
			.setBatterSwingContactRate()
			.setBatterSwingStrikeRate()
			.build();

	Map<String, Integer> counts;
	RangeGroup mainRangeGroup;

	private static final double testCount = 2488.0;
	private static final double testFactor = 1000.0;

	@Before
	public void setUp() throws Exception {
		this.mainRangeGroup = new RangeGroup();
		this.mainRangeGroup
			.addToRangeGroup(new RangeValue(attrs.getBatterPitchBallRate(), "Ball"))
			.setDefaultRange(
				new RangeGroup()
					.setDefaultRange(new RangeValue("Strike"))
					.addToRangeGroup(
						new RangeGroup(attrs.getBatterInPlayRate())
							.setDefaultRange(new RangeValue("Out"))
							.addToRangeGroup(new RangeValue(attrs.getBatterAverage(), "Hit"))
					)
			);
		/*this.mainRangeGroup
			.addToRangeGroup(new RangeValue(attrs.getBatterPitchBallRate(), "Ball"))
			.setDefaultRange(
				new RangeGroup()
					.setDefaultRange(new RangeValue("Strike"))
					.addToRangeGroup(
						new RangeGroup(attrs.getBatterInPlayRate())
							.setDefaultRange(new RangeValue("Out"))
							.addToRangeGroup(
								new RangeGroup(attrs.getBatterAverage())
									.setDefaultRange(new RangeValue("Single"))
									.addToRangeGroup(new RangeValue(20.32, "Double"))
									.addToRangeGroup(new RangeValue(3.21, "Triple"))
									.addToRangeGroup(new RangeValue(17.65, "Home Run"))
							)
					)
			);*/

		this.counts = new LinkedHashMap<String, Integer>();
		this.counts.put("Ball", 0);
		this.counts.put("Strike", 0);
		this.counts.put("Out", 0);
		this.counts.put("Hit", 0);
		this.counts.put("Single", 0);
		this.counts.put("Double", 0);
		this.counts.put("Triple", 0);
		this.counts.put("Home Run", 0);
	}

	@Test
	public void testPitchByPitchCounts() throws Exception {
		int tests = (int)(testCount * testFactor);
		String rangeValue = "";

		for(int x=0;x<tests;x++) {
			rangeValue = (String)this.mainRangeGroup.getRangeValue();
			counts.put(rangeValue, counts.get(rangeValue) + 1);
			if(!rangeValue.equals("Ball")) {
				//counts.put("Strike", counts.get("Strike") + 1);
				if(!rangeValue.equals("Out")) {
					counts.put("Hit", counts.get("Hit") + 1);
				}
			}
		}

		this.printHitCounts(tests);
		//this.validateTotals();
	}

	private void validateTotals() {
		//assertEquals(376, Math.round(this.counts.get("Out").doubleValue() / testFactor));
		assertEquals(187, Math.round(this.counts.get("Hit").doubleValue() / testFactor));
		assertEquals(110, Math.round(this.counts.get("Single").doubleValue() / testFactor));
		assertEquals(38, Math.round(this.counts.get("Double").doubleValue() / testFactor));
		assertEquals(6, Math.round(this.counts.get("Triple").doubleValue() / testFactor));
		assertEquals(33, Math.round(this.counts.get("Home Run").doubleValue() / testFactor));
	}

	private void printHitCounts(int tests) {
		System.out.println("Balls = " + counts.get("Ball"));
		System.out.println("Strikes = " + counts.get("Strike"));
		System.out.println("Hits = " + counts.get("Hit"));
		System.out.println("Batting Average = " + ((double)counts.get("Hit")/tests));
		System.out.println("Percent successful = " + (((double)counts.get("Hit") / tests) * 100) + "%");
		System.out.println("====================");
		System.out.println("Hit Types:");
		for(Map.Entry<String, Integer> entry : counts.entrySet()) {
			//System.out.println("  " + entry.getKey() + ": " + ((double)entry.getValue() / counts.get("Hits")) * 100 + "%");
			System.out.println("  " + entry.getKey() + ": " + ((double)entry.getValue() / testFactor));
		}
	}
	
}
