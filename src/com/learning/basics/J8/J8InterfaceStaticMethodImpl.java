package com.learning.basics.J8;

public class J8InterfaceStaticMethodImpl implements J8InterfaceStaticMethod {

	//@Override -->  this will throw compilation error since you cannot override 
	public boolean isNull(String str){
		System.out.println("Impl isNull");
		return str == null ? true : "".equals(str) ? true : false ;
	}
	
	public static void main(String[] args) {
		
		J8InterfaceStaticMethodImpl impl = new J8InterfaceStaticMethodImpl();
		impl.print("abc");
		impl.isNull(null);
	}

	//Java interface static method is visible to interface methods only, 
	//if we remove the isNull() method from the MyDataImpl class, we won’t be able to use it for the MyDataImpl object.
}
