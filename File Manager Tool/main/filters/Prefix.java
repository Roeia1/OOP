package oop.ex6.filescript.filters;

import java.io.File;

public class Prefix extends NameFilters {

	/**
	 * A data constructor.
	 * @param fileName - The string being checked if starts with.
	 */
	public Prefix(String fileName) {
		super(fileName);
	}

	@Override
	public boolean isPass(File file) {
		return file.getName().startsWith(fileName);
	}

}
