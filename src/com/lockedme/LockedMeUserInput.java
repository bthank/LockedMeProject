package com.lockedme;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * The  LockedMeUserInput class encapsulates console user input	handling for the LockedMeApplication
 * @author Binu T
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
	
	public char getFileProcessingChoiceFromUser() {
		this.choice = sc.nextLine().charAt(0);
		return this.choice;
	}
	
	public File getDirectoryPathFromUser() {
		String path = sc.nextLine();
		directoryPath = new File(path);
		return this.directoryPath;
	}
	
	public String getFileNameFromUser() {
		this.fileName = sc.nextLine();
		return this.fileName;
	}
		
	public int getNumLinesInFileFromUser() {
		if (sc.hasNextInt()) {
			this.numLinesInFile = sc.nextInt();
			sc.nextLine();
		} else {
			this.numLinesInFile = -1;
		}

		return this.numLinesInFile;
	}
	
	public String getLineToAddToFileFromUser() {
		String line = sc.nextLine();
		return line;
	}
	
	public void closeScanner() {
		if (sc != null)
			this.sc.close();
	}
}
