package org.fazio.simsports.baseball.types;

import org.fazio.simsports.baseball.types.attributes.BatterAttributes;
import org.fazio.simsports.baseball.types.attributes.BatterAttributesByPA;
import org.fazio.simsports.core.types.*;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/15/12 9:57 AM
 */
public class BaseballPlayer extends Player {

	public BaseballPlayer(Attributes attributes, String firstName, String lastName, String nickname, Position position, Ratings ratings, Statistics statistics) {
		super(attributes, firstName, lastName, nickname, position, ratings, statistics);
	}
	
	public int moveBases(final PlateAppearanceResult hit) {
		//TODO: Actually implement this.
		return hit.getBases();
	}
	
	public PlayResult getPlayResult() {
		BatterAttributes attrs = (BatterAttributes) super.attributes;

		BatterPlateAppearanceRangeGroup group = new BatterPlateAppearanceRangeGroup((BatterAttributesByPA) attrs.getBattingAttributes());
		
		return (PlayResult) group.getRangeValue();
	}
}
