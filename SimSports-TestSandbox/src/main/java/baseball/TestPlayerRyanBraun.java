package baseball;

import org.fazio.simsports.baseball.builders.BatterAttributesByPABuilder;
import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.fazio.simsports.baseball.types.BaseballPosition;
import org.fazio.simsports.baseball.types.attributes.BatterAttributes;
import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Ratings;
import org.fazio.simsports.core.types.Statistics;
import org.mockito.Mockito;

/**
 * @author Michael Fazio
 */
public class TestPlayerRyanBraun extends BaseballPlayer {

	public TestPlayerRyanBraun() {
		super(
			TestPlayerRyanBraun.setUpAttributes(),
			"Ryan",
			"Braun",
			"Brauny",
			BaseballPosition.Left_Field,
			TestPlayerRyanBraun.setUpRatings(),
			TestPlayerRyanBraun.setUpStatistics());
	}

	private static Attributes setUpAttributes() {
		final Attributes battingAttributes
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

		return new BatterAttributes(battingAttributes, Mockito.mock(Attributes.class), Mockito.mock(Attributes.class));
	}

	private static Ratings setUpRatings() {
		return Mockito.mock(Ratings.class);
	}

	private static Statistics setUpStatistics() {
		return Mockito.mock(Statistics.class);
	}

}
