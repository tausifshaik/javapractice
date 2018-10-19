package com.learning.basics;

import java.util.HashMap;
import java.util.Iterator;

/*
 * Immutable objects are instances whose state doesn’t change after it has been initialized.
 *  For example, String is an immutable class and once instantiated its value never changes.
 *  
 *  
 *  To create immutable class in java, you have to do following steps.
1.Declare the class as final so it can’t be extended.
2.Make all fields private so that direct access is not allowed.
3.Don’t provide setter methods for variables
4.Make all mutable fields final so that it’s value can be assigned only once.
5.Initialize all the fields via a constructor performing deep copy.
6.Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.

TODO : Find a real world example for Immutable  classes
think of a scenario that you can apply.
 * */
 
public final class ImmutableClassExample {
	
	private final int id;
	private final String Name;
	private final HashMap<String,String> testMap;
	

	public int getId() {
		return id;
	}


	public String getName() {
		return Name;
	}


	public HashMap<String, String> getTestMap() {
		//return testMap;
		return (HashMap<String, String>) testMap.clone();
	}

	public ImmutableClassExample(int id, String name, HashMap<String,String> tmap){
		this.id = id;
		this.Name = name;
		HashMap<String,String> testMap = new HashMap<String,String>();
		String key;
		Iterator<String> it = tmap.keySet().iterator();
		while(it.hasNext()){
			key = it.next();
			testMap.put(key, tmap.get(key));
		}
		this.testMap = tmap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, String> h1 = new HashMap<String,String>();
		h1.put("1", "first");
		h1.put("2", "second");
		
		String s = "original";
		
		int id=10;
		
		ImmutableClassExample classExample = new ImmutableClassExample(id, s, h1);
		
		System.out.println(classExample.getId());
		System.out.println(classExample.getName());
		System.out.println(classExample.getTestMap());
		
		//change the local variable values
		id=20;
		s="modified";
		h1.put("3", "third");
		
		System.out.println(classExample.getId());
		System.out.println(classExample.getName());
		System.out.println(classExample.getTestMap());
		
		//chnage the map using accessor methods:
		
		HashMap<String,String> hm = classExample.getTestMap();
		hm.put("4", "four");
		
		System.out.println(classExample.getId());
		System.out.println(classExample.getName());
		System.out.println(classExample.getTestMap());
				
		
		
		
	}

}
