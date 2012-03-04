import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Fazio
 */
public class RangeGroup extends Range {
	
	private final List<Range> rangeList = new ArrayList<Range>();
	private Range defaultRange;
	
	private static final String DEFAULT_RANGE_VALUE = "Default";

	public RangeGroup() {
		super();

	}

	public RangeGroup(final double rangeSize) {
		super();
		super.setRangeSize(rangeSize);
	}

	@Override
	public Object getRangeValue(final double value) {
		Object rangeValue = defaultRange.getRangeValue();
		
		for(Range checkRange : this.rangeList) {
			if(checkRange.isInRange(value)) {
				rangeValue = checkRange.getRangeValue();
			}
		}

		return rangeValue;
	}
	
	private void setRanges() {
		double lastEndRange = 0.0;
		for(Range range : this.rangeList) {
			lastEndRange = range.setRange(lastEndRange);
		}

		if(this.defaultRange == null) {
			this.defaultRange = new RangeValue(DEFAULT_RANGE_VALUE);
		}
		this.defaultRange.setRange(lastEndRange, 100.0);
	}
	
	public RangeGroup addToRangeGroup(final Range range) {
		this.rangeList.add(range);

		this.setRanges();

		return this;
	}
	
	public Range getDefaultRange() {
		return this.defaultRange;
	}
	
	public RangeGroup setDefaultRange(final Range range) {
		this.defaultRange = range;

		this.setRanges();

		return this;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RangeGroup: ");
		for(Range range : this.rangeList) {
			sb.append("\t");
			sb.append(range.toString());
		}
		
		return sb.toString();
	}
}
