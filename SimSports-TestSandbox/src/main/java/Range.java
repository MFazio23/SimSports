import java.util.StringTokenizer;

/**
 * @author Michael Fazio
 */
public abstract class Range {

	protected double start;
	protected double end;
	protected double rangeSize;

	public Range() {
		this(0, 100);
	}

	public Range(final double rangeSize) {
		this(0, rangeSize);
	}

	public Range(final double start, final double end) {
		this.setRange(start, end);
	}

	public boolean isInRange(final double value) {
		boolean inRange = true;

		if(value >= end) inRange = false;
		if(value < start) inRange = false;

		return inRange;
	}
	
	public Object getRangeValue() {

		return this.getRangeValue(Math.random() * 100);
	}
	
	public abstract Object getRangeValue(final double value);
	
	public void setRange(final double start, final double end) {
		this.start = start;
		this.end = end;
		this.rangeSize = end - start;
	}

	public double setRange(final double start) {
		this.start = start;
		this.end = this.start + this.rangeSize;

		return this.end;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getRangeSize() {
		return rangeSize;
	}

	public void setRangeSize(double rangeSize) {
		this.rangeSize = rangeSize;
	}
	
	public String toString() {
		return "Range: " + this.start + " -> " + this.end + " [" + this.rangeSize + "]";
	}
}
