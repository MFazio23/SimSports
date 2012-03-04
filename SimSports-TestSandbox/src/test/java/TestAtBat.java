import org.fazio.simsports.baseball.builders.BatterAttributesBuilder;
import org.fazio.simsports.baseball.types.BatterAttributes;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * @author Michael Fazio
 */
public class TestAtBat {

	private BatterAttributes attrs
		= new BatterAttributesBuilder()
			.setBatterAverage(.332)
			.setBatterDoubleRate(20.32)
			.setBatterTripleRate(3.21)
			.setBatterHomeRunRate(17.65)
			.setBatterStrikeoutPercentage(14.8)
			.setBatterWalkPercentage(9.2)
			.build();

	Map<String, Integer> counts;
	
	private static final int testFactor = 100000;

	@Before
	public void setUp() throws Exception {
		counts = new HashMap<String, Integer>();
		counts.put("Hits", 0);
		counts.put("Single", 0);
		counts.put("Double", 0);
		counts.put("Triple", 0);
		counts.put("Home Run", 0);
	}
	
	@Test
	public void testAtBat() throws Exception {

		int tests = 0;//563 * testFactor;

		for(int x=0;x<tests;x++) {
			int rand = (int)(Math.random() * 1001);
			if(rand <= (attrs.getBatterAverage() * 1000)) {
				counts.put("Hits", counts.get("Hits") + 1);
				String hitType = this.getHitTypeBasic(attrs);
				counts.put(hitType,  counts.get(hitType) + 1);
			}
		}

		this.printHitCounts(tests);
		//this.validateTotals();
	}

	@Test
	public void testAtBatRanges() throws Exception {
		int tests = 563 * testFactor;

		for(int x=0;x<tests;x++) {

		}
		
		this.printHitCounts(tests);
		this.validateTotals();
	}

	private void validateTotals() {
		assertEquals(187, (this.counts.get("Hits") / testFactor));
		assertEquals(110, (this.counts.get("Single") / testFactor));
		assertEquals(38, (this.counts.get("Double") / testFactor));
		assertEquals(6, (this.counts.get("Triple") / testFactor));
		assertEquals(33, (this.counts.get("Home Run") / testFactor));
	}

	private void printHitCounts(int tests) {
		System.out.println("Hits = " + counts.get("Hits"));
		System.out.println("Batting Average = " + ((double)counts.get("Hits")/tests));
		System.out.println("Percent successful = " + (((double)counts.get("Hits") / tests) * 100) + "%");
		System.out.println("====================");
		System.out.println("Hit Types:");
		for(Map.Entry<String, Integer> entry : counts.entrySet()) {
			//System.out.println("  " + entry.getKey() + ": " + ((double)entry.getValue() / counts.get("Hits")) * 100 + "%");
			System.out.println("  " + entry.getKey() + ": " + ((double)entry.getValue() / 100000));
		}
	}

	private String getHitTypeBasic(final BatterAttributes attrs) {
		String hitType = "Single";
		
		/*Map<String, DoubleStatRange> ranges = new HashMap<String, DoubleStatRange>();
		ranges.put("Double", new DoubleStatRange(0, attrs.getBatterDoubleRate()));
		ranges.put("Triple", new DoubleStatRange(ranges.get("Double").getEnd(), ranges.get("Double").getEnd() + attrs.getBatterTripleRate()));
		ranges.put("Home Run", new DoubleStatRange(ranges.get("Triple").getEnd(), ranges.get("Triple").getEnd() + attrs.getBatterHomeRunRate()));
		
		double rand = Math.random() * 100;
		for(Map.Entry<String, DoubleStatRange> entry : ranges.entrySet()) {
			if(entry.getValue().isInRange(rand)) {
				hitType = entry.getKey();
			}
		}*/
		
		return hitType;
	}
}
