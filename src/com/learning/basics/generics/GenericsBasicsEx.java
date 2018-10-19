package com.learning.basics.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsBasicsEx {

	/*
	 * Generics was added in Java 5 to provide compile-time type checking and removing risk of ClassCastException that was common while working with collection classes. 
	 * The whole collection framework was re-written to use generics for type-safety. 
	 */
	
	
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("abc");
		list.add(new Integer(5)); //OK

		for(Object obj : list){
			//type casting leading to ClassCastException at runtime
		    String str=(String) obj; 
		}
		
		List<String> list1 = new ArrayList<String>(); // java 7 ? List<String> list1 = new ArrayList<>(); 
		list1.add("abc");
		//list1.add(new Integer(5)); //compiler error

		for(String str : list1){
		     //no type casting needed, avoids ClassCastException
		}
	}

}
