package org.fazio.simsports.baseball.types;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/15/12 10:04 AM
 */
public class TestDiamond {
	
	Diamond diamond;
	
	@Before
	public void setUp() throws Exception {
		this.diamond = new Diamond();
	}
	
	@Test
	public void testDiamondInitialization() throws Exception {
		assertNull(this.diamond.getFirstBase());
		assertNull(this.diamond.getSecondBase());
		assertNull(this.diamond.getThirdBase());
		assertNull(this.diamond.getUpToBat());
	}

	@Test
	public void testDiamondWithHits() throws Exception {
		fail();
	}
		
}
