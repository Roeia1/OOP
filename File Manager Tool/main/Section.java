package oop.ex6.filescript;

import oop.ex6.filescript.filters.*;
import oop.ex6.filescript.orders.*;

public class Section {
	
	/** The filter of the section */
	private Filter filter;
	/** The order of the section */
	private Order order;
	/** The location of the filter line warning */
	private int filterWarningLine;
	/** The location of the order line warning */
	private int orderWarningLine;
	/**
	 * A data constructor.
	 * @param filter - The filter of this section.
	 * @param order - The order of this section.
	 * @param filterWarningLine - The location of the filter line warning.
	 * @param orderWarningLine - The location of the order line warning.
	 */
	public Section (Filter filter, Order order,
					int filterWarningLine, int orderWarningLine) {
		this.filter = filter;
		this.order = order;
		this.filterWarningLine = filterWarningLine;
		this.orderWarningLine = orderWarningLine;
	}

	public Filter getFilter() {
		return filter;
	}

	public Order getOrder() {
		return order;
	}

	public int getFilterWarningLine() {
		return filterWarningLine;
	}

	public int getOrderWarningLine() {
		return orderWarningLine;
	}
}
