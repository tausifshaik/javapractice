package com.learning.basics.JavaIo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
	 * 2. FileOutputStream.write(byte[] b)
	  If you want to create a new file and at the same time write some data into it, 
	  you can use FileOutputStream write method. Below is a simple code snippet to show it’s usage.
	  The rules for absolute path and relative path discussed above is applicable in this case too.
	 */

public class CreateFile1 {
	public static void main(String [] args) throws IOException{
		String fileData = "Pankaj Kumar";
		FileOutputStream fos = new FileOutputStream("name.txt");
		fos.write(fileData.getBytes());
		fos.flush();
		fos.close();
		
		/*
		 * 3.Java NIO Files.write()
		We can use Java NIO Files class to create a new file and write some data into it. This is a good option because we don’t have to worry about closing IO resources.
		 */
		String fileData1 = "Pankaj Kumar";
		Files.write(Paths.get("name1.txt"), fileData1.getBytes());
	}
}
