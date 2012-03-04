import org.fazio.simsports.baseball.builders.BatterAttributesBuilder;
import org.fazio.simsports.baseball.types.BatterAttributes;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static junit.framework.Assert.assertEquals;

/**
 * @author Michael Fazio
 */
public class TestRanges {

	private BatterAttributes attrs
		= new BatterAttributesBuilder()
			.setBatterPitchBallRate(37.98)
			.setBatterAverage(33.22)
			.setBatterDoubleRate(20.32)
			.setBatterTripleRate(3.21)
			.setBatterHomeRunRate(17.65)
			.setBatterStrikeoutPercentage(14.8)
			.setBatterWalkPercentage(9.2)
			.build();

	Map<String, Integer> counts;
	RangeGroup mainRangeGroup;

	private static final double testFactor = 100000.0;
	
	@Before
	public void setUp() throws Exception {
		this.mainRangeGroup = new RangeGroup();
		this.mainRangeGroup
			.addToRangeGroup(
				new RangeGroup(attrs.getBatterAverage())
					.addToRangeGroup(new RangeValue(20.32, "Double"))
					.addToRangeGroup(new RangeValue(3.21, "Triple"))
					.addToRangeGroup(new RangeValue(17.65, "Home Run"))
					.setDefaultRange(new RangeValue("Single")))
			.setDefaultRange(new RangeValue("Out"));

		this.counts = new LinkedHashMap<String, Integer>();
		this.counts.put("Out", 0);
		this.counts.put("Hits", 0);
		this.counts.put("Single", 0);
		this.counts.put("Double", 0);
		this.counts.put("Triple", 0);
		this.counts.put("Home Run", 0);
	}
	
	@Test
	public void testRangeSetUp() throws Exception {
		int tests = (int)(563 * testFactor);
		String rangeValue = "";

		for(int x=0;x<tests;x++) {
			rangeValue = (String)this.mainRangeGroup.getRangeValue();
			counts.put(rangeValue, counts.get(rangeValue) + 1);
			if(!rangeValue.equals("Out")) {
				counts.put("Hits", counts.get("Hits") + 1);
			}
		}

		this.printHitCounts(tests);
		this.validateTotals();
	}

	private void validateTotals() {
		//assertEquals(376, Math.round(this.counts.get("Out").doubleValue() / testFactor));
		assertEquals(187, Math.round(this.counts.get("Hits").doubleValue() / testFactor));
		assertEquals(110, Math.round(this.counts.get("Single").doubleValue() / testFactor));
		assertEquals(38, Math.round(this.counts.get("Double").doubleValue() / testFactor));
		assertEquals(6, Math.round(this.counts.get("Triple").doubleValue() / testFactor));
		assertEquals(33, Math.round(this.counts.get("Home Run").doubleValue() / testFactor));
	}

	private void printHitCounts(int tests) {
		System.out.println("Hits = " + counts.get("Hits"));
		System.out.println("Batting Average = " + ((double)counts.get("Hits")/tests));
		System.out.println("Percent successful = " + (((double)counts.get("Hits") / tests) * 100) + "%");
		System.out.println("====================");
		System.out.println("Hit Types:");
		for(Map.Entry<String, Integer> entry : counts.entrySet()) {
			//System.out.println("  " + entry.getKey() + ": " + ((double)entry.getValue() / counts.get("Hits")) * 100 + "%");
			System.out.println("  " + entry.getKey() + ": " + ((double)entry.getValue() / testFactor));
		}
	}
	
}
