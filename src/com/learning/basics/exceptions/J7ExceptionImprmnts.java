package com.learning.basics.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;

/*
 * If you are catching a lot of exceptions in a single try block,
 *  you will notice that catch block code looks very ugly and mostly consists of redundant code to log the error, 
 *  keeping this in mind Java 7 one of the feature was improved catch block where we can catch multiple exceptions in a single catch block. 
 *  
 *  The catch block with this feature looks like below:


catch(IOException | SQLException ex){
     logger.error(ex);
     throw new MyException(ex.getMessage());
}

 java 7 one of the improvement was try-with-resources where we can create a resource in the try statement itself and use it inside the try-catch block.
  When the execution comes out of try-catch block, runtime environment automatically close these resources. Sample of try-catch block with this improvement is:
 
try (MyResource mr = new MyResource()) {
            System.out.println("MyResource created in try-with-resources");
        } catch (Exception e) {
            e.printStackTrace();
        }
 */
public class J7ExceptionImprmnts {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader(
				"C:\\journaldev.txt"))) {
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * We can open multiple resources in try-with-resources statement separated by a semicolon. For example, we can write following code:
		 */
		try (BufferedReader br = new BufferedReader(new FileReader(
				"C:\\journaldev.txt"));
				java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(FileSystems.getDefault().getPath("C:\\journaldev.txt"), Charset.defaultCharset())) {
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}