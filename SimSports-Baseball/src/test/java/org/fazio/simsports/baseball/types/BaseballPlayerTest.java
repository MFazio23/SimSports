package org.fazio.simsports.baseball.types;

import org.fazio.simsports.baseball.builders.JSONBaseballPlayerCreator;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertTrue;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/8/12 2:37 PM
 */
public class BaseballPlayerTest {

	private BaseballPlayer testPlayer;
	private final int testCount = 650;
	private final double testFactor = 10;
	private final String testFilePath = "teams/wisconsinnovas/MichaelFazio.json";


	@Before
	public void setUp() throws Exception {
		this.testPlayer = new JSONBaseballPlayerCreator().createPlayer(this.testFilePath);
	}

	@Test
	public void testPlateAppearance() throws Exception {

		final Map<Results, Integer> results = new HashMap<Results, Integer>();

		final int testsToRun = (int)(this.testCount * this.testFactor);

		final int onePercent = testsToRun/100;

		for(int f=0;f<this.testFactor;f++) {
			final Map<Results, Integer> seasonResults = new HashMap<Results, Integer>();
			for(int x=0; x<=(this.testCount); x++) {

				if(x%onePercent == 0) System.out.println(x/onePercent + "% completed.");
				final Results result = runPlateAppearance();

				if(!seasonResults.containsKey(result)) {
					seasonResults.put(result, 0);
				}

				seasonResults.put(result, seasonResults.get(result) + 1);
			}

			System.out.println("Season #" + (f + 1));
			this.printStatLine(seasonResults);

			for(Map.Entry<Results, Integer> seasonResult : seasonResults.entrySet()) {

				if(!results.containsKey(seasonResult.getKey())) {
					results.put(seasonResult.getKey(), 0);
				}

				results.put(seasonResult.getKey(), seasonResult.getValue());

			}
		}

		this.printTestResults(results);
		//this.assertTestResults(results);

	}

	private void assertTestResults(final Map<Results, Integer> results) {
		assertTrue(
			"The number of singles is incorrect.",
			this.numberIsNear(111, this.getResultAveragePerTest(results.get(Results.Single))));
		assertTrue(
			"The number of doubles is incorrect.",
			this.numberIsNear(38, this.getResultAveragePerTest(results.get(Results.Double))));
		assertTrue(
			"The number of triples is incorrect.",
			this.numberIsNear(6, this.getResultAveragePerTest(results.get(Results.Triple))));
		assertTrue(
			"The number of home runs is incorrect.",
			this.numberIsNear(33, this.getResultAveragePerTest(results.get(Results.HomeRun))));
		assertTrue(
			"The number of walks is incorrect.",
			this.numberIsNear(58, this.getResultAveragePerTest(results.get(Results.BB))));
		assertTrue(
			"The number of strikeouts is incorrect.",
			this.numberIsNear(
				93,
				this.getResultAveragePerTest(results.get(Results.StrikeoutLooking) + results.get(Results.StrikeoutSwinging))));
		assertTrue(
			"The number of hit by pitches is incorrect.",
			this.numberIsNear(5, this.getResultAveragePerTest(results.get(Results.HBP))));
		assertTrue(
			"The number of outs is incorrect.",
			this.numberIsNear(283, this.getResultAveragePerTest(results.get(Results.Out))));
	}

	private void printTestResults(final Map<Results, Integer> results) {
		for(Map.Entry<Results, Integer> entry : results.entrySet()) {
			System.out.println(((Results)entry.getKey()).getText() + " = " + this.getResultAveragePerTest(entry.getValue()));
		}

		final Results[] hitTypes = {Results.Single, Results.Double, Results.Triple, Results.HomeRun};
		final Results[] outTypes = {Results.Out, Results.StrikeoutLooking, Results.StrikeoutSwinging};

		double hits = 0;
		for(Results hitType : hitTypes) {
			Integer hit = results.get(hitType);
			hits += hit == null ? 0 : hit.doubleValue();
		}

		double outs = 0;
		for(Results outType : outTypes) {
			Integer out = results.get(outType);
			outs += out == null ? 0 : out.doubleValue();
		}

		final Integer strikeouts = (results.get(Results.StrikeoutSwinging) + results.get(Results.StrikeoutLooking));

		final int atBats = (int)(hits + outs);
		System.out.println("At-Bats = " + atBats);
		System.out.println("Hits = " + hits);
		System.out.println("Outs = " + outs);
		System.out.println("Strikeouts = " + (int)(strikeouts/this.testFactor));
		final double battingAverage = (hits / atBats);
		final double totalBases = results.get(Results.Single) + (2*results.get(Results.Double)) + (3*results.get(Results.Triple)) + (4*results.get(Results.HomeRun));
		System.out.println("Batting Average = ." + (int)(battingAverage * 1000));
		System.out.println("On-Base Percentage = ." + (int)((hits + results.get(Results.BB) + results.get(Results.HBP))/this.testCount));
		System.out.println("Slugging Percentage = " + (double)totalBases/(double)atBats);
		System.out.println("Total Bases = " + totalBases);

	}

	private void printStatLine(final Map<Results, Integer> results) {

		final Results[] hitTypes = {Results.Single, Results.Double, Results.Triple, Results.HomeRun};
		final Results[] outTypes = {Results.Out, Results.StrikeoutLooking, Results.StrikeoutSwinging};

		double hits = 0;
		for(Results hitType : hitTypes) {
			Integer hit = results.get(hitType);
			hits += hit == null ? 0 : hit.doubleValue();
		}

		double outs = 0;
		for(Results outType : outTypes) {
			Integer out = results.get(outType);
			outs += out == null ? 0 : out.doubleValue();
		}

		final int atBats = (int)(hits + outs);
		final double battingAverage = (hits / atBats);
		final double onBasePercentage = (int)((hits + results.get(Results.BB) + results.get(Results.HBP))/this.testCount);
		final double totalBases = results.get(Results.Single) + (2*results.get(Results.Double)) + (3*results.get(Results.Triple)) + (4*results.get(Results.HomeRun));

		final String statLineString = new StringBuilder()
			.append(battingAverage)
			.append("/")
			.append(onBasePercentage)
			.append("/")
			.append(totalBases/atBats)
			.append(", ")
			.append(results.get(Results.Double))
			.append(" 2B, ")
			.append(results.get(Results.Triple))
			.append(" 3B, ")
			.append(results.get(Results.HomeRun))
			.append(" HR")
			.toString();

		System.out.println(statLineString);
	}

	private Results runPlateAppearance() {

		final PlateAppearanceResult playResult = (PlateAppearanceResult) this.testPlayer.getPlayResult();
		return playResult.getSingleResult();

	}

	private long getResultAveragePerTest(final Integer result) {
		return Math.round((double) result / this.testFactor);
	}

	private boolean numberIsNear(final long baseNumber, final long valueChecked) {
		final double rangeFactor = 0.98;
		long lowRange = (long)(baseNumber * rangeFactor);
		long highRange = (long)(baseNumber / rangeFactor);

		if(lowRange == baseNumber) lowRange = baseNumber - 1;
		if(highRange == baseNumber) highRange = baseNumber + 1;

		return valueChecked >= lowRange && valueChecked <= highRange;

	}

}
