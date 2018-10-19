package com.learning.basics.generics;

/*
 * Java Generic Type
	Java Generic Type Naming convention helps us understanding code easily and having a naming convention is one of the best practices of java programming language. So generics also comes with it’s own naming conventions. Usually type parameter names are single, uppercase letters to make it easily distinguishable from java variables. The most commonly used type parameter names are:
	
	E – Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
	K – Key (Used in Map)
	N – Number
	T – Type
	V – Value (Used in Map)
	S,U,V etc. – 2nd, 3rd, 4th types
 */

/*
 * Java Generic Method
	Sometimes we don’t want whole class to be parameterized, in that case we can create java generics method.
	Since constructor is a special kind of method, we can use generics type in constructors too.
 */

public class CustomGenericTypeEx<T> {
	
	private T t;
	

	public T getT() {
		return t;
	}


	public void setT(T t) {
		this.t = t;
	}


	public static void main(String[] args) {
		
		CustomGenericTypeEx<String> type = new CustomGenericTypeEx<>();
		type.setT("Tausif");
		
		CustomGenericTypeEx type1 = new CustomGenericTypeEx<>();
		type1.setT("Tausif");
		type1.setT(10);
	}

}
