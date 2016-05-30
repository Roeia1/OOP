package oop.ex6.filescript.filters;

import java.io.File;

public class Suffix extends NameFilters {

	/**
	 * A data constructor.
	 * @param fileName - The string being checked if ends with.
	 */
	public Suffix(String fileName) {
		super(fileName);
	}

	@Override
	public boolean isPass(File file) {
		return file.getName().endsWith(fileName);
	}

}
