package org.fazio.simsports.baseball.types;

import org.fazio.simsports.baseball.types.attributes.BattingAttributesByPA;
import org.fazio.utils.range.Range;
import org.fazio.utils.range.RangeGroup;

/**
 * @author Michael Fazio <michael.fazio@kohls.com>
 * @since 3/13/12 1:23 PM
 */
public class BatterPlateAppearanceRangeGroup extends Range {

	private final BattingAttributesByPA battingAttributes;
	
	private final RangeGroup<PlateAppearanceResult> plateAppearanceRangeGroup;
	private final RangeGroup<PlateAppearanceResult> contactRangeGroup;
	private final RangeGroup<PlateAppearanceResult> flyBallRangeGroup;
	private final RangeGroup<PlateAppearanceResult> groundBallRangeGroup;
	private final RangeGroup<PlateAppearanceResult> lineDriveRangeGroup;

	public BatterPlateAppearanceRangeGroup(final BattingAttributesByPA battingAttributesByPA) {
		this(0, 100, battingAttributesByPA);
	}

	public BatterPlateAppearanceRangeGroup(final int start, final int end, final BattingAttributesByPA battingAttributes) {
		super(start, end);
		this.battingAttributes = battingAttributes;
		
		this.plateAppearanceRangeGroup = new RangeGroup<PlateAppearanceResult>();
		this.contactRangeGroup = new RangeGroup<PlateAppearanceResult>();
		this.flyBallRangeGroup = new RangeGroup<PlateAppearanceResult>(this.battingAttributes.getContactFlyBallChance());
		this.groundBallRangeGroup = new RangeGroup<PlateAppearanceResult>(this.battingAttributes.getContactGroundBallChance());
		this.lineDriveRangeGroup = new RangeGroup<PlateAppearanceResult>(this.battingAttributes.getContactLineDriveChance());

		this.flyBallRangeGroup
			.addRangeValue(new PlateAppearanceResult(Results.FlyBall, Results.Single), this.battingAttributes.getFlyBallSingleChance())
			.addRangeValue(new PlateAppearanceResult(Results.FlyBall, Results.Double), this.battingAttributes.getFlyBallDoubleChance())
			.addRangeValue(new PlateAppearanceResult(Results.FlyBall, Results.Triple), this.battingAttributes.getFlyBallTripleChance())
			.addRangeValue(new PlateAppearanceResult(Results.FlyBall, Results.HomeRun), this.battingAttributes.getFlyBallHomeRunChance())
			.setDefaultRangeValue(new PlateAppearanceResult(Results.FlyBall, Results.Out));

		this.groundBallRangeGroup
			.addRangeValue(new PlateAppearanceResult(Results.GroundBall, Results.Single), this.battingAttributes.getGroundBallSingleChance())
			.addRangeValue(new PlateAppearanceResult(Results.GroundBall, Results.Double), this.battingAttributes.getGroundBallDoubleChance())
			.addRangeValue(new PlateAppearanceResult(Results.GroundBall, Results.Triple), this.battingAttributes.getGroundBallTripleChance())
			.addRangeValue(new PlateAppearanceResult(Results.GroundBall, Results.HomeRun), this.battingAttributes.getGroundBallHomeRunChance())
			.setDefaultRangeValue(new PlateAppearanceResult(Results.GroundBall, Results.Out));

		this.lineDriveRangeGroup
			.addRangeValue(new PlateAppearanceResult(Results.LineDrive, Results.Single), this.battingAttributes.getLineDriveSingleChance())
			.addRangeValue(new PlateAppearanceResult(Results.LineDrive, Results.Double), this.battingAttributes.getLineDriveDoubleChance())
			.addRangeValue(new PlateAppearanceResult(Results.LineDrive, Results.Triple), this.battingAttributes.getLineDriveTripleChance())
			.addRangeValue(new PlateAppearanceResult(Results.LineDrive, Results.HomeRun), this.battingAttributes.getLineDriveHomeRunChance())
			.setDefaultRangeValue(new PlateAppearanceResult(Results.LineDrive, Results.Out));

		this.contactRangeGroup
			.addToRangeGroup(this.flyBallRangeGroup)
			.addToRangeGroup(this.groundBallRangeGroup)
			.setDefaultRange(this.lineDriveRangeGroup);

		this.plateAppearanceRangeGroup
			.addRangeValue(new PlateAppearanceResult(Results.BB), this.battingAttributes.getWalkChance())
			.addRangeValue(new PlateAppearanceResult(Results.HBP), this.battingAttributes.getHitByPitchChance())
			.addToRangeGroup(
				new RangeGroup<PlateAppearanceResult>(this.battingAttributes.getStrikeoutChance())
				.addRangeValue(new PlateAppearanceResult(Results.StrikeoutLooking), this.battingAttributes.getStrikeoutLookingChance())
				.setDefaultRangeValue(new PlateAppearanceResult(Results.StrikeoutSwinging)))
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
