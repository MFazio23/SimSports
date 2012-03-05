import org.fazio.simsports.baseball.builders.BatterAttributesBuilder;
import org.fazio.simsports.baseball.types.BatterAttributes;
import org.fazio.simsports.core.ranges.RangeGroup;
import org.fazio.simsports.core.ranges.RangeValue;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Fazio
 */
public class TestAtBat {

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


	RangeGroup mainRangeGroup;
	private Map<String, Integer> results;

	private static final double testFactor = 10000.0;
	
	@Before
	public void setUp() throws Exception {

		this.results = new HashMap<String, Integer>();
		
		RangeGroup hitRangeGroup = new RangeGroup(this.attrs.getInPlayHit())
			.setDefaultRange(new RangeValue("Single"))
			.addToRangeGroup(new RangeValue(this.attrs.getHitDouble(), "Double"))
			.addToRangeGroup(new RangeValue(this.attrs.getHitTriple(), "Triple"))
			.addToRangeGroup(new RangeValue(this.attrs.getHitHomeRun(), "Home Run"));

		RangeGroup contactRangeGroup = new RangeGroup(this.attrs.getSwingContact())
			.addToRangeGroup(new RangeValue(this.attrs.getContactFoul(), "Foul"))
			.setDefaultRange(
				new RangeGroup()
					.setDefaultRange(new RangeValue("Out"))
					.addToRangeGroup(hitRangeGroup)
			);

		RangeGroup swingRangeGroup = new RangeGroup(this.attrs.getPitchSwing())
			.setDefaultRange(new RangeValue("Strike"))
			.addToRangeGroup(contactRangeGroup);

		this.mainRangeGroup = new RangeGroup()
			.addToRangeGroup(swingRangeGroup)
			.setDefaultRange(
				new RangeGroup()
					.setDefaultRange(new RangeValue("Ball"))
					.addToRangeGroup(new RangeValue(this.attrs.getNoSwingStrike(), "Strike"))
					.addToRangeGroup(new RangeValue(this.attrs.getNoSwingHBP(), "HBP"))
			);
	}

	@Test
	public void testAtBats() throws Exception {
		
		int tests = 629;
		
		//for(int x=0; x<(tests * testFactor); x++) {
			runAtBat();
		//}
		
		for(Map.Entry<String, Integer> entry : this.results.entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() / testFactor));
		}
		
	}

	private void runAtBat() {
		
		int balls = 0;
		int strikes = 0;
		String playResult = null;

		while(playResult == null) {
			String rangeValue = (String)this.mainRangeGroup.getRangeValue();
			if("Ball".equals(rangeValue)) balls++;
			else if("Strike".equals(rangeValue)) strikes++;
			else if("Foul".equals(rangeValue)) {
				if(strikes < 2) strikes++;
			} else playResult = rangeValue;

			if(balls >= 4) playResult = "Base on Balls";
			if(strikes >= 3) playResult = "Strikeout";
			System.out.println(rangeValue + "(" + playResult + ")" + ": [Balls=" + balls + "], [Strikes=" + strikes + "]");
		}

		if(!this.results.containsKey(playResult)) {
			this.results.put(playResult, 0);
		}

		results.put(playResult, results.get(playResult) + 1);
	}
}
