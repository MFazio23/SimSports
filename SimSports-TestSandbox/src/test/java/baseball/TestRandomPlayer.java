package baseball;

import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.RandomDataImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/15/12 3:53 PM
 */
public class TestRandomPlayer {

	private final double tests = 100000;

	@Test
	public void testRandomNumber() throws Exception {
		RandomData random = new RandomDataImpl();
		Map<Integer, Long> values = new TreeMap<Integer, Long>();
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		double total = 0;

		for(int x=0;x<this.tests;x++) {
			double value = random.nextGaussian(4.89, .9);
			total += value;
			if(value > max) max = value;
			if(value < min) min = value;

			int intVal = (int)value;
			if(!values.containsKey(intVal)) values.put(intVal, 0L);
			values.put(intVal, values.get(intVal) + 1L);
		}

		System.out.println("Average Value = " + total / this.tests);
		System.out.println("Min Value = " + min);
		System.out.println("Max Value = " + max);

		for(Map.Entry<Integer, Long> val : values.entrySet()) {
			System.out.println(val.getKey() + " = " + val.getValue());
		}
	}

}
