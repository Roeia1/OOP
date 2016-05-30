package oop.ex6.filescript.orders;

import java.io.File;

public class Abs extends Compare {

	/** The value for equals */
	private final int EQUALS = 0;
	
	@Override
	public int compare(File file1, File file2) {
		int compareValue = file1.getAbsolutePath().compareTo
							(file2.getAbsolutePath());
		if (compareValue < 0) {
			return FIRST_FILE;
		} else if (compareValue > 0) {
			return SECOND_FILE;
		} else {
			return EQUALS;
		}
	}	
}
