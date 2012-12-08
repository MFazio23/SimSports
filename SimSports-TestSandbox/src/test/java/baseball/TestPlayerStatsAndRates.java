package baseball;

import org.fazio.simsports.baseball.builders.test.TestPlayerFromJSON;
import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.fazio.simsports.baseball.types.attributes.BatterAttributes;
import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPA;
import org.fazio.utils.pair.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/13/12 7:24 PM
 */
public class TestPlayerStatsAndRates {

	private final String headerLine = "Name,K%,KL%,BB%,HBP%,FB%,GB%,LD%,FBS,FBD,FBT,FBHR,GBS,GBD,GBT,GBHR,LDS,LDD,LDT,LDHR";

	@Test
	public void testStatsAndRates() throws Exception {
		final List<Pair<String, Integer>> players = new ArrayList<Pair<String, Integer>>() {
			{
				add(new Pair<String, Integer>("Adam Dunn", 2011));
				add(new Pair<String, Integer>("Albert Pujols", 2003));
				add(new Pair<String, Integer>("Albert Pujols", 2008));
				add(new Pair<String, Integer>("Alex Rodriguez", 2000));
				add(new Pair<String, Integer>("Alex Rodriguez", 2007));
				add(new Pair<String, Integer>("Barry Bonds", 2001));
				add(new Pair<String, Integer>("Barry Bonds", 2004));
				add(new Pair<String, Integer>("Cal Ripken", 1991));
				add(new Pair<String, Integer>("Carl Crawford", 2004));
				add(new Pair<String, Integer>("Carlos Delgado", 2000));
				add(new Pair<String, Integer>("Casey McGehee", 2011));
				add(new Pair<String, Integer>("Craig Biggio", 1997));
				add(new Pair<String, Integer>("Craig Biggio", 1999));
				add(new Pair<String, Integer>("Curtis Granderson", 2007));
				add(new Pair<String, Integer>("Jody Gerut", 2010));
				add(new Pair<String, Integer>("League Totals", 2011));
				add(new Pair<String, Integer>("Mark McGwire", 1998));
				add(new Pair<String, Integer>("Mark Reynolds", 2009));
				add(new Pair<String, Integer>("Prince Fielder", 2011));
				add(new Pair<String, Integer>("Rickie Weeks", 2011));
				add(new Pair<String, Integer>("Ryan Braun", 2011));
				add(new Pair<String, Integer>("Todd Helton", 2000));
			}
		};

		System.out.println(this.headerLine);

		for(Pair<String, Integer> playerYear : players) {
			final int year = playerYear.getRight();
			final BaseballPlayer testPlayer = new TestPlayerFromJSON().createPlayer(playerYear.getLeft(), year);

			final String ratesLine
				= new StringBuilder()
					.append(testPlayer.getFirstName())
					.append(" ")
					.append(testPlayer.getLastName())
					.append(" (")
					.append(year)
					.append("),")
					.append(this.getPlayerRates(testPlayer)).toString();

			System.out.println(ratesLine);
		}
	}

	private String getPlayerRates(final BaseballPlayer testPlayer) {
		String rates = "";

		final BatterAttributes batterAttributes = (BatterAttributes) testPlayer.getAttributes();
		final BattingAttributesByPA battingAttributes = (BattingAttributesByPA) batterAttributes.getBattingAttributes();

		rates = this.getRatesString(battingAttributes);

		return rates;
	}

	private String getRatesString(final BattingAttributesByPA battingAttributes) {
		return new StringBuilder()
			.append(battingAttributes.getStrikeoutChance())
			.append(",")
			.append(battingAttributes.getStrikeoutLookingChance())
			.append(",")
			.append(battingAttributes.getWalkChance())
			.append(",")
			.append(battingAttributes.getHitByPitchChance())
			.append(",")
			.append(battingAttributes.getContactFlyBallChance())
			.append(",")
			.append(battingAttributes.getContactGroundBallChance())
			.append(",")
			.append(battingAttributes.getContactLineDriveChance())
			.append(",")
			.append(battingAttributes.getFlyBallSingleChance())
			.append(",")
			.append(battingAttributes.getFlyBallDoubleChance())
			.append(",")
			.append(battingAttributes.getFlyBallTripleChance())
			.append(",")
			.append(battingAttributes.getFlyBallHomeRunChance())
			.append(",")
			.append(battingAttributes.getGroundBallSingleChance())
			.append(",")
			.append(battingAttributes.getGroundBallDoubleChance())
			.append(",")
			.append(battingAttributes.getGroundBallTripleChance())
			.append(",")
			.append(battingAttributes.getGroundBallHomeRunChance())
			.append(",")
			.append(battingAttributes.getLineDriveSingleChance())
			.append(",")
			.append(battingAttributes.getLineDriveDoubleChance())
			.append(",")
			.append(battingAttributes.getLineDriveTripleChance())
			.append(",")
			.append(battingAttributes.getLineDriveHomeRunChance())
			.toString();
	}

}
