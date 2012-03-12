import org.fazio.simsports.baseball.builders.BatterAttributesByPABuilder;
import org.fazio.simsports.baseball.types.BatterAttributesByPA;
import org.fazio.simsports.core.ranges.RangeGroup;
import org.fazio.simsports.core.ranges.RangeValue;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Fazio
 */
public class TestPlateAppearance {

	private BatterAttributesByPA attrs
		= new BatterAttributesByPABuilder()
			.setStrikeoutChance(14.8)
			.setWalkChance(9.2)
			.setStrikeoutLookingChance(15)
			.setHitByPitchChance(0.8)
			.setContactFlyBallChance(35.1)
			.setContactGroundBallChance(42.8)
			.setContactLineDriveChance(22.1)
			.build();

	RangeGroup plateAppearanceRangeGroup = new RangeGroup();
	RangeGroup contactRangeGroup = new RangeGroup();
	
	private Map<String, Integer> results;

	private static final double testFactor = 100000.0;
	
	@Before
	public void setUp() throws Exception {

		this.results = new HashMap<String, Integer>();
		
		this.contactRangeGroup
			.addToRangeGroup(new RangeValue(attrs.getContactFlyBallChance(), "Fly Ball"))
			.addToRangeGroup(new RangeValue(attrs.getContactGroundBallChance(), "Ground Ball"))
			.setDefaultRange(new RangeValue("Line Drive"));
		
		this.plateAppearanceRangeGroup
			.addToRangeGroup(new RangeValue(attrs.getWalkChance(), "Walk"))
			.addToRangeGroup(new RangeValue(attrs.getHitByPitchChance(), "HBP"))
			.addToRangeGroup(new RangeGroup(attrs.getStrikeoutChance())
				.addToRangeGroup(new RangeValue(attrs.getStrikeoutLookingChance(), "Strikeout Looking"))
				.setDefaultRange(new RangeValue("Strikeout Swinging")))
			.setDefaultRange(this.contactRangeGroup);
	}

	@Test
	public void testPlateAppearance() throws Exception {
		
		int tests = 629;
		
		for(int x=0; x<(tests * testFactor); x++) {
			runPlateAppearance();
		}
		
		for(Map.Entry<String, Integer> entry : this.results.entrySet()) {
			System.out.println(entry.getKey() + " = " + Math.round((double) entry.getValue() / testFactor));
		}
		
	}

	private void runPlateAppearance() {

		String playResult = (String) this.plateAppearanceRangeGroup.getRangeValue();

		if(!this.results.containsKey(playResult)) {
			this.results.put(playResult, 0);
		}

		results.put(playResult, results.get(playResult) + 1);
	}
}
