package oop.ex6.filescript.filters;

import java.io.File;

public class All implements Filter {

	/** The single instance of this filter */
	private static All singleAllFilter = null;
	/*
	 * A private default constructor so there will be only one instance.
	 */
	private All(){};
	/**
	 * This method always returns a reference to the same single static All
	 * filter.
	 * @return The single static All filter.
	 */
	public static All instance() {
		if (singleAllFilter == null) {
			singleAllFilter = new All();
		}
		return singleAllFilter;
	}
	public boolean isPass(File file) {
		// No condition to check.
		return true;
	}
}
