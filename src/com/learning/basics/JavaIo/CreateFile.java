package com.learning.basics.JavaIo;

import java.io.File;
import java.io.IOException;

/*
 * Creating a file is a very common IO operation.
 * Today we will look into different ways to create file in java
 * 
 * 1.File.createNewFile():
 * java.io.File class can be used to create a new File in Java. When we initialize File object,
 *  we provide the file name and then we can call createNewFile() method to create new file in Java.
File createNewFile() method returns true if new file is created and false if file already exists.
This method also throws java.io.IOException when it’s not able to create the file. The files created is empty and of zero bytes.

When we create the File object by passing file name, it can be with absolute path, or we can only provide the file name or we can provide relative path.

For non-absolute path, File object tries to locate files in the project root directory.
If we run the program from command line, for non-absolute path, File object tries to locate files from the current directory.
While creating the file path, we should use System property file.separator to make our program platform independent.
 */
public class CreateFile {

		public static void main(String[] args) throws IOException {
	        String fileSeparator = System.getProperty("file.separator");
	        
	        //absolute file name with path
	        String absoluteFilePath = fileSeparator+"Users"+fileSeparator+"tshg9"+fileSeparator+"file.txt";
	        File file = new File(absoluteFilePath);
	        if(file.createNewFile()){
	            System.out.println(absoluteFilePath+" File Created");
	        }else System.out.println("File "+absoluteFilePath+" already exists");
	        
	        //file name only
	        file = new File("file.txt");
	        if(file.createNewFile()){
	            System.out.println("file.txt File Created in Project root directory");
	        }else System.out.println("File file.txt already exists in project root directory");
	        
	        //relative path
	        String relativePath = "tmp"+fileSeparator+"file.txt";
	        file = new File(relativePath);
	        if(file.createNewFile()){
	            System.out.println(relativePath+" File Created in Project root directory");
	        }else System.out.println("File "+relativePath+" already exists in project root directory");
	    }
		/*
		 * or relative path, it throws IOException because tmp directory is not present in project root folder.
		 * So it’s clear that createNewFile() just tries to create the file and any directory either absolute or relative should be present already, else it throws IOException.
		 */
	}


