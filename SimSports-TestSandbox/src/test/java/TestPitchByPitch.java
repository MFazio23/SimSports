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
			.setPitchSwing(44.6)
			.setNoSwingStrike(62.02)
			.setNoSwingHBP(0.2)
			.setSwingContact(81)
			.setContactFoul(47)
			.setInPlayHit(35)
			.setHitDouble(20.32)
			.setHitTriple(3.21)
			.setHitHomeRun(17.65)
			.setFlyBallRate(37.4)
			.setGroundBallRate(41.7)
			.build();

	Map<String, Integer> counts;
	RangeGroup pitchRangeGroup;
	RangeGroup swingRangeGroup;
	RangeGroup contactRangeGroup;
	RangeGroup hitRangeGroup;

	private static final double testFactor = 10000.0;

	@Before
	public void setUp() throws Exception {
		this.counts = new LinkedHashMap<String, Integer>();
		
		this.pitchRangeGroup = new RangeGroup()
			.setDefaultRange(
				new RangeGroup()
					.setDefaultRange(new RangeValue("Ball"))
					.addToRangeGroup(new RangeValue(this.attrs.getNoSwingStrike(), "Strike"))
					.addToRangeGroup(new RangeValue(this.attrs.getNoSwingHBP(), "HBP")))
			.addToRangeGroup(new RangeValue(this.attrs.getPitchSwing(), "Swing"));
		
		this.hitRangeGroup = new RangeGroup();
		this.hitRangeGroup
			.setDefaultRange(new RangeValue("Single"))
			.addToRangeGroup(new RangeValue(this.attrs.getHitDouble(), "Double"))
			.addToRangeGroup(new RangeValue(this.attrs.getHitTriple(), "Triple"))
			.addToRangeGroup(new RangeValue(this.attrs.getHitHomeRun(), "Home Run"));
	}

	@Test
	public void testPitchResult() throws Exception {
		this.runTests(2488, this.pitchRangeGroup);
		this.validatePitchTotals();
	}
	
	@Test
	public void testHitResult() throws Exception {
		this.runTests(187, this.hitRangeGroup);
		this.validateHitTotals();
	}
	
	private void runTests(final int testCount, final RangeGroup group) {
		int tests = (int)(testCount * testFactor);
		String rangeValue = "";

		for(int x=0;x<tests;x++) {
			rangeValue = (String)group.getRangeValue();

			if(!this.counts.containsKey(rangeValue)) {
				this.counts.put(rangeValue, 0);
			}

			this.counts.put(rangeValue, this.counts.get(rangeValue) + 1);
		}

		this.printCounts(tests);
	}

	private void validatePitchTotals() {
		assertEquals(44.6, Math.round(this.counts.get("Swing") / (testFactor / 10.0)) / 10.0);
		assertEquals(62.0, Math.round(this.counts.get("Strike") / (testFactor / 10.0)) / 10.0);
		assertEquals(37.8, Math.round(this.counts.get("Ball") / (testFactor / 10.0)) / 10.0);
		assertEquals(0.2, Math.round(this.counts.get("HBP") / (testFactor / 10.0)) / 10.0);
	}
	
	private void validateHitTotals() {
		assertEquals(110, Math.round(this.counts.get("Single").doubleValue() / testFactor));
		assertEquals(38, Math.round(this.counts.get("Double").doubleValue() / testFactor));
		assertEquals(6, Math.round(this.counts.get("Triple").doubleValue() / testFactor));
		assertEquals(33, Math.round(this.counts.get("Home Run").doubleValue() / testFactor));
	}

	private void printCounts(int tests) {
		/*System.out.println("Balls = " + counts.get("Ball"));
		System.out.println("Strikes = " + counts.get("Strike"));
		System.out.println("Hits = " + counts.get("Hit"));
		System.out.println("Batting Average = " + ((double)counts.get("Hit")/tests));
		System.out.println("Percent successful = " + (((double)counts.get("Hit") / tests) * 100) + "%");
		System.out.println("====================");
		System.out.println("Hit Types:");*/
		
		for(Map.Entry<String, Integer> entry : counts.entrySet()) {
			//System.out.println("  " + entry.getKey() + ": " + ((double)entry.getValue() / counts.get("Hits")) * 100 + "%");
			System.out.println("  " + entry.getKey() + ": " + Math.round((double) entry.getValue() / testFactor));
		}
	}
	
}
