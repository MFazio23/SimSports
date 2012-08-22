package baseball;

import org.codehaus.jackson.map.ObjectMapper;
import org.fazio.simsports.baseball.builders.JSONBaseballPlayerCreator;
import org.fazio.simsports.baseball.types.BaseballPlayer;
import org.junit.Test;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/24/12 10:30 PM
 */
public class TestMapping {

	@Test
	public void testMapping() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		//SimpleModule module = new SimpleModule("MyModule", new Version(1, 0, 0, null))
		//	.addDeserializer(Attributes.class, new AttributesDeserializer());
		final BaseballPlayer player = new JSONBaseballPlayerCreator().createPlayer("teams/wisconsinknights/MichaelFazio.json");
		System.out.println(mapper.writeValueAsString(player));
	}
}
