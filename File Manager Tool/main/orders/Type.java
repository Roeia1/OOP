package oop.ex6.filescript.orders;

import java.io.File;

public class Type extends Compare {

	@Override
	public int compare(File file1, File file2) {
		String file1Type = file1.getName().substring
				(file1.getName().lastIndexOf(".") + 1);
		String file2Type = file2.getName().substring
				(file2.getName().lastIndexOf(".") + 1);
		if (file1Type.compareTo(file2Type) < 0) {
			return FIRST_FILE;
		} else if (file1Type.compareTo(file2Type) > 0) {
			return SECOND_FILE;
		} else {
			return OrderFactory.DEFAULT_ORDER.compare(file1, file2);
		}
	}
}
