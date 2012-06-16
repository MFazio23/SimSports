package baseball;

import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.RandomDataImpl;
import org.junit.Test;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/15/12 3:53 PM
 */
public class TestRandomPlayer {

	private final double tests = 100000;

	@Test
	public void testRandomNumber() throws Exception {
		RandomData random = new RandomDataImpl();
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		double total = 0;

		for(int x=0;x<this.tests;x++) {
			double value = random.nextGaussian(18.6, 3.0);
			total += value;
			if(value > max) max = value;
			if(value < min) min = value;
		}

		System.out.println("Average Value = " + total / this.tests);
		System.out.println("Min Value = " + min);
		System.out.println("Max Value = " + max);
	}

}
