package oop.ex6.filescript.filters;

public abstract class NameFilters implements Filter {

	/** The name value being compared to */
	protected String fileName;
	/**
	 * A data constructor.
	 * @param fileName - The name to compare to.
	 */
	public NameFilters(String fileName) {
		this.fileName = fileName;
	}
}
