package org.fazio.simsports.baseball.builders.test;

import org.fazio.simsports.core.types.Player;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/13/12 3:03 PM
 */
public class TestPlayerFromJSONTesting {

	@Test
	public void testCreatePlayer() throws Exception {
		final Player player = new TestPlayerFromJSON().createPlayer("Ryan Braun", 2011);

		assertNotNull(player);
	}

}
