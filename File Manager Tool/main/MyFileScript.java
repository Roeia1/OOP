package oop.ex6.filescript;

import java.io.File;
import java.util.LinkedList;

public class MyFileScript {
	
	/** The source dir location in the argument */
	private static final int SOURCE_DIR_LOCATION = 0;
	/** The command file location in the argument */
	private static final int COMMAND_FILE_LOCATION = 1;
	/** The error message for type 2 error */
	private static final String ERROR_2_MESSAGE = "ERROR";
	
	public static void main(String[] args) {
		try {
			// Creating the sections from the command file
			LinkedList<Section> sectionList = Parsing.parser
					(args[COMMAND_FILE_LOCATION]);
			
			File file = new File(args[SOURCE_DIR_LOCATION]);
			File[] fileArray = file.listFiles();
			LinkedList<File> filteredFiles;
			/*
			 *  For each section checking for warnings and print the filtered
			 *  files after ordering them.
			 */
			for(Section currentSection : sectionList) {
				filteredFiles = new LinkedList<>();
				if(currentSection.getFilterWarningLine() !=
						Parsing.NO_WARNING) {
					System.out.println("Warning in line " +
							currentSection.getFilterWarningLine());
				}
				if(currentSection.getOrderWarningLine() !=
						Parsing.NO_WARNING) {
					System.out.println("Warning in line " + 
							currentSection.getOrderWarningLine());
				}
				for(int currentFile=0; currentFile < fileArray.length;
						currentFile++) {
					if(!fileArray[currentFile].isDirectory() && 
							currentSection.getFilter().
							isPass(fileArray[currentFile])) {
						filteredFiles.add(fileArray[currentFile]);
					}
				}
				currentSection.getOrder().sortby(filteredFiles);
				printFiles(filteredFiles);
			}
		} catch (ArrayIndexOutOfBoundsException | Type2Exception e) {
			System.err.println(ERROR_2_MESSAGE);
		}
	}
	/*
	 * Printing files method, getting a linked list of files and print them.
	 */
	private static void printFiles(LinkedList<File> filesToPrint) {
		for(File currentFile : filesToPrint) {
			System.out.println(currentFile.getName());
		}
	}
}
