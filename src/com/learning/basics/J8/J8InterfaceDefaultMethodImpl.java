package com.learning.basics.J8;

public class J8InterfaceDefaultMethodImpl implements J8InterfaceDefaultMethod1, J8InterfaceDefaultMethod2 {

	@Override
	public void method2(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1(String s1) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * Its not mandatory to override this method
	 * 
	 */
	@Override
	public void logMessage(String message) {
		
		//J8InterfaceDefaultMethod1.super.logMessage(message);
		//J8InterfaceDefaultMethod2.super.logMessage(message);
		System.out.println("logging the message from J8InterfaceDefaultMethodImpl"+message);
		
	}
	
	public static void main(String args[]){
		
		J8InterfaceDefaultMethodImpl impl = new J8InterfaceDefaultMethodImpl();
		impl.logMessage("ok done!");
	}
	
	
	
	

}
