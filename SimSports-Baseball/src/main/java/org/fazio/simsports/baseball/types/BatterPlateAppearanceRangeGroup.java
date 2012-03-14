package org.fazio.simsports.baseball.types;

import org.fazio.simsports.baseball.types.attributes.BatterAttributesByPA;
import org.fazio.simsports.core.ranges.Range;
import org.fazio.simsports.core.ranges.RangeGroup;
import org.fazio.simsports.core.ranges.RangeValue;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/13/12 1:23 PM
 */
public class BatterPlateAppearanceRangeGroup extends Range {

	private final BatterAttributesByPA battingAttributes;
	
	private final RangeGroup plateAppearanceRangeGroup;
	private final RangeGroup contactRangeGroup;
	private final RangeGroup flyBallRangeGroup;
	private final RangeGroup groundBallRangeGroup;
	private final RangeGroup lineDriveRangeGroup;

	public BatterPlateAppearanceRangeGroup(final BatterAttributesByPA batterAttributesByPA) {
		this(0, 100, batterAttributesByPA);
	}

	public BatterPlateAppearanceRangeGroup(final int start, final int end, final BatterAttributesByPA battingAttributes) {
		super(start, end);
		this.battingAttributes = battingAttributes;
		
		this.plateAppearanceRangeGroup = new RangeGroup();
		this.contactRangeGroup = new RangeGroup();
		this.flyBallRangeGroup = new RangeGroup(this.battingAttributes.getContactFlyBallChance());
		this.groundBallRangeGroup = new RangeGroup(this.battingAttributes.getContactGroundBallChance());
		this.lineDriveRangeGroup = new RangeGroup(this.battingAttributes.getContactLineDriveChance());

		this.flyBallRangeGroup
			.addToRangeGroup(new RangeValue(this.battingAttributes.getFlyBallSingleChance(), "Fly Ball Single"))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getFlyBallDoubleChance(), "Fly Ball Double"))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getFlyBallTripleChance(), "Fly Ball Triple"))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getFlyBallHomeRunChance(), "Fly Ball Home Run"))
			.setDefaultRange(new RangeValue("Fly Ball Out"));

		this.groundBallRangeGroup
			.addToRangeGroup(new RangeValue(this.battingAttributes.getGroundBallSingleChance(), "Ground Ball Single"))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getGroundBallDoubleChance(), "Ground Ball Double"))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getGroundBallTripleChance(), "Ground Ball Triple"))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getGroundBallHomeRunChance(), "Ground Ball Home Run"))
			.setDefaultRange(new RangeValue("Ground Ball Out"));

		this.lineDriveRangeGroup
			.addToRangeGroup(new RangeValue(this.battingAttributes.getLineDriveSingleChance(), "Line Drive Single"))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getLineDriveDoubleChance(), "Line Drive Double"))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getLineDriveTripleChance(), "Line Drive Triple"))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getLineDriveHomeRunChance(), "Line Drive Home Run"))
			.setDefaultRange(new RangeValue("Line Drive Out"));

		this.contactRangeGroup
			.addToRangeGroup(this.flyBallRangeGroup)
			.addToRangeGroup(this.groundBallRangeGroup)
			.setDefaultRange(this.lineDriveRangeGroup);

		this.plateAppearanceRangeGroup
			.addToRangeGroup(new RangeValue(this.battingAttributes.getWalkChance(), "Walk"))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getHitByPitchChance(), "HBP"))
			.addToRangeGroup(new RangeGroup(this.battingAttributes.getStrikeoutChance())
				.addToRangeGroup(new RangeValue(this.battingAttributes.getStrikeoutLookingChance(), "Strikeout Looking"))
				.setDefaultRange(new RangeValue("Strikeout Swinging")))
			.setDefaultRange(this.contactRangeGroup);
	}

	public BatterAttributesByPA getBattingAttributes() {
		return battingAttributes;
	}

	public RangeGroup getPlateAppearanceRangeGroup() {
		return plateAppearanceRangeGroup;
	}

	public RangeGroup getContactRangeGroup() {
		return contactRangeGroup;
	}

	public RangeGroup getFlyBallRangeGroup() {
		return flyBallRangeGroup;
	}

	public RangeGroup getGroundBallRangeGroup() {
		return groundBallRangeGroup;
	}

	public RangeGroup getLineDriveRangeGroup() {
		return lineDriveRangeGroup;
	}

	@Override
	public Object getRangeValue(final double value) {
		return this.plateAppearanceRangeGroup.getRangeValue(value);
	}
}
