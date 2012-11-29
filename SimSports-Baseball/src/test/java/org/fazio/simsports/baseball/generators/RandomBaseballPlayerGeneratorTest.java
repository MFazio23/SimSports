package org.fazio.simsports.baseball.generators;

import org.fazio.simsports.baseball.types.BaseballPosition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Michael Fazio
 */
public class RandomBaseballPlayerGeneratorTest extends RandomBaseballPlayerGenerator{
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testGenerateRandomPlayer() throws Exception {
		this.generateRandomPlayer();
	}

	@Test
	public void testRandomNumber() throws Exception {
		Map<Integer, Integer> numberMap = new TreeMap<Integer, Integer>();
		for(int x=0;x<1000;x++) {
			final int num = this.getRandomNumber(false);
			if(!numberMap.containsKey(num)) {
				numberMap.put(num, 0);
			}
			numberMap.put(num, numberMap.get(num) + 1);
		}

		for(Map.Entry<Integer, Integer> entry : numberMap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue() + " times");
		}
	}

	@Test
	public void testRandomPosition() throws Exception {
		final List<BaseballPosition> positionList = this.getRandomPositions();
	}
}
