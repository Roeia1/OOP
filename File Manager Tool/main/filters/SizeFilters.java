package oop.ex6.filescript.filters;

public abstract class SizeFilters implements Filter {

	/** The number of bytes in kilobyte */
	private final int BYTES_IN_KILOBYTE = 1024;
	
	/** The size value */
	protected double sizeValue;
	/**
	 * A data constructor.
	 * @param sizeValue - The size value to compare.
	 * @throws ValueOutOfRangeException - If the size value is negative.
	 */
	public SizeFilters(double sizeValue) throws ValueOutOfRangeException {
		this.sizeValue = sizeValue;
		
		if (this.sizeValue < 0) {
			throw new ValueOutOfRangeException();
		}
	}
	/**
	 * Converting bytes size to kilobytes size.
	 * @param bytesSize - The bytes size to convert.
	 * @return The kilobytes size.
	 */
	protected double convertToKilobytes(double bytesSize) {
		// Return file size in bytes
		return bytesSize/BYTES_IN_KILOBYTE;
	}
}
