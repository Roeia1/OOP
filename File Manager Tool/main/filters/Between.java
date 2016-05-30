package oop.ex6.filescript.filters;

import java.io.File;

public class Between extends SizeFilters {

	/** The max size value */
	private double maxSizeValue;
	/**
	 * A data constructor.
	 * @param minSizeValue - The minimum size value.
	 * @param maxSizeValue - The maximum size value.
	 * @throws ValueOutOfRangeException - If the value is not between them.
	 */
	public Between(double minSizeValue, double maxSizeValue)
			throws ValueOutOfRangeException {
		super(minSizeValue);
		this.maxSizeValue = maxSizeValue;
		if (this.maxSizeValue < 0 || 
				this.maxSizeValue < this.sizeValue) {
			throw new ValueOutOfRangeException();
		}
	}

	@Override
	public boolean isPass(File file) {
		double fileSize = convertToKilobytes(file.length());
		if (fileSize <= this.maxSizeValue &&
				fileSize >= this.sizeValue) {
			return true;
		} else {
			return false;
		}
	}
}
