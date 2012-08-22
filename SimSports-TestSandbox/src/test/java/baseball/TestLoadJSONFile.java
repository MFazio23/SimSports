package baseball;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

/**
 * @author Michael Fazio
 */
public class TestLoadJSONFile {

	@Test
	public void testLoadJSON() throws Exception {
		final InputStream stream = this.getClass().getResourceAsStream("/testplayers/AdamDunn2011.json");
		final String jsonString = IOUtils.toString(stream);

		System.out.println(jsonString);
	}
}
