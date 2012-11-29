package org.fazio.simsports.core.util;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * @author Michael Fazio
 */
public class JSONLoaderTest {

	private final String testJSONFile = "json/RyneSandberg1990.json";
	private final String testOtherFile = "player-types.txt";
	private final String emptyJSON = "{}";

	private JSONLoader loader;

	@Before
	public void setUp() throws Exception {
		this.loader = new JSONLoader();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testLoadJSONObjectFromFile() throws Exception {
		final JSONObject json = this.loader.loadJSONObjectFromFile(this.testJSONFile);
		assertNotNull(json);

		final JSONObject playerInfo = json.getJSONObject("playerInfo");
		assertEquals("Ryne Sandberg", playerInfo.getString("name"));
		assertEquals(1990, playerInfo.getInt("year"));
	}

	@Test
	public void testLoadJSONObjectFromMissingFile() throws Exception {
		final JSONObject json = this.loader.loadJSONObjectFromFile("nothere/thisfiledoesntexist.txt");
		assertEquals(this.emptyJSON, json.toString());
	}

	@Test
	public void testLoadJSONObjectFromWrongFile() throws Exception {
		final JSONObject json = this.loader.loadJSONObjectFromFile(this.testOtherFile);
		assertEquals(this.emptyJSON, json.toString());
	}
}
