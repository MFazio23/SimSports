/**
 * @author Michael Fazio
 */
public class RangeValue extends Range {
	
	private final Object value;

	public RangeValue(final Object value) {
		this(100.0, value);
	}
	
	public RangeValue(final double rangeSize, final Object value) {
		super(rangeSize);
		this.value = value;
	}
	
	@Override
	public Object getRangeValue(final double value) {
		return this.getValue();
	}
	
	public Object getValue() {
		return this.value;
	}
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		
		sb.append("RangeValue: Value = ");
		sb.append(this.value);
		sb.append(", Range Size = ");
		sb.append(super.rangeSize);
		sb.append("[");
		sb.append(super.start);
		sb.append(" -> ");
		sb.append(super.end);
		sb.append("]");

		return sb.toString();
	}
}
