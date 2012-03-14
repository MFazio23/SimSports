package org.fazio.simsports.core.ranges;

import java.util.ArrayList;
import java.util.List;

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
	
	public String toString(final int level) {
		StringBuilder sb = new StringBuilder();
		for(int x=0;x<level;x++) sb.append("\t");
		sb.append("Range Group: Size = ");
		sb.append(super.rangeSize);
		sb.append("[");
		sb.append(super.start);
		sb.append(" -> ");
		sb.append(super.end);
		sb.append("]\n");
		for(Range range : this.rangeList) {
			sb.append(range.toString(level + 1));
			sb.append('\n');
		}

		sb.append(this.defaultRange.toString(level + 1));
		sb.append(" (Default)");
		
		return sb.toString();
	}

	public String toString() {
		return this.toString(0);
	}
}
