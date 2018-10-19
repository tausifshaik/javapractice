package com.learning.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J9Features {
	
	/* Oracle Corp has introduced some convenient factory methods to create Immutable List, Set, Map and Map.Entry objects. 
		These utility methods are used to create empty or non-empty Collection objects.
	*
	*
	* However these Collections.unmodifiableXXX methods are very tedious and verbose approach. 
	* To overcome those shortcomings, Oracle corp has added couple of utility methods to List, Set and Map interfaces.

	* List and Set interfaces have “of()” methods to create an empty or no-empty Immutable List or Set objects :
	
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//empty immmutable list
		List immutableList = List.of();
		
		
	//non empty immutable list
		List nonEmptyImmutableList = List.of("one","two","three");
		
		//Map has two set of methods: 
		// 1. of() methods and 
		// 2.ofEntries() methods to create an Immutable Map object and an Immutable Map.Entry object respectively.
		
		//empty
		Map emptyImmutableMap = Map.of();
		//non empty
		Map nonemptyImmutableMap = Map.of(1, "one", 2, "two", 3, "three");
		
		
		//::::::::::::::LIST & SET are similar:::::::::::::::::::::::::
		
		//preJava8
		List<String> emptyList = new ArrayList<>();
		 List<String> immutableLs = Collections.unmodifiableList(emptyList);
		 
		 List<String> list = new ArrayList<>();
		 list.add("one");
		 list.add("two");
		 list.add("three");
		 List<String> immutableLt = Collections.unmodifiableList(list);
		 
		 //JAVA 9
		 
		 List<String> immutableJ9= List.of("one","two","three");
		 /*
		  * They are Immutable.
			We cannot add, modify and delete their elements.
			If we try to perform Add/Delete/Update operations on them, we will get UnsupportedOperationException
			They don’t allow null elements.
			If we try to create them with null elements, we will get NullPointerException
			If we try add null elements, we will get UnsupportedOperationException
			They are serializable if all elements are serializable.
		  * 
		  * 
		  * 
		  * 
		  */
		 
		 
		 //::::::::::::::::::::::::MAP:::::::::::::::::::::::::::::
		 Map<Integer,String> emptyMap = new HashMap<>();
		 Map<Integer,String> immutableEmptyMap = Collections.unmodifiableMap(emptyMap);
		 
		 //java 9
		 Map<Integer,String> emptyImmutableMap = Map.of();
		 
		 Map<Integer,String> nonemptyImmutableMap = Map.of(1, "one", 2, "two", 3, "three");
		 
		 Map<Integer,String> emptyImmutableMap1 = Map.ofEntries(entry(1,"one"),entry(2,"two"), entry(3,"three"));
		 
		 Map.Entry<Integer,String> immutableMapEntry1 = Map.entry(1,"one");
		 
		 
		 
		 //:::::::::::::::::Private methods in Interfaces:::::::::::::::::::
		 
		 /*
		  * To avoid redundant code and more re-usability, Oracle Corp is going to introduce private methods in Java SE 9 Interfaces.
		  *  From Java SE 9 on-wards, we can write private and private static methods too in an interface using ‘private’ keyword.
		  *  These private methods are like other class private methods only, there is no difference between them.
		  */
		
		 
		 // ::::::::::::::; Java 9 Module System;;;;;;;;;;;;;;;;
		 
		 
		 //:::::::::::::::::::Try With Resources Improvement::::::::::::::::::
		 
		 //JAva 7
		 void testARM_Before_Java9() throws IOException{
			 BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
			 try (BufferedReader reader2 = reader1) {
			   System.out.println(reader2.readLine());
			 }
			}
		 
		 //Java 9
		 void testARM_Java9() throws IOException{
			 BufferedReader reader1 = new BufferedReader(new FileReader("journaldev.txt"));
			 try (reader1) {
			   System.out.println(reader1.readLine());
			 }
			}
		 
		 //::::::::::::::Reactive Streams::::::::::::::
		 
		// Java SE 9 Reactive Streams API is a Publish/Subscribe Framework to implement Asynchronous, Scalable and Parallel applications very easily using Java language.
		 
		 
	}

}
