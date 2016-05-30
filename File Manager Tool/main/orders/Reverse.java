package oop.ex6.filescript.orders;

import java.io.File;

public class Reverse extends Compare {

	/** The order being reversed */
	private Order order;
	/**
	 * A data constructor.
	 * @param order - The order being reversed.
	 */
	public Reverse(Order order) {
		this.order = order;
	}
	
	@Override
	public int compare(File file1, File file2) {
		return order.compare(file1, file2)*REVERSE;
	}
}
