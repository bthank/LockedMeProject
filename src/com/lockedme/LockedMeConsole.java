package com.lockedme;


/**
 * 
 * The  LockedMeConsle class encapsulates console user prompt handling for the LockedMeApplication
 * @author Binu Thankachan
 *
 */
public class LockedMeConsole {
	
	/**
	 * The displayMenu method displays the main menu for the LOCKEDME.COM application.
	 * @return void 
	 * 
	 */
	public static void displayMenu() {
		
		System.out.println("\n===============================================================\n");
		System.out.println("\t\t\tLOCKEDME.COM by Binu Thankachan");
		System.out.println("\n===============================================================");
		System.out.println("\nPlease select your file processing choice:\n");
		System.out.println("1. List files in a directory in ascending order");
		System.out.println("2. Add a file to a directory");
		System.out.println("3. Search for a file in a directory  (case sensitive search)");
		System.out.println("4. Delete a file from a directory  (case sensitive delete)");
		System.out.println("5. Exit file processing");
		System.out.println("===============================================================\n");
		
	}
	
	/**
	 * The displayEnterChoicePrompt method displays the prompt for entering the user's menu choice.
	 * @return void 
	 */
	public static void displayEnterChoicePrompt() {
		
		System.out.println("Enter choice (1-5): ");
	}
	
	/**
	 * The displayEnterDirectoryPrompt method displays the prompt for entering the directory to process.
	 * @return void  
	 */
	public static void displayEnterDirectoryPrompt() {
		
		System.out.println("Enter directory file path: ");
	}
	
	/**
	 * The displayEnterFileNamePrompt method displays the prompt for entering the file to process.
	 * @return void   
	 */
	public static void displayEnterFileNamePrompt() {
		
		System.out.println("Enter file name: ");
	}
	
	/**
	 * The displayEnterNumFileContentLinesPrompt method displays the prompt for entering the number of lines of content to add to a file.
	 * @return void    
	 */
	public static void displayEnterNumFileContentLinesPrompt() {
		
		System.out.println("Enter # of lines to add to file: ");
	}

	/**
	 * The displayEnterFileContentPrompt method displays the prompt for entering a line to add to a file. 
	 * @param lineNum (int)
	 * @return void    
	 */
	public static void displayEnterFileContentPrompt(int lineNum) {
		
		System.out.println("Enter line " + lineNum + ": ");
	}	 
	
	

}
