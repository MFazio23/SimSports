package org.fazio.simsports.core;

import org.fazio.simsports.core.builders.PlayerBuilder;
import org.fazio.simsports.core.types.*;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/7/12 10:36 PM
 */
public class PlayerBuilderTest {
	
	private final String testFirstName = "Michael";
	private final String testLastName = "Fazio";
	private final String testNickname = "Faz";
	
	@Test
	public void testProperPlayerBuilder() throws Exception {
		Player testPlayer = new PlayerBuilder()
			.setFirstName(this.testFirstName)
			.setLastName(this.testLastName)
			.setNickname(this.testNickname)
			.setPosition(mock(Position.class))
			.setAttributes(mock(Attributes.class))
			.setRatings(mock(Ratings.class))
			.setStatistics(mock(Statistics.class))
			.build();

		assertEquals("The test player's first name is incorrect.", this.testFirstName, testPlayer.getFirstName());
		assertEquals("The test player's last name is incorrect.", this.testLastName, testPlayer.getLastName());
		assertEquals("The test player's nickname is incorrect.", this.testNickname, testPlayer.getNickname());
		assertNotNull("The test player's attributes are null.", testPlayer.getAttributes());
		assertNotNull("The test player's position are null.", testPlayer.getPosition());
		assertNotNull("The test player's ratings are null.", testPlayer.getRatings());
		assertNotNull("The test player's statistics are null.", testPlayer.getStatistics());
	}
}
