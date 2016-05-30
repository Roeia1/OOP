package oop.ex6.filescript.filters;

import java.io.File;

public class GreaterThan extends SizeFilters {

	/**
	 * A data constructor.
	 * @param sizeValue - The size value that being compared.
	 * @throws ValueOutOfRangeException - If the size value is not valid.
	 */
	public GreaterThan(double sizeValue) throws ValueOutOfRangeException {
		super(sizeValue);
	}

	@Override
	public boolean isPass(File file) {
		if (convertToKilobytes(file.length()) > this.sizeValue) {
			return true;
		} else {
			return false;
		}
	}
}
