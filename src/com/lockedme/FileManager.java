package com.lockedme;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The FileManager class encapsulates file handling functions for the LockedMeApplication
 * @author Binu Thankachan
 *
 */
public class FileManager {
	
	private static List<String> fileNames; 
	
	/**
	 * The directoryExists method checks whether the input path exists or not.
	 * 
	 * @param directoryPath (File)
	 * @return boolean
	 */
	public static boolean directoryExists(File directoryPath) {
		// gets directory path
		Path path = Paths.get(directoryPath.getAbsolutePath());
		boolean exists = true;
		// checks if directory exists
		if (!Files.exists(path)) {
	    	exists = false; 			
		}
		return exists;
	}
	
	public static boolean fileExists(File filePath) {
		// gets file path
		Path path = Paths.get(filePath.getAbsolutePath());
		boolean exists = true;
		// checks if file exists
		if (!Files.exists(path)) {
	    	exists = false; 			
		}
		return exists;		
		
	}
	
	/**
	 * The listAllFilesInDirectoryInASCOrder method encapsulates the logic to list all files in a user specified directory in ascending order.
	 * 
	 * @param directoryPath (File)
	 * @return void
	 */
	public static void listAllFilesInDirectoryInASCOrder(File directoryPath) {
		fileNames = new ArrayList<>(); 
		
		// check if directory exists before proceeding
		boolean dirExists = directoryExists(directoryPath);
		if (!dirExists) {
	    	System.out.println("\n\n\t\t* * *     No such directory exists.  Terminating directory list processing.     * * *\n");
	    	return;
		}
		
		// initialize a path object before passing it to Files.newDirectoryStream
		Path path = Paths.get(directoryPath.getAbsolutePath());
		
		// use Files.newDirectoryStream to stream the list of files in the directory
	    try(DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.*")){
	        
	    	// iterate through the stream and save each file to the fileNames ArrayList in lowercase format for sorting
	        for (Path entry: stream){
	            fileNames.add(entry.getFileName().toString());
	        }
	    }
	    // catch exceptions from most specific to least specific
	    catch (NoSuchFileException e) {
	    	System.out.println("\n\n\t\t* * *     No such file found:  " + e.getMessage() + "     * * *\n");
	    	return;   	
	    }
	    catch (IOException e){
	    	System.out.println("\n\n\t\t* * *     An I/O error occurred while retrieving file:  " + e.getMessage() + "     * * *\n");
	    	return;         
	    }		
	    catch (Exception e){
	    	System.out.println("\n\n\t\t* * *     An error occurred while retrieving file:  " + e.getMessage() + "     * * *\n");
	    	return;	         
	    }		
		
		// call Collections class sort method to sort the ArrayList in ascending order
		Collections.sort(fileNames);
		System.out.println("\n\tList of files in the specified directory in case sensitive ascending order:\n");
		// for loop to iterate through fileNames collection and display each file name
		for (int i=0; i < fileNames.size(); i++) {
			System.out.println("\t\t" + fileNames.get(i));
		}
		
		System.out.println("\n\n\t\t* * *     All files in directory successfully listed     * * *\n");
		return;
	}

