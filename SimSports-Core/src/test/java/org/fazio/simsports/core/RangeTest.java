package org.fazio.simsports.core;

import org.fazio.utils.range.RangeGroup;
import org.fazio.utils.range.RangeValue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/8/12 9:13 AM
 */
public class RangeTest {

	private RangeGroup testRangeGroupA;
	private RangeGroup testRangeGroupB;
	private RangeGroup testRangeGroupC;

	private RangeValue testRangeValueA;
	private RangeValue testRangeValueB;
	private RangeValue testRangeValueC;
	private RangeValue testRangeValueD;
	private RangeValue testRangeValueE;
	private RangeValue testRangeValueF;
	private RangeValue testRangeValueG;
	private RangeValue testRangeValueH;
	private RangeValue testRangeValueI;
	@Before
	public void setUp() throws Exception {
		this.testRangeGroupA = new RangeGroup(35);
		this.testRangeGroupB = new RangeGroup();
		this.testRangeGroupC = new RangeGroup();


		this.testRangeValueA = new RangeValue(10, "Test Value A");
		this.testRangeValueB = new RangeValue(15, "Test Value B");
		this.testRangeValueC = new RangeValue(7, "Test Value C");
		this.testRangeValueD = new RangeValue(8, "Test Value D");
		this.testRangeValueE = new RangeValue(14,"Test Value E");
		this.testRangeValueF = new RangeValue(12, "Test Value F");
		this.testRangeValueG = new RangeValue(22, "Test Value G");
		this.testRangeValueH = new RangeValue(11, "Test Value H");
		this.testRangeValueI = new RangeValue(16, "Test Value I");

		this.testRangeGroupA
			.addToRangeGroup(testRangeValueA)
			.addToRangeGroup(testRangeValueB)
			.addToRangeGroup(testRangeValueC)
			.addToRangeGroup(testRangeValueD)
			.setDefaultRange(testRangeValueE);

		this.testRangeGroupB
			.addToRangeGroup(testRangeValueF)
			.addToRangeGroup(testRangeValueG)
			.addToRangeGroup(testRangeGroupA)
			.setDefaultRange(testRangeValueI);
	}

	@Test
	public void testRangeToString() throws Exception {
		System.out.println(this.testRangeGroupB);
	}

}
