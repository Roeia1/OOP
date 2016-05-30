package oop.ex6.filescript.filters;

import java.io.File;

public class Negative implements Filter {

	/** The filter being negated */
	private Filter filter;
	/**
	 * A data constructor.
	 * @param filter - The filter being negated.
	 */
	public Negative(Filter filter) {
		this.filter = filter;
	}
	
	@Override
	public boolean isPass(File file) {
		return !filter.isPass(file);
	}
}
