import org.fazio.simsports.baseball.builders.BatterAttributesByPABuilder;
import org.fazio.simsports.baseball.types.attributes.BatterAttributesByPA;
import org.fazio.simsports.baseball.types.BatterPlateAppearanceRangeGroup;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/13/12 1:27 PM
 */
public class TestPARangeGroup {

	private BatterAttributesByPA attrs
		= new BatterAttributesByPABuilder()
			.setStrikeoutChance(14.8)
			.setWalkChance(9.2)
			.setStrikeoutLookingChance(15)
			.setHitByPitchChance(0.8)
			.setContactFlyBallChance(35.1)
			.setContactGroundBallChance(42.8)
			.setContactLineDriveChance(22.1)
			.setFlyBallSingleChance(3.64)
			.setFlyBallDoubleChance(7.88)
			.setFlyBallTripleChance(0)
			.setFlyBallHomeRunChance(16.97)
			.setGroundBallSingleChance(26.37)
			.setGroundBallDoubleChance(1.49)
			.setGroundBallTripleChance(0)
			.setGroundBallHomeRunChance(0)
			.setLineDriveSingleChance(49.04)
			.setLineDriveDoubleChance(21.15)
			.setLineDriveTripleChance(5.77)
			.setLineDriveHomeRunChance(4.81)
			.build();

	BatterPlateAppearanceRangeGroup plateAppearanceRangeGroup
		= new BatterPlateAppearanceRangeGroup(this.attrs);

	private Map<String, Integer> results;

	private static final double testFactor = 100000.0;

	@Before
	public void setUp() throws Exception {

		this.results = new HashMap<String, Integer>();
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
