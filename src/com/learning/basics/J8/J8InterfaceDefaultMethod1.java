package com.learning.basics.J8;

public interface J8InterfaceDefaultMethod1 {
	void method1(String s1);
	
	
	/* its not mandatory to implement this in the implementing class */
	
	default void logMessage(String message){
		System.out.println("Logging the message from J8InterfaceDefaultMethod1"+message);
	}
	
}
