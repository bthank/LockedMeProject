package com.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class LockedMeApplication {

	
	public static void main(String[] args) {
		
		LockedMeConsole lockedMeConsole = new LockedMeConsole();
		LockedMeUserInput lockedMeUserInput = new LockedMeUserInput();
		
		char choice = ' ';
		File directoryPath = null;
		String fileName = "";
		int numLinesInFile = 0;
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
				File[] files = directoryPath.listFiles();
				for(File file: files) {
					fileNames.add(file.getName());
				}
				System.out.println("\n\tList of files and directories in the specified directory:\n");
				for (int i=0; i < fileNames.size(); i++) {
					System.out.println("\t\t" + fileNames.get(i));
				}
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
