package com.learning.basics.JavaIo;

import java.io.File;

public class DeleteFile {
	/*
	 * Java File delete() method can be used to delete files or empty directory/folder in java. 
	 * Java file delete method returns true if file gets deleted and returns false if file doesn’t exist.
	 * 
	 * If you are trying to delete a directory, it checks java File delete() method check if it’s empty or not.
	 *  If directory is empty, it gets deleted else delete() method doesn’t do anything and return false. 
	 *  So in this case, we have to recursively delete all the files and then the empty directory.
	 *  
	 *  Another way to delete a non-empty directory is by using Files.walkFileTree() method. 
	 *  In this method, we can process all the files one by one, and call delete method on single files.
	 */
		public static void main(String[] args) {
	        //absolute file name with path
	        File file = new File("/Users/tshg9/file.txt");
	        if(file.delete()){
	            System.out.println("/Users/tshg9/file.txt File deleted");
	        }else System.out.println("File /Users/tshg9/file.txt doesn't exists");
	        
	        //file name only
	        file = new File("file.txt");
	        if(file.delete()){
	            System.out.println("file.txt File deleted from Project root directory");
	        }else System.out.println("File file.txt doesn't exists in project root directory");
	        
	        //relative path
	        file = new File("tmp/file.txt");
	        if(file.delete()){
	            System.out.println("tmp/file.txt File deleted from Project root directory");
	        }else System.out.println("File tmp/file.txt doesn't exists in project root directory");
	        
	        //delete empty directory
	        file = new File("tmp");
	        if(file.delete()){
	            System.out.println("tmp directory deleted from Project root directory");
	        }else System.out.println("tmp directory doesn't exists or not empty in project root directory");
	        
	        //try to delete directory with files
	        file = new File("/Users/tshg9/project");
	        if(file.delete()){
	            System.out.println("/Users/tshg9/project directory deleted from Project root directory");
	        }else System.out.println("/Users/tshg9/project directory doesn't exists or not empty");
	    }

	}

