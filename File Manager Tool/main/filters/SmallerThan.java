package oop.ex6.filescript.filters;

import java.io.File;

public class SmallerThan extends SizeFilters {
	
	/**
	 * A data constructor.
	 * @param sizeValue - The size value being compared.
	 * @throws ValueOutOfRangeException - If the size value is not valid.
	 */
	public SmallerThan(double sizeValue) throws ValueOutOfRangeException {
		super(sizeValue);
	}

	@Override
	public boolean isPass(File file) {
		if (convertToKilobytes(file.length()) < this.sizeValue) {
			return true;
		} else {
			return false;
		}
	}

}
