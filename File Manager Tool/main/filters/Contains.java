package oop.ex6.filescript.filters;

import java.io.File;

public class Contains extends NameFilters{

	/**
	 * A data constructor.
	 * @param fileName - The string being checked if contained.
	 */
	public Contains(String fileName) {
		super(fileName);
	}

	@Override
	public boolean isPass(File file) {
		return file.getName().contains(this.fileName);
	}
}
