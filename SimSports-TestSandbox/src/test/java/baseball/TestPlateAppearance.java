package baseball;

import org.fazio.simsports.baseball.builders.BattingAttributesByPABuilder;
import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPA;
import org.fazio.utils.range.RangeGroup;
import org.fazio.utils.range.RangeValue;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Fazio
 */
public class TestPlateAppearance {

	private BattingAttributesByPA attrs
		= new BattingAttributesByPABuilder()
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

	RangeGroup plateAppearanceRangeGroup = new RangeGroup();
	RangeGroup contactRangeGroup = new RangeGroup();
	RangeGroup flyBallRangeGroup = new RangeGroup(attrs.getContactFlyBallChance());
	RangeGroup groundBallRangeGroup = new RangeGroup(attrs.getContactGroundBallChance());
	RangeGroup lineDriveRangeGroup = new RangeGroup(attrs.getContactLineDriveChance());

	private Map<String, Integer> results;

	private static final double testFactor = 300000.0;
	
	@Before
	public void setUp() throws Exception {

		this.results = new HashMap<String, Integer>();

		this.flyBallRangeGroup
			.addToRangeGroup(new RangeValue(attrs.getFlyBallSingleChance(), "Fly Ball Single"))
			.addToRangeGroup(new RangeValue(attrs.getFlyBallDoubleChance(), "Fly Ball Double"))
			.addToRangeGroup(new RangeValue(attrs.getFlyBallTripleChance(), "Fly Ball Triple"))
			.addToRangeGroup(new RangeValue(attrs.getFlyBallHomeRunChance(), "Fly Ball Home Run"))
			.setDefaultRange(new RangeValue("Fly Ball Out"));

		this.groundBallRangeGroup
			.addToRangeGroup(new RangeValue(attrs.getGroundBallSingleChance(), "Ground Ball Single"))
			.addToRangeGroup(new RangeValue(attrs.getGroundBallDoubleChance(), "Ground Ball Double"))
			.addToRangeGroup(new RangeValue(attrs.getGroundBallTripleChance(), "Ground Ball Triple"))
			.addToRangeGroup(new RangeValue(attrs.getGroundBallHomeRunChance(), "Ground Ball Home Run"))
			.setDefaultRange(new RangeValue("Ground Ball Out"));

		this.lineDriveRangeGroup
			.addToRangeGroup(new RangeValue(attrs.getLineDriveSingleChance(), "Line Drive Single"))
			.addToRangeGroup(new RangeValue(attrs.getLineDriveDoubleChance(), "Line Drive Double"))
			.addToRangeGroup(new RangeValue(attrs.getLineDriveTripleChance(), "Line Drive Triple"))
			.addToRangeGroup(new RangeValue(attrs.getLineDriveHomeRunChance(), "Line Drive Home Run"))
			.setDefaultRange(new RangeValue("Line Drive Out"));

		this.contactRangeGroup
			.addToRangeGroup(this.flyBallRangeGroup)
			.addToRangeGroup(this.groundBallRangeGroup)
			.setDefaultRange(this.lineDriveRangeGroup);
		
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
