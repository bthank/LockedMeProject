package com.lockedme;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * The  LockedMeUserInput class encapsulates console user input	handling for the LockedMeApplication
 * @author Binu Thankachan
 *
 */
public class LockedMeUserInput {

	private Scanner sc;
	
	private char choice;
	private File directoryPath;
	private String fileName;
	private int numLinesInFile;

	
	
	LockedMeUserInput(){
		this.sc = new Scanner(System.in);
	}
	/**
	 * The getFileProcessingChoiceFromUser method retrieves the user's selection from console input.
	 * @return char
	 */
	public char getFileProcessingChoiceFromUser() {
		this.choice = sc.nextLine().charAt(0);
		return this.choice;
	}
	
	/**
	 *  The getDirectoryPathFromUser method retrieves the directory path to process from console input.
	 * @return File
	 */
	public File getDirectoryPathFromUser() {
		String path = sc.nextLine();
		// instantiates directoryPath File object
		directoryPath = new File(path);
		return this.directoryPath;
	}
	
	/**
	 * The getFileNameFromUser method retrieves the file name to process from console input.
	 * @return String
	 */
	public String getFileNameFromUser() {
		this.fileName = sc.nextLine();
		return this.fileName;
	}
		
	/**
	 * The getNumLinesInFileFromUser method retrieves the # of lines in a file from console input.
	 * @return int
	 */
	public int getNumLinesInFileFromUser() {
		if (sc.hasNextInt()) {
			this.numLinesInFile = sc.nextInt();
			sc.nextLine();
		} else {
			// set numLinesInFile to -1 to signal invalid input
			this.numLinesInFile = -1;
		}

		return this.numLinesInFile;
	}
	
	/**
	 * The getLineToAddToFileFromUser method retrieves the line to add to a file from console input.
	 * @return String
	 */
	public String getLineToAddToFileFromUser() {
		String line = sc.nextLine();
		return line;
	}
	
	/**
	 * The closeScanner method closes the class' scanner object if it is not null.
	 * @return void
	 */
	public void closeScanner() {
		if (sc != null)
			this.sc.close();
	}
}
