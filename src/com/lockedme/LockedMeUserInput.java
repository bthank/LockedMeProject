package com.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeUserInput {

	private Scanner sc;
	
	private char choice;
	private File directoryPath;
	private String fileName;
	private int numLinesInFile;
	private List<String> fileContent;
	
	
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
		} else {
			this.numLinesInFile = -1;
		}

		return this.numLinesInFile;
	}
	
	public void initFileContentList() {
		this.fileContent = new ArrayList<String>();
	}
	
	public String getLineToAddToFileFromUser() {
		String line = sc.nextLine();
		return line;
	}
	
	public void addLineToFileContentList(String line) {
		this.fileContent.add(line);
	}
	
	public void closeScanner() {
		this.sc.close();
	}
}
