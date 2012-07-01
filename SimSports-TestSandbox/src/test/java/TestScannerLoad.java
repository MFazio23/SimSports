import org.json.JSONObject;
import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;

import static junit.framework.Assert.assertNotNull;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 6/25/12 4:55 PM
 */
public class TestScannerLoad {

	@Test
	public void testScanner() throws Exception {
		final InputStream stream = this.getClass().getClassLoader().getResourceAsStream("testplayers/AdamDunn2011.json");

		assertNotNull(stream);

		final StringBuilder sb = new StringBuilder();
		Scanner scan = new Scanner(stream);
		while(scan.hasNext()) {
			sb.append(scan.next());
		}

		JSONObject json = new JSONObject(sb.toString());

		assertNotNull(json);
		System.out.println(json.toString());
	}

}
