package baseball;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/24/12 10:30 PM
 */
public class TestMapping {

	@Test
	public void testMapping() throws Exception {
		InputStream stream = this.getClass().getResourceAsStream("/jsonmaptest.json");
		JsonNode node = new ObjectMapper().readValue(stream, JsonNode.class);

		System.out.println(node);
	}
}
