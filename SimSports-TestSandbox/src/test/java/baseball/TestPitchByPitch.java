package baseball;

import org.fazio.simsports.baseball.builders.BattingAttributesByPitchBuilder;
import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPitch;
import org.fazio.utils.range.RangeGroup;
import org.fazio.utils.range.RangeValue;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * @author Michael Fazio
 */
public class TestPitchByPitch {

	private BattingAttributesByPitch attrs
		= new BattingAttributesByPitchBuilder()
			.setPitchSwing(44.6)
			.setNoSwingStrike(62.02)
			.setNoSwingHBP(0.2)
			.setSwingContact(81)
			.setContactFoul(41)
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


		this.hitRangeGroup = new RangeGroup(this.attrs.getInPlayHit())
			.setDefaultRange(new RangeValue("Single"))
			.addToRangeGroup(new RangeValue(this.attrs.getHitDouble(), "Double"))
			.addToRangeGroup(new RangeValue(this.attrs.getHitTriple(), "Triple"))
			.addToRangeGroup(new RangeValue(this.attrs.getHitHomeRun(), "Home Run"));

		this.contactRangeGroup = new RangeGroup(this.attrs.getSwingContact())
			.addToRangeGroup(new RangeValue(this.attrs.getContactFoul(), "Foul"))
			.setDefaultRange(
				new RangeGroup()
					.setDefaultRange(new RangeValue("Out"))
					.addToRangeGroup(this.hitRangeGroup)
			);

		this.swingRangeGroup = new RangeGroup(this.attrs.getPitchSwing())
			.setDefaultRange(new RangeValue("Swinging Strike"))
			.addToRangeGroup(this.contactRangeGroup);

		this.pitchRangeGroup = new RangeGroup()
			.addToRangeGroup(this.swingRangeGroup)
			.setDefaultRange(
				new RangeGroup()
					.setDefaultRange(new RangeValue("Ball"))
					.addToRangeGroup(new RangeValue(this.attrs.getNoSwingStrike(), "Strike"))
					.addToRangeGroup(new RangeValue(this.attrs.getNoSwingHBP(), "HBP"))
			);

	}

	@Test
	public void testPitchResult() throws Exception {
		this.runTests(2488, this.pitchRangeGroup);
	}

	@Test
	public void testSwingResult() throws Exception {
		this.runTests(1000, this.swingRangeGroup);
		this.validateSwingTotals();
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
		assertEquals(1110, Math.round(this.counts.get("Swing") / testFactor));
		assertEquals(855, Math.round(this.counts.get("Strike") / testFactor));
		assertEquals(520, Math.round(this.counts.get("Ball") / testFactor));
		assertEquals(3, Math.round(this.counts.get("HBP") / testFactor));
	}
	
	private void validateHitTotals() {
		assertEquals(110, Math.round(this.counts.get("Single").doubleValue() / testFactor));
		assertEquals(38, Math.round(this.counts.get("Double").doubleValue() / testFactor));
		assertEquals(6, Math.round(this.counts.get("Triple").doubleValue() / testFactor));
		assertEquals(33, Math.round(this.counts.get("Home Run").doubleValue() / testFactor));
	}
	
	private void validateSwingTotals() {
		fail();
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
