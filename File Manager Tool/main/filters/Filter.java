package oop.ex6.filescript.filters;

import java.io.File;

public interface Filter {

	/**
	 * This method checks if the file passed the filter.
	 * @param file - The file being checked.
	 * @return The result of the check.
	 */
	public boolean isPass(File file);
}