	/**
	 * The addAFileToDirectory method encapsulates logic to add a new file with content to a directory
	 * 
	 * @param directoryPath (File)
	 * @param fileName (String)
	 * @param numLinesToAddToFile (int)
	 * @param fileLines (List<String>)
	 * @return void
	 * @throws IOException
	 */
	public static void addAFileToDirectory(File directoryPath,String fileName,int numLinesToAddToFile,List<String> fileLines) throws IOException {
		
		// check if directory exists before proceeding
		boolean dirExists = directoryExists(directoryPath);
		if (!dirExists) {
	    	System.out.println("\n\n\t\t* * *     No such directory exists:  " + directoryPath.getAbsolutePath() + "  Terminating add file processing.     * * *\n");
	    	return;
		}
		// build path string variable with directory plus filename
		String path = directoryPath.getAbsolutePath() + "/" + fileName;
		// instantiate a fout File object using path
		File fout = new File(path);
		
		
		
		try {
			if (fout.exists()) {
				System.out.println("\n\n\t\t* * *     CANNOT CREATE FILE.  THE FILE ALREADY EXISTS.     * * *\n");
				return;
		
			} else {
				
				fout.getParentFile().mkdirs(); 
				// create the new file in the directory
				//fout.createNewFile();
				fout.getCanonicalFile().createNewFile();

				// create file output stream object instantiated using fout 
				FileOutputStream fos = new FileOutputStream(fout);
			 
				// create buffered writer object passing new output stream writer object instantiated using fos
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			 
				// iterate through fileLines and write each line to the new file
				for (int i = 0; i < numLinesToAddToFile; i++) {
					String line = fileLines.get(i);
					bw.write(line);
					bw.newLine();
				}
			 
				// close buffered writer object at the end
				bw.close();
				System.out.println("\n\n\t\t* * *     FILE CREATED SUCCESSFULLY     * * *\n");
				return;
				
			}
		}
		// catch exceptions in most specific to least specific hierarchy
        catch(NoSuchFileException e)
        {
            System.out.println("\n\n\t\tNo such file exists");
        }
        catch(IOException e)
        {
            System.out.println("\n\n\t\tI/O error occurred.");
        }
        catch(Exception e)
        {
            System.out.println("\n\n\t\tAn error occurred during add file processing.");
        }

		
		return;
		
	}
	
	/**
	 * The searchForFileInDirectory method encapsulates logic to search for a file in a directory using case sensitivity.
	 * 
	 * @param directoryPath (File)
	 * @param fileName (String)
	 * @return void
	 */
	public static void searchForFileInDirectory(File directoryPath,String fileName) {
		
		// check if directory exists before proceeding
		boolean dirExists = directoryExists(directoryPath);
		if (!dirExists) {
	    	System.out.println("\n\n\t\t* * *     No such directory exists:  " + directoryPath.getAbsolutePath() + "  Terminating search file processing.     * * *\n");
	    	return;
		}
		
		// build path string variable with directory plus filename
		String path = directoryPath.getAbsolutePath() + "/" + fileName;
		// instantiate a fout File object using path
		File fout = new File(path);
		
		try {
			if (fout.exists() && fout.getCanonicalFile().getName().equals(fout.getName())) {
				System.out.println("\n\n\t\t* * *     FILE FOUND     * * *\n");
		
			} else {
				System.out.println("\n\n\t\t* * *     FILE NOT FOUND     * * *\n");
				
			}
		}
		catch(Exception e) {
			System.out.println("\n\n\t\tAn error occurred while searching for the file.  No file found.");
			return;
		}
		
		return;
	}
	
	/**
	 * The deleteFileFromDirectory method encapsulates logic to delete a file from a directory.
	 * 
	 * @param directoryPath (File)
	 * @param fileName (String)
	 * @return void
	 */
	public static void deleteFileFromDirectory(File directoryPath,String fileName) {
		
		// check if directory exists before proceeding
		boolean dirExists = directoryExists(directoryPath);
		if (!dirExists) {
	    	System.out.println("\n\n\t\t* * *     No such directory exists:  " + directoryPath.getAbsolutePath() + "  Terminating delete file processing.     * * *\n");
	    	return;
		}
		
		// build path string variable with directory plus filename
		String path = directoryPath.getAbsolutePath() + "/" + fileName;
		// instantiate a fout File object using path
		File fout = new File(path);
		
		try {
			if (fout.exists() && fout.getCanonicalFile().getName().equals(fout.getName())) {
				fout.delete();
				System.out.println("\n\n\t\t* * *     FILE SUCCESSFULLY DELETED     * * *\n");
				return;
		
			} else {
				System.out.println("\n\n\t\t* * *     FILE NOT FOUND     * * *\n");
				return;
				
			}
		}
		// catch exceptions in most specific to least specific hierarchy
        catch(NoSuchFileException e)
        {
            System.out.println("\n\n\t\tNo such file exists");
        }
        catch(IOException e)
        {
            System.out.println("\n\n\t\tI/O error occurred.");
        }
        catch(Exception e)
        {
            System.out.println("\n\n\t\tAn error occurred during delete file processing.");
        }

	}
}
