package org.fazio.simsports.baseball.types;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/15/12 5:10 PM
 */
public class BaseballPositionTest {
	
	private final String testPositionName = "Test Position";
	private final String testPositionShortName = "TST";
	private final boolean testIsPitcher = false;

	@Test
	public void testBaseballPositions() throws Exception {
		
		Map<BaseballPosition, String[]> validationValues = this.setUpValidationValues();
		
		for(BaseballPosition position : validationValues.keySet()) {
			String[] values = validationValues.get(position);

			assertEquals("The position name is incorrect.", values[0], position.getPositionName());
			assertEquals("The position short name is incorrect.", values[1], position.getPositionShortName());
			assertEquals("The pitcher indicator is incorrect.", Boolean.valueOf(values[2]).booleanValue(), position.isPitcher());
			
		}
	}
	
	private Map<BaseballPosition, String[]> setUpValidationValues() throws Exception {
		Map<BaseballPosition, String[]> validationValues = new HashMap<BaseballPosition, String[]>();

		validationValues.put(BaseballPosition.Catcher, new String[]{"Catcher", "C", "False"});
		validationValues.put(BaseballPosition.First_Base, new String[]{"First Base", "1B", "False"});
		validationValues.put(BaseballPosition.Second_Base, new String[]{"Second Base", "2B", "False"});
		validationValues.put(BaseballPosition.Third_Base, new String[]{"Third Base", "3B", "False"});
		validationValues.put(BaseballPosition.Shortstop, new String[]{"Shortstop", "SS", "False"});
		validationValues.put(BaseballPosition.Left_Field, new String[]{"Left Field", "LF", "False"});
		validationValues.put(BaseballPosition.Center_Field, new String[]{"Center Field", "CF", "False"});
		validationValues.put(BaseballPosition.Right_Field, new String[]{"Right Field", "RF", "False"});
		validationValues.put(BaseballPosition.Starting_Pitcher, new String[]{"Starting Pitcher", "SP", "True"});
		validationValues.put(BaseballPosition.Relief_Pitcher, new String[]{"Relief Pitcher", "RP", "True"});

		return validationValues;
	}
	
}
