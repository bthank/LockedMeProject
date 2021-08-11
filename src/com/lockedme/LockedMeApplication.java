package com.lockedme;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The  LockedMeApplication class is the main entry point for the application
 * @author Binu T
 *
 *
 */
public class LockedMeApplication {

	
	public static void main(String[] args) throws IOException {
		

		// instantiating LockedMeUserInput object which encapsulates user input handling
		LockedMeUserInput lockedMeUserInput = new LockedMeUserInput();

		
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
		
		// variable holding a sentinal value determining when to continue in or exit loop
		boolean doFileProcessing = true;
		while(doFileProcessing) {

			// LockedMeConsole method to display main menu for the application
			LockedMeConsole.displayMenu();
			
			// LockedMeConsole method to display a prompt for the user to enter their file processing choice
			LockedMeConsole.displayEnterChoicePrompt();
			// LockedMeInput method to display to get the user's file processing choice from console input
			choice = lockedMeUserInput.getFileProcessingChoiceFromUser();
			
			// switch/case statement to process each file processing choice
			switch(choice) {
			
			// case 1 is for listing all files in a directory
			case '1': 
				// call LockedMeConsole method to prompt user for directory path
				LockedMeConsole.displayEnterDirectoryPrompt();
				// call LockedMeUser method to get directory path from console user input
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				// call FileManager method to list all files in the directory
				FileManager.listAllFilesInDirectoryInASCOrder(directoryPath);
				break;
			
			// case 2 is for adding a new file to a directory
			case '2':
				// call LockedMeConsole method to prompt user for directory path
				LockedMeConsole.displayEnterDirectoryPrompt();
				// call LockedMeUser method to get directory path from console user input
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				// call LockedMeConsole method to prompt user for file name to add
				LockedMeConsole.displayEnterFileNamePrompt();
				// call LockedMeUserInput method to get file name from console user input
				fileName = lockedMeUserInput.getFileNameFromUser();
				
				// call LockedMeConsole method to prompt user for the number of lines to add to the new file that is being added
				LockedMeConsole.displayEnterNumFileContentLinesPrompt();
				// call LockedMeUserInput method to get the number of lines to add to the new file from console user input
				numLinesToAddToFile = lockedMeUserInput.getNumLinesInFileFromUser();
				
				// instantiate fileLines to an ArrayList to hold the lines to add to the file
				fileLines = new ArrayList<>();

				// if # of lines to add to file is > 0, then prompt user for each line and add it to the fileLines ArrayList
				if (numLinesToAddToFile > 0) {
					for (int i=1; i <= numLinesToAddToFile; i++) {
						LockedMeConsole.displayEnterFileContentPrompt(i);
						String line = lockedMeUserInput.getLineToAddToFileFromUser();
						fileLines.add(line);
					}
										 
				} else {
					System.out.println("You entered an invalid # of lines.  Terminating add file processing.");
					break;
				}
				
				// call fileManager method to add the new file with content to the directory specified by the user
				FileManager.addAFileToDirectory(directoryPath,fileName,numLinesToAddToFile,fileLines);
				
				break;
				
			// case 3 is for searching for a file in a directory
			case '3':
				LockedMeConsole.displayEnterDirectoryPrompt();
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				LockedMeConsole.displayEnterFileNamePrompt();
				fileName = lockedMeUserInput.getFileNameFromUser();
				
				FileManager.searchForFileInDirectory(directoryPath, fileName);

				break;
				
			// case 4 is for deleting a file in a directory
			case '4':
				LockedMeConsole.displayEnterDirectoryPrompt();
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				LockedMeConsole.displayEnterFileNamePrompt();
				fileName = lockedMeUserInput.getFileNameFromUser();

				// call FileManager method to delete a file from the directory specified 
				FileManager.deleteFileFromDirectory(directoryPath, fileName);
				
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
		

		
		// close the scanner object
		lockedMeUserInput.closeScanner();

		

	}
}
