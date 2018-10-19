package com.learning.basics.J8;

public interface J8InterfaceDefaultMethod2 {
	void method2(String s);
	
	default void logMessage(String message){
		System.out.println("logging message from J8InterfaceDefaultMethod2"+message);
	}

}
