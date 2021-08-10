package com.lockedme;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {
	
	private List<String> fileNames; 
	
	
	public boolean directoryExists(File directoryPath) {
		Path path = Paths.get(directoryPath.getAbsolutePath());
		boolean exists = true;
		if (!Files.exists(path)) {
	    	exists = false; 			
		}
		return exists;
	}
	
	public void listAllFilesInDirectoryInASCOrder(File directoryPath) {
		fileNames = new ArrayList<>(); 
		
		// check if directory exists before proceeding
		boolean dirExists = directoryExists(directoryPath);
		if (!dirExists) {
	    	System.out.println("\n\t* * *     No such directory exists:  " + directoryPath.getAbsolutePath() + "Terminating directory list processing.     * * *\n");
	    	return;
		}
		
		
		Path path = Paths.get(directoryPath.getAbsolutePath());
		
	    try(DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.*")){
	        
	        for (Path entry: stream){
	 //           log.info("working on file " + entry.getFileName());

	            fileNames.add(entry.getFileName().toString());
	        }
	    }
	    catch (NoSuchFileException e) {
	    	System.out.println("\n\t* * *     No such file found:  " + e.getMessage() + "     * * *\n");
	    	return;
	    	
	    }
	    catch (IOException e){
	    	System.out.println("\n\t* * *     An I/O error occurred while retrieving file:  " + e.getMessage() + "     * * *\n");
	    	return;
	         
	    }		
	    catch (Exception e){
	    	System.out.println("\n\t* * *     An error occurred while retrieving file:  " + e.getMessage() + "     * * *\n");
	    	return;
	         
	    }		
		
		
//		// retrieving all files into a File array
//		File[] files = directoryPath.listFiles();
//		// for loop to iterate through files array and get the individual file names and save them in fileNames collection
//		for(File file: files) {
//			fileNames.add(file.getName());
//		}
		// call Collections class sort method to sort the ArrayList in ascending order
		Collections.sort(fileNames);
		System.out.println("\n\tList of files and folders in the specified directory in ascending order:\n");
		// for loop to iterate through fileNames collection and display each file name
		for (int i=0; i < fileNames.size(); i++) {
			System.out.println("\t\t" + fileNames.get(i));
		}
		
		System.out.println("\n\t* * *     All files in directory successfully listed     * * *\n");
	}

	public void addAFileToDirectory(File directoryPath,String fileName,int numLinesToAddToFile,List<String> fileLines) throws IOException {
		
		// check if directory exists before proceeding
		boolean dirExists = directoryExists(directoryPath);
		if (!dirExists) {
	    	System.out.println("\n\t* * *     No such directory exists:  " + directoryPath.getAbsolutePath() + "Terminating add file processing.     * * *\n");
	    	return;
		}
		
		String path = directoryPath.getAbsolutePath() + "/" + fileName;
		File fout = new File(path);
		fout.getParentFile().mkdirs(); 
		fout.createNewFile();

		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		for (int i = 0; i < numLinesToAddToFile; i++) {
			String line = fileLines.get(i);
			bw.write(line);
			bw.newLine();
		}
	 
		bw.close();
		
		System.out.println("\n\t* * *     File successfully added.     * * *\n");
		
	}
	
	public void searchForFileInDirectory(File directoryPath,String fileName) {
		
		// check if directory exists before proceeding
		boolean dirExists = directoryExists(directoryPath);
		if (!dirExists) {
	    	System.out.println("\n\t* * *     No such directory exists:  " + directoryPath.getAbsolutePath() + "Terminating search file processing.     * * *\n");
	    	return;
		}
		
		
		
		System.out.println("\n\t* * *     File successfully found.     * * *\n");
	}
	
	
	public void deleteFileFromDirectory(File directoryPath,String fileName) {
		
		// check if directory exists before proceeding
		boolean dirExists = directoryExists(directoryPath);
		if (!dirExists) {
	    	System.out.println("\n\t* * *     No such directory exists:  " + directoryPath.getAbsolutePath() + "Terminating delete file processing.     * * *\n");
	    	return;
		}
		

		String path = directoryPath.getAbsolutePath() + "/" + fileName;
		try
        {
            Files.deleteIfExists(Paths.get(path));
        }
        catch(NoSuchFileException e)
        {
            System.out.println("No such file/directory exists");
        }
        catch(DirectoryNotEmptyException e)
        {
            System.out.println("Directory is not empty.");
        }
        catch(IOException e)
        {
            System.out.println("Invalid permissions.");
        }
		
		System.out.println("\n\t* * *     File successfully deleted.     * * *\n");
	}
}
