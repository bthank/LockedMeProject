package com.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	
	private List<String> fileNames; 
	
	public void listAllFilesInDirectory(File directoryPath) {
		fileNames = new ArrayList<>(); 
		
		// retrieving all files into a File array
		File[] files = directoryPath.listFiles();
		// for loop to iterate through files array and get the individual file names and save them in fileNames collection
		for(File file: files) {
			fileNames.add(file.getName());
		}
		System.out.println("\n\tList of files and folders in the specified directory:\n");
		// for loop to iterate through fileNames collection and display each file name
		for (int i=0; i < fileNames.size(); i++) {
			System.out.println("\t\t" + fileNames.get(i));
		}
	}

	public void addAFileToDirectory() {
		
	}
	
	public void searchForFileInDirectory() {
		
	}
	
	public void deleteFileFromDirectory() {
		
	}
}
