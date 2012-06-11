package org.fazio.simsports.baseball.types;

import org.fazio.simsports.baseball.builders.BatterAttributesByPABuilder;
import org.fazio.simsports.baseball.types.attributes.BatterAttributes;
import org.fazio.simsports.core.types.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/8/12 2:37 PM
 */
public class BaseballPlayerTest {

	private BaseballPlayer testPlayer;
	private final int testCount = 629;
	private final double testFactor = 10000;
	private Map<Results, Integer> results;


	@Before
	public void setUp() throws Exception {
		this.testPlayer = this.setUpTestPlayer();

		this.results = new HashMap<Results, Integer>();
	}

	@Test
	public void testPlateAppearance() throws Exception {

		final int testsToRun = (int)(this.testCount * this.testFactor);

		final int onePercent = testsToRun/100;

		for(int x=0; x<(this.testCount * testFactor); x++) {
			if(x%onePercent == 0) System.out.println(x/onePercent + "% completed.");
			runPlateAppearance();
		}

		for(Map.Entry<Results, Integer> entry : this.results.entrySet()) {
			System.out.println(((Results)entry.getKey()).getText() + " = " + Math.round((double) entry.getValue() / testFactor));
		}

		final Results[] hitTypes = {Results.Single, Results.Double, Results.Triple, Results.HomeRun};
		final Results[] outTypes = {Results.Out, Results.StrikeoutLooking, Results.StrikeoutSwinging};

		double hits = 0;
		for(Results hitType : hitTypes) {
			hits += (double)this.results.get(hitType);
		}

		double outs = 0;
		for(Results outType : outTypes) {
			outs += (double)this.results.get(outType);
		}

		System.out.println("Hits = " + hits);
		System.out.println("Outs = " + outs);
		System.out.println("Batting Average = " + ((hits) / ((hits + outs))));

	}

	private void runPlateAppearance() {

		final PlateAppearanceResult playResult = (PlateAppearanceResult) this.testPlayer.getPlayResult();
		final Results result = playResult.getSingleResult();

		if(!this.results.containsKey(result)) {
			this.results.put(result, 0);
		}

		results.put(result, results.get(result) + 1);
	}

	private BaseballPlayer setUpTestPlayer() {

		final Attributes attributes	= new BatterAttributes(
			this.setUpTestBattingAttributes(),
			Mockito.mock(Attributes.class),
			Mockito.mock(Attributes.class)
		);

		return new BaseballPlayer(
			attributes,
			"Test",
			"Player",
			"Juni-T",
			Mockito.mock(Position.class),
			Mockito.mock(Ratings.class),
			Mockito.mock(Statistics.class)
		);
	}

	private Attributes setUpTestBattingAttributes() {

		return new BatterAttributesByPABuilder()
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

	}

}
