package oop.ex6.filescript.orders;

import java.io.File;

public class Size extends Compare {

	@Override
	public int compare(File file1, File file2) {
		if (file1.length() < file2.length()) {
			return FIRST_FILE;
		} else if (file1.length() > file2.length()) {
			return SECOND_FILE;
		} else {
			return OrderFactory.DEFAULT_ORDER.compare(file1, file2);
		}
	}
}
