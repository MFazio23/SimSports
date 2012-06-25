package baseball;

import org.apache.commons.math.distribution.ExponentialDistributionImpl;
import org.fazio.simsports.baseball.builders.test.TestPlayerFromJSON;
import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.fazio.simsports.baseball.types.attributes.BatterAttributes;
import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPA;
import org.fazio.simsports.core.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/18/12 3:24 PM
 */
public class TestRatings {

	private List<BaseballPlayer> playerList = new ArrayList<BaseballPlayer>();

	@Before
	public void setUp() throws Exception {
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
				add(new Pair<String, Integer>("Brett Gardner", 2011));
				add(new Pair<String, Integer>("Jason Kendall", 2005));
				add(new Pair<String, Integer>("Jason Kendall", 2008));
				add(new Pair<String, Integer>("Austin Jackson", 2010));
				add(new Pair<String, Integer>("All FBHRs", 2012));
				add(new Pair<String, Integer>("All LDHRs", 2012));
			}
		};

		for(Pair<String, Integer> playerData : players) {
			this.playerList.add(new TestPlayerFromJSON().createPlayer(playerData.getLeft(), playerData.getRight()));
		}
	}

	@Test
	public void testRatings() throws Exception {
		System.out.println("Player Name: Power/Eye/Contact");
		for(BaseballPlayer player : this.playerList) {
			final int eyeRating = calculateEyeRating(player);
			final int contactRating = calculateContactRating(player);
			final int powerRating = calculateHomeRunRating(player);
			if(eyeRating != 0 && powerRating != 0) System.out.println(player.getFullName() + ": " + powerRating + "/" + eyeRating + "/" + contactRating);
		}
	}

	private int calculateHomeRunRating(final BaseballPlayer player) throws Exception {
		final BatterAttributes batterAttributes = (BatterAttributes)player.getAttributes();
		final BattingAttributesByPA battingAttributesByPA = (BattingAttributesByPA) batterAttributes.getBattingAttributes();

		final double fb = (battingAttributesByPA.getContactFlyBallChance()/100);
		final double ld = (battingAttributesByPA.getContactLineDriveChance()/100);
		final int ldHR = (int)(battingAttributesByPA.getLineDriveHomeRunChance() * 1000);
		final int fbHR = (int)(battingAttributesByPA.getFlyBallHomeRunChance() * 1000);
		final int ldDBL = (int)(battingAttributesByPA.getLineDriveDoubleChance() * 1000);
		final int fbDBL = (int)(battingAttributesByPA.getFlyBallDoubleChance() * 1000);
		final int ldTRPL = (int)(battingAttributesByPA.getLineDriveTripleChance() * 1000);
		final int fbTRPL = (int)(battingAttributesByPA.getFlyBallTripleChance() * 1000);

		final int xbh = (int)((ldDBL + ldTRPL) * ld + (fbDBL + fbTRPL) * fb)/4;
		final int hr = (int)((ld * ldHR) + (fb * fbHR));//(int)(2 * (hr + (xbh * .18)));

		final int basicRating = (int)(xbh * .2 + hr * .8);

		final int rating = (int)(Math.ceil((new ExponentialDistributionImpl(3825).cumulativeProbability(basicRating) + .01) * 100));//fullRating / 500;

		final int fullRating = (int)Math.round(rating * .6) + 40;

		return fullRating == 0 ? 0 : fullRating;
	}

	private int calculateContactRating(final BaseballPlayer player) throws Exception {
		final BatterAttributes batterAttributes = (BatterAttributes)player.getAttributes();
		final BattingAttributesByPA ba = (BattingAttributesByPA) batterAttributes.getBattingAttributes();
		final double fact = 2.8;

		final double nonWalkRate = (100 - (ba.getWalkChance() + ba.getHitByPitchChance()))/100.0;
		final double contactRate = (100 - (ba.getStrikeoutChance()/nonWalkRate));

		final double gbHit = ((ba.getContactGroundBallChance()/100) * (ba.getGroundBallSingleChance() + ba.getGroundBallDoubleChance() + ba.getGroundBallTripleChance())) / 100;
		final double ldHit = ((ba.getContactLineDriveChance()/100) * (ba.getLineDriveSingleChance() + ba.getLineDriveDoubleChance() + ba.getLineDriveTripleChance() + ba.getLineDriveHomeRunChance())) / 100;
		final double fbHit = ((ba.getContactFlyBallChance()/100) * (ba.getFlyBallSingleChance() + ba.getFlyBallDoubleChance() + ba.getFlyBallTripleChance() + ba.getFlyBallHomeRunChance())) / 100;

		final double hitRate = (gbHit + ldHit + fbHit)/100;
		final double contactHitRate = hitRate * contactRate * 1000;

		//final int rating = (int)Math.round(new ExponentialDistributionImpl(255 * fact).cumulativeProbability(contactHitRate) * 100);//fullRating / 500;

		//final int fullRating = (int)Math.round(rating * .6) + 40;

		double rating = contactHitRate;
		if(rating < 200.0) rating = 200.0;
		if(rating > 330.0) rating = 330.0;
		rating -= 200.0;
		rating /= 130;
		rating *= 60;
		rating += 40;

		return (int)rating;
	}

	private int calculateEyeRating(final BaseballPlayer player) throws Exception {
		final BatterAttributes batterAttributes = (BatterAttributes)player.getAttributes();
		final BattingAttributesByPA ba = (BattingAttributesByPA) batterAttributes.getBattingAttributes();

		final int walkKRate = (int) ((ba.getWalkChance() - ba.getStrikeoutChance()) * 1000) + 20000;

		final int rating = (int)Math.round(new ExponentialDistributionImpl(9500).cumulativeProbability(walkKRate) * 100);//fullRating / 500;

		final int fullRating = (int)Math.round(rating * .6) + 40;

		return fullRating;
	}
}
