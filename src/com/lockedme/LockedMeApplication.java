package com.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class LockedMeApplication {

	
	public static void main(String[] args) {
		
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
		int numLinesInFile = 0;
		// collection variable to hold the list of file names in a directory
		List<String> fileNames = new ArrayList<>(); 
		
		
		boolean doFileProcessing = true;
		while(doFileProcessing) {

			lockedMeConsole.displayMenu();
			
			lockedMeConsole.displayEnterChoicePrompt();
			choice = lockedMeUserInput.getFileProcessingChoiceFromUser();
			
			switch(choice) {
			
			case '1': 
				lockedMeConsole.displayEnterDirectoryPrompt();
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				fileManager.listAllFilesInDirectory(directoryPath);
				break;
			case '2':
				lockedMeConsole.displayEnterDirectoryPrompt();
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				lockedMeConsole.displayEnterFileNamePrompt();
				fileName = lockedMeUserInput.getFileNameFromUser();
				
				String path = directoryPath.getAbsolutePath() + "/" + fileName;
				File f = new File(path);

				
				lockedMeConsole.displayEnterNumFileContentLinesPrompt();
				numLinesInFile = lockedMeUserInput.getNumLinesInFileFromUser();
				int cnt = numLinesInFile;
				if (cnt > 0) {
					for (int i=1; i <= cnt; i++) {
						lockedMeConsole.displayEnterFileContentPrompt(i++);
					}
				} else {
					System.out.println("You entered an invalid # of lines value.  Terminating file processing.");
					break;
				}
				
				break;
			case '3':
				lockedMeConsole.displayEnterDirectoryPrompt();
				directoryPath = lockedMeUserInput.getDirectoryPathFromUser();	
				lockedMeConsole.displayEnterFileNamePrompt();
				fileName = lockedMeUserInput.getFileNameFromUser();

				break;
			case '4':
				break;
			case '5':
				break;
			default:
				
			}
			doFileProcessing = false;
		}

			
		
//		final Scanner sc = new Scanner(System.in);
//		System.out.println("\n\nEnter choice: ");
//		Character choice = sc.nextLine().charAt(0);		
//		System.out.println("Enter the file path: ");
//		String filePath = sc.nextLine();
//		System.out.println("Enter the file name: ");
//		String fileName = sc.nextLine();
		
		
		System.out.println("\n\n------------------------------------------------");
		System.out.println("You chose the following:");
		System.out.println("choice: " + choice);
		System.out.println("directoryPath: " + directoryPath.getAbsolutePath());
		System.out.println("fileName: " + fileName);

	}
}
