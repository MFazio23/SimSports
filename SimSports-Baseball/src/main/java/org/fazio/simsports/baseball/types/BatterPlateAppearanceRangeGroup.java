package org.fazio.simsports.baseball.types;

import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPA;
import org.fazio.utils.range.Range;
import org.fazio.utils.range.RangeGroup;
import org.fazio.utils.range.RangeValue;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/13/12 1:23 PM
 */
public class BatterPlateAppearanceRangeGroup extends Range {

	private final BattingAttributesByPA battingAttributes;
	
	private final RangeGroup plateAppearanceRangeGroup;
	private final RangeGroup contactRangeGroup;
	private final RangeGroup flyBallRangeGroup;
	private final RangeGroup groundBallRangeGroup;
	private final RangeGroup lineDriveRangeGroup;

	public BatterPlateAppearanceRangeGroup(final BattingAttributesByPA battingAttributesByPA) {
		this(0, 100, battingAttributesByPA);
	}

	public BatterPlateAppearanceRangeGroup(final int start, final int end, final BattingAttributesByPA battingAttributes) {
		super(start, end);
		this.battingAttributes = battingAttributes;
		
		this.plateAppearanceRangeGroup = new RangeGroup();
		this.contactRangeGroup = new RangeGroup();
		this.flyBallRangeGroup = new RangeGroup(this.battingAttributes.getContactFlyBallChance());
		this.groundBallRangeGroup = new RangeGroup(this.battingAttributes.getContactGroundBallChance());
		this.lineDriveRangeGroup = new RangeGroup(this.battingAttributes.getContactLineDriveChance());

		this.flyBallRangeGroup
			.addToRangeGroup(new RangeValue(this.battingAttributes.getFlyBallSingleChance(), new PlateAppearanceResult(Results.FlyBall, Results.Single)))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getFlyBallDoubleChance(), new PlateAppearanceResult(Results.FlyBall, Results.Double)))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getFlyBallTripleChance(), new PlateAppearanceResult(Results.FlyBall, Results.Triple)))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getFlyBallHomeRunChance(), new PlateAppearanceResult(Results.FlyBall, Results.HomeRun)))
			.setDefaultRange(new RangeValue(new PlateAppearanceResult(Results.FlyBall, Results.Out)));

		this.groundBallRangeGroup
			.addToRangeGroup(new RangeValue(this.battingAttributes.getGroundBallSingleChance(), new PlateAppearanceResult(Results.GroundBall, Results.Single)))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getGroundBallDoubleChance(), new PlateAppearanceResult(Results.GroundBall, Results.Double)))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getGroundBallTripleChance(), new PlateAppearanceResult(Results.GroundBall, Results.Triple)))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getGroundBallHomeRunChance(), new PlateAppearanceResult(Results.GroundBall, Results.HomeRun)))
			.setDefaultRange(new RangeValue(new PlateAppearanceResult(Results.GroundBall, Results.Out)));

		this.lineDriveRangeGroup
			.addToRangeGroup(new RangeValue(this.battingAttributes.getLineDriveSingleChance(), new PlateAppearanceResult(Results.LineDrive, Results.Single)))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getLineDriveDoubleChance(), new PlateAppearanceResult(Results.LineDrive, Results.Double)))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getLineDriveTripleChance(), new PlateAppearanceResult(Results.LineDrive, Results.Triple)))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getLineDriveHomeRunChance(), new PlateAppearanceResult(Results.LineDrive, Results.HomeRun)))
			.setDefaultRange(new RangeValue(new PlateAppearanceResult(Results.LineDrive, Results.Out)));

		this.contactRangeGroup
			.addToRangeGroup(this.flyBallRangeGroup)
			.addToRangeGroup(this.groundBallRangeGroup)
			.setDefaultRange(this.lineDriveRangeGroup);

		this.plateAppearanceRangeGroup
			.addToRangeGroup(new RangeValue(this.battingAttributes.getWalkChance(), new PlateAppearanceResult(Results.BB)))
			.addToRangeGroup(new RangeValue(this.battingAttributes.getHitByPitchChance(), new PlateAppearanceResult(Results.HBP)))
			.addToRangeGroup(new RangeGroup(this.battingAttributes.getStrikeoutChance())
				.addToRangeGroup(new RangeValue(this.battingAttributes.getStrikeoutLookingChance(), new PlateAppearanceResult(Results.StrikeoutLooking)))
				.setDefaultRange(new RangeValue(new PlateAppearanceResult(Results.StrikeoutSwinging))))
			.setDefaultRange(this.contactRangeGroup);
	}

	public BattingAttributesByPA getBattingAttributes() {
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
