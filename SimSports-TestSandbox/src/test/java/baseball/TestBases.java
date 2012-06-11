package baseball;

import org.fazio.simsports.baseball.types.Bases;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * @author Michael Fazio
 */
public class TestBases {

	Bases bases;

	@Before
	public void setUp() throws Exception {
		this.bases = new Bases();
	}

	@Test
	public void testBases() throws Exception {
		checkBases(false, false, false);
	}

	private void checkBases(final boolean first, final boolean second, final boolean third) {
		if(first) {
			assertNotNull(this.bases.getFirstBase());
		}
		if(second) {
			assertNotNull(this.bases.getSecondBase());
		}
		if(third) {
			assertNotNull(this.bases.getThirdBase());
		}
	}
}
