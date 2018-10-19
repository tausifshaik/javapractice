package com.learning.basics.JavaIo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * ObjectOutputStream in Java can be used to convert an object to OutputStream. 
 * The process of converting object to stream is called serialization in java.
 * 
 * Once an object is converted to Output Stream, it can be saved to file or database, send over the network or used in socket connections.
 * So we can use FileOutputStream to write Object to file.
 */
public class SerializationEx {
	public static void main(String[] args) {
		Employee emp = new Employee("Pankaj");

		emp.setAge(35);
		emp.setGender("Male");
		emp.setRole("CEO");
		System.out.println(emp);
		
		try {
			FileOutputStream fos = new FileOutputStream("EmployeeObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(emp);
			System.out.println("Done");
			// closing resources
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
