package com.learning.basics.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionBasics {
	
	/*
	 * Java being an object oriented programming language, whenever an error occurs while executing a statement,
	 * creates an exception object and then the normal flow of the program halts and JRE tries to find someone that can handle the raised exception. 
	 * The exception object contains a lot of debugging information such as method hierarchy, line number where the exception occurred, type of exception etc.
	 * When the exception occurs in a method, the process of creating the exception object and handing it over to runtime environment is called “throwing the exception”.
	 */
	
	/*
	 * Java Exception Handling Keywords
	 * throw – We know that if any exception occurs, an exception object is getting created and then Java runtime starts processing to handle them.
	 *  Sometime we might want to generate exception explicitly in our code, 
	 *  for example in a user authentication program we should throw exception to client if the password is null. throw keyword is used to throw exception to the runtime to handle it.
	   
	   throws – When we are throwing any exception in a method and not handling it, 
	   then we need to use throws keyword in method signature to let caller program know the exceptions that might be thrown by the method. 
	   The caller method might handle these exceptions or propagate it to it’s caller method using throws keyword.
	    We can provide multiple exceptions in the throws clause and it can be used with main() method also.
       
       try-catch – We use try-catch block for exception handling in our code. try is the start of the block and catch is at the end of try block to handle the exceptions. 
       We can have multiple catch blocks with a try and try-catch block can be nested also. catch block requires a parameter that should be of type Exception.
       
       finally – finally block is optional and can be used only with try-catch block. Since exception halts the process of execution, 
       we might have some resources open that will not get closed, so we can use finally block. finally block gets executed always, whether exception occurred or not.
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try{
			testException(-5);
			testException(-10);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			System.out.println("Releasing resources");			
		}
		testException(15);
	}
	public static void testException(int i) throws FileNotFoundException, IOException{
		if(i < 0){
			FileNotFoundException myException = new FileNotFoundException("Negative Integer "+i);
			throw myException;
		}else if(i > 10){
			throw new IOException("Only supported for index 0 to 10");
		}

	}
}
