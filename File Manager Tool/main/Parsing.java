package oop.ex6.filescript;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.LinkedList;
import oop.ex6.filescript.filters.*;
import oop.ex6.filescript.orders.*;

public class Parsing {

	/** The value for no warning */
	protected final static int NO_WARNING = -1;
	/** The value for valid filter */
	private final static String VALID_FILTER_STRING = "FILTER";
	/** The value for valid order */
	private final static String VALID_ORDER_STRING = "ORDER";
	
	/** The current filter of the section */
	private static Filter currentFilter;
	/** The current order of the section */
	private static Order currentOrder;
	/** The current section in the command file */
	private static Section currentSection;
	/** The section list */
	private static LinkedList<Section> sectionList;
	/** The location of the filter line warning */
	private static int filterWarningLine;
	/** The location of the order line warning */
	private static int orderWarningLine;
	/**
	 * This method running over the command file and creating a section list.
	 * @param commandFile - The command file location.
	 * @return A linked list of sections.
	 * @throws Type2Exception - FILTER/ORDER don't appear in each section,
	 * or a problem with the command file path.
	 */
	public static LinkedList<Section> parser(String commandFile)
			throws Type2Exception {
		try (LineNumberReader parserReader = new LineNumberReader
				(new FileReader(commandFile));) {
			sectionList = new LinkedList<Section>();
			String currCommand = parserReader.readLine();
			// Each iteration is a section
			while (currCommand != null) {
				// Initializing no warnings
				filterWarningLine = NO_WARNING;
				orderWarningLine = NO_WARNING;
				// Checking for the filter headline
				if (!currCommand.equals(VALID_FILTER_STRING)) {
					throw new Type2Exception();
				}
				// Getting the filter
				currCommand = parserReader.readLine();
				// Creating the filter
				try {
					currentFilter = FilterFactory.createFilters(currCommand);
				} catch (FilterException e) {
					currentFilter = FilterFactory.DEFAULT_FILTER;
					filterWarningLine = parserReader.getLineNumber();
				}
				/* 
				 * Checking for the order headline, if there is no order
				 * then creating the default order.
				 */
				currCommand = parserReader.readLine();
				if (currCommand == null ||
							!currCommand.equals(VALID_ORDER_STRING)) {
					throw new Type2Exception();
				} else {
					// Getting and creating the order
					currCommand = parserReader.readLine();
					if (currCommand != null &&
							!currCommand.equals(VALID_FILTER_STRING)) {
						try {
							currentOrder = OrderFactory.createOrders
									(currCommand);
						} catch (OrderException e) {
							currentOrder = OrderFactory.DEFAULT_ORDER;
							orderWarningLine = parserReader.getLineNumber();
						}
						// Continue to the next section
						currCommand = parserReader.readLine();
					} else {
						// Order is blank
						currentOrder = OrderFactory.DEFAULT_ORDER;
					}
				}
				// Creating and adding the current section to the list
				currentSection = new Section(currentFilter, currentOrder,
						filterWarningLine, orderWarningLine);
				sectionList.add(currentSection);
			}
		} catch (IOException e) {
			throw new Type2Exception();
		}
		return sectionList;
	}
}
