package com.lockedme;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LockedMeApplication {

	
	public static void main(String[] args) throws IOException {
		
		// instantiating LockedMeConsole object which encapsulates user prompt handling
		LockedMeConsole lockedMeConsole = new LockedMeConsole();
		// instantiating LockedMeUserInput object which encapsulates user input handling
		LockedMeUserInput lockedMeUserInput = new LockedMeUserInput();
		// instantiating FileManager object which encapsulates file handling functions
		FileManager fileManager = new FileManager();
		
		// variable to hold user's processing selection
		char choice = ' ';
		// variable to hold the directory path object
		File directoryPath = null;
		// variable to hold the file name to process
		String fileName = "";
		// variable to hold the # of lines to add to a file
		int numLinesToAddToFile = 0;
		// collection variable to hold the lines to write to a file
		List<String> fileLines;
		
		// collection variable to hold the list of file names in a directory
	//	List<String> fileNames = new ArrayList<>(); 
		
		// variable holding a sentinal value determining when to continue in or exit loop
		boolean doFileProcessing = true;
		while(doFileProcessing) {

			// LockedMeConsole method to display main menu for the application
			lockedMeConsole.displayMenu();
			
			// LockedMeConsole method to display a prompt for the user to enter their file processing choice
			lockedMeConsole.displayEnterChoicePrompt();
			// LockedMeInput method to display to get the user's file processing choice from console input
			choice = lockedMeUserInput.getFileProcessingChoiceFromUser();
			
			// switch/case statement to process each file processing choice
			switch(choice) {
			
			// case 1 is for listing all files in a directory
			case '1': 
				// call LockedMeConsole method to prompt user for directory path
				lockedMeConsole.displayEnterDirectoryPrompt();
				// call LockedMeUser method to get directory path from console user input
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				// call FileManager method to list all files in the directory
				fileManager.listAllFilesInDirectoryInASCOrder(directoryPath);
				break;
			
			// case 2 is for adding a new file to a directory
			case '2':
				// call LockedMeConsole method to prompt user for directory path
				lockedMeConsole.displayEnterDirectoryPrompt();
				// call LockedMeUser method to get directory path from console user input
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				// call LockedMeConsole method to prompt user for file name to add
				lockedMeConsole.displayEnterFileNamePrompt();
				// call LockedMeUserInput method to get file name from console user input
				fileName = lockedMeUserInput.getFileNameFromUser();
				
				// call LockedMeConsole method to prompt user for the number of lines to add to the new file that is being added
				lockedMeConsole.displayEnterNumFileContentLinesPrompt();
				// call LockedMeUserInput method to get the number of lines to add to the new file from console user input
				numLinesToAddToFile = lockedMeUserInput.getNumLinesInFileFromUser();
				
				// instantiate fileLines to an ArrayList to hold the lines to add to the file
				fileLines = new ArrayList<>();

				// if # of lines to add to file is > 0, then prompt user for each line and add it to the fileLines ArrayList
				if (numLinesToAddToFile > 0) {
					for (int i=1; i <= numLinesToAddToFile; i++) {
						lockedMeConsole.displayEnterFileContentPrompt(i);
						String line = lockedMeUserInput.getLineToAddToFileFromUser();
						fileLines.add(line);
					}
										 
				} else {
					System.out.println("You entered an invalid # of lines.  Terminating add file processing.");
					break;
				}
				
				// call fileManager method to add the new file with content to the directory specified by the user
				fileManager.addAFileToDirectory(directoryPath,fileName,numLinesToAddToFile,fileLines);
				
				break;
				
			// case 3 is for searching for a file in a directory
			case '3':
				lockedMeConsole.displayEnterDirectoryPrompt();
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				lockedMeConsole.displayEnterFileNamePrompt();
				fileName = lockedMeUserInput.getFileNameFromUser();

				break;
				
			// case 4 is for deleting a file in a directory
			case '4':
				lockedMeConsole.displayEnterDirectoryPrompt();
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				lockedMeConsole.displayEnterFileNamePrompt();
				fileName = lockedMeUserInput.getFileNameFromUser();

				// call FileManager method to delete a file from the directory specified 
				fileManager.deleteFileFromDirectory(directoryPath, fileName);
				
				break;
				
			// case 5 is for exiting file processing loop
			case '5':
				doFileProcessing = false;
				System.out.println("\n\t* * *     Exiting file processing.  Goodbye.    * * *\n");

				break;
			default:
				System.out.println("Invalid input.  Try again.");
			}
			
		}
		
		// perform clean up activities 
		
		// close the scanner object
		lockedMeUserInput.closeScanner();

		

	}
}
