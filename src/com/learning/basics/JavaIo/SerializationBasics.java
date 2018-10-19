package com.learning.basics.JavaIo;

import java.io.IOException;

/*
 * Serialization in Java allows us to convert an Object to stream that we can send over the network or save it as file or store in DB for later usage.
 *  Deserialization is the process of converting Object stream to actual Java Object to be used in our program. 
 *  Serialization in Java seems very easy to use at first but it comes with some trivial security and integrity issues 
 */

/*
 * 1.Serializable in Java
If you want a class object to be serializable, all you need to do it implement the java.io.Serializable interface. 
Serializable in java is a marker interface and has no fields or methods to implement. 
It’s like an Opt-In process through which we make our classes serializable.
 Serialization in java is implemented by ObjectInputStream and ObjectOutputStream, so all we need is a wrapper over them to either save it to file or send it over the network
 */
public class SerializationBasics {
	public static void main(String[] args) {
		String fileName="employee.ser";
		Employee emp = new Employee("Pankaj");

		emp.setAge(35);
		emp.setGender("Male");
		emp.setRole("CEO");
		
		//serialize to file
		try {
			SerializationUtil.serialize(emp, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		Employee empNew = null;
		try {
			empNew = (Employee) SerializationUtil.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("emp Object::"+emp);
		System.out.println("empNew Object::"+empNew);
	}
	
	/*
	 * Since Role is a transient variable, it’s value was not saved to file and hence not retrieved in the new object. 
	 * Similarly static variable values are also not serialized since they belongs to class and not object.
	 */
}

/*
Java Serialization Methods
We have seen that serialization in java is automatic and all we need is implementing Serializable interface. 
The implementation is present in the ObjectInputStream and ObjectOutputStream classes. 
But what if we want to change the way we are saving data, for example we have some sensitive information in the object and before saving/retrieving we want to encrypt/decrypt it. 
That’s why there are four methods that we can provide in the class to change the serialization behavior.

If these methods are present in the class, they are used for serialization purposes.

readObject(ObjectInputStream ois): If this method is present in the class, ObjectInputStream readObject() method will use this method for reading the object from stream.
writeObject(ObjectOutputStream oos): If this method is present in the class, ObjectOutputStream writeObject() method will use this method for writing the object to stream. 
One of the common usage is to obscure the object variables to maintain data integrity.
Object writeReplace(): If this method is present, then after serialization process this method is called and the object returned is serialized to the stream.
Object readResolve(): If this method is present, then after deserialization process, this method is called to return the final object to the caller program.
 One of the usage of this method is to implement Singleton pattern with Serialized classes. Read more at Serialization and Singleton.
*/