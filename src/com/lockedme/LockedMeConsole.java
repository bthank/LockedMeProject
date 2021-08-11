package com.lockedme;


/**
 * 
 * The  LockedMeConsle class encapsulates console user prompt handling for the LockedMeApplication
 * @author Binu T
 *
 */
public class LockedMeConsole {
	
	
	public static void displayMenu() {
		
		System.out.println("\n===============================================================\n");
		System.out.println("\t\t\tLOCKEDME.COM by Binu Thankachan");
		System.out.println("\n===============================================================");
		System.out.println("\nPlease select your file processing choice:\n");
		System.out.println("1. List files in a directory in ascending order");
		System.out.println("2. Add a file to a directory  (case sensitive add)");
		System.out.println("3. Search for a file in a directory  (case sensitive search)");
		System.out.println("4. Delete a file from a directory  (case sensitive delete)");
		System.out.println("5. Exit file processing");
		System.out.println("===============================================================\n");
		
	}
	
	public static void displayEnterChoicePrompt() {
		
		System.out.println("Enter choice (1-5): ");
	}
	
	public static void displayEnterDirectoryPrompt() {
		
		System.out.println("Enter directory file path: ");
	}
	
	public static void displayEnterFileNamePrompt() {
		
		System.out.println("Enter file name: ");
	}
	
	public static void displayEnterNumFileContentLinesPrompt() {
		
		System.out.println("Enter # of lines to add to file: ");
	}
	
	public static void displayEnterFileContentPrompt(int lineNum) {
		
		System.out.println("Enter line " + lineNum + ": ");
	}	 
	
	

}
