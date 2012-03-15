package org.fazio.simsports.baseball.types;

import org.fazio.simsports.core.types.Attributes;
import org.fazio.simsports.core.types.Position;
import org.fazio.simsports.core.types.Ratings;
import org.fazio.simsports.core.types.Statistics;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.mock;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/15/12 10:04 AM
 */
public class DiamondTest {
	
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
	public void testDiamondMovingRunners() throws Exception {
		PlateAppearanceResult result = new PlateAppearanceResult(2);
		BaseballPlayer batter
			= new BaseballPlayer(mock(Attributes.class), "First", "Batter", "Firsty", mock(Position.class), mock(Ratings.class), mock(Statistics.class));
		
		int runs = this.diamond.moveRunners(batter, result);
		assertEquals("The batter is not at second base.", batter, this.diamond.getSecondBase());
		assertEquals("The runs scored value is incorrect.", 0, runs);
		
		result = new PlateAppearanceResult(1);
		BaseballPlayer batter2
			= new BaseballPlayer(mock(Attributes.class), "Second", "Batter", "Banana", mock(Position.class), mock(Ratings.class), mock(Statistics.class));
		
		runs = this.diamond.moveRunners(batter2, result);
		assertEquals("The batter is not at first base.", batter2, this.diamond.getFirstBase());
		assertEquals("The batter is not at third base.", batter, this.diamond.getThirdBase());
		assertEquals("The runs scored value is incorrect.", 0, runs);
		
		result = new PlateAppearanceResult(3);
		BaseballPlayer batter3
			= new BaseballPlayer(mock(Attributes.class), "Third", "Batter", "Tripp", mock(Position.class), mock(Ratings.class), mock(Statistics.class));
		
		runs = this.diamond.moveRunners(batter3, result);
		assertEquals("The batter is not at third base.", batter3, this.diamond.getThirdBase());
		assertNull("There is a runner on first base", this.diamond.getFirstBase());
		assertNull("There is a runner on second base", this.diamond.getSecondBase());
		assertEquals("The runs scored value is incorrect.", 2, runs);
	}
		
}
