package org.fazio.simsports.baseball.types;

import org.fazio.simsports.baseball.types.attributes.BaseballAttributes;
import org.fazio.simsports.baseball.types.attributes.BatterAttributes;
import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPA;
import org.fazio.simsports.baseball.types.ratings.BaseballRatings;
import org.fazio.simsports.core.types.*;

import java.util.List;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/15/12 9:57 AM
 */
public class BaseballPlayer extends Player {

	public BaseballPlayer(
		final Attributes attributes,
		final String firstName,
		final String lastName,
		final String nickname,
		final String number,
		final List<Position> positions,
		final Statistics statistics) {

			super(attributes, firstName, lastName, nickname, number, positions, statistics);
	}

	@Override
	public Ratings calculateRatings() {
		return new BaseballRatings((BaseballAttributes) this.attributes);
	}

	public int moveBases(final PlateAppearanceResult hit) {
		//TODO: Actually implement this.
		return hit.getBases();
	}
	
	public PlateAppearanceResult getPlayResult() {
		final BatterAttributes attrs = (BatterAttributes) super.attributes;

		final BatterPlateAppearanceRangeGroup group
			= new BatterPlateAppearanceRangeGroup((BattingAttributesByPA) attrs.getBattingAttributes());
		
		return (PlateAppearanceResult) group.getRangeValue();
	}


}
