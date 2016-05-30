package oop.ex6.filescript.orders;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public abstract class Compare implements Order, Comparator<File>{
	/** The value for the first file in comparison */
	protected final int FIRST_FILE = -1;
	/** The value for the second file in comparison */
	protected final int SECOND_FILE = 1;
	/** The value to multiply to reverse the order */
	protected final int REVERSE = -1;
	
	public void sortby(LinkedList<File> toSort) {
		Collections.sort(toSort, this);
	}
}
