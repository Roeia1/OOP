package oop.ex6.filescript.filters;

public class FilterFactory {

	/** The default filter */
	public final static Filter DEFAULT_FILTER = All.instance();
	/** The regex sign */
	private final static String REGEX = "#";
	/** The not command */
	private final static String NOT_COMMAND = "NOT";
	/** The filter name location in the string */
	private final static int FILTER_NAME = 0;
	/** The filter value location in the string */
	private final static int FILTER_VALUE = 1;
	/** The filter second value location in the string */
	private final static int FILTER_SECOND_VALUE = 2;
	/**
	 * This method creating the filter according to the command.
	 * @param filterText - The command from the command file.
	 * @return The filter that created.
	 * @throws FilterException - If the filter command has an error.
	 */
	public static Filter createFilters(String filterText)
			throws FilterException {
		Filter filter;
		String[] filterStringArray = filterText.split(REGEX);
		switch (filterStringArray[FILTER_NAME]) {
			case "greater_than":
				filter = new GreaterThan(
						Double.parseDouble(filterStringArray[FILTER_VALUE]));
				break;
			case "between":
				filter = new Between(
						Double.parseDouble(filterStringArray[FILTER_VALUE]),
						Double.parseDouble(filterStringArray
								[FILTER_SECOND_VALUE]));
				break;
			case "smaller_than":
				filter = new SmallerThan(
						Double.parseDouble(filterStringArray[FILTER_VALUE]));
				break;
			case "file":
				filter = new FileName(
						filterStringArray[FILTER_VALUE]);
				break;
			case "contains":
				filter = new Contains(
						filterStringArray[FILTER_VALUE]);
				break;
			case "prefix":
				filter = new Prefix(
						filterStringArray[FILTER_VALUE]);
				break;
			case "suffix":
				filter = new Suffix(
						filterStringArray[FILTER_VALUE]);
				break;
			case "writable":
				filter = new Writable(
						filterStringArray[FILTER_VALUE]);
				break;
			case "executable":
				filter = new Executable(
						filterStringArray[FILTER_VALUE]);
				break;
			case "hidden":
				filter = new Hidden(
						filterStringArray[FILTER_VALUE]);
				break;
			case "all":
				filter = All.instance();
				break;
			default:
				throw new FilterException();
		}
		if (filterText.endsWith(NOT_COMMAND)) {
			filter = new Negative(filter);
		}
		return filter;
	}
}
