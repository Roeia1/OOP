package oop.ex6.filescript.filters;

import java.io.File;

public class FileName extends NameFilters {

	/**
	 * A data constructor.
	 * @param fileName - The name to compare to the file.
	 */
	public FileName(String fileName) {
		super(fileName);
	}

	@Override
	public boolean isPass(File file) {
		return file.getName().equals(this.fileName);
	}
}
