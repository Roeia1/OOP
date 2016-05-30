package oop.ex6.filescript.orders;

import java.io.File;
import java.util.LinkedList;

public interface Order {

	/**
	 * This method sorting the list according to the order.
	 */
	public void sortby(LinkedList<File> toSort);
	/**
	 * This method implements the operator compare.
	 * @param file1 - The first file being compared.
	 * @param file2 - The second file being compared.
	 * @return The result of the comparison.
	 */
	public int compare(File file1, File file2);
}
