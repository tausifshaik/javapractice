package com.learning.basics.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConcurrentModificationExceptionEx1 {

	/*
	 * java.util.ConcurrentModificationException is a very common exception when working with java collection classes. 
	 * Java Collection classes are fail-fast, which means if the Collection will be changed while some thread is traversing over it using iterator, 
	 * the iterator.next() will throw ConcurrentModificationException. 
	 * Concurrent modification exception can come in case of multithreaded as well as single threaded java programming environment.
	 */
	public static void main(String[] args) {
		
		List<String> myList = new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3"))
				myList.remove(value);
				//it.remove();
				//use it.remove() to avoid ConcurrentModificationException
		}
		
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				myMap.put("1", "4");
				// myMap.put("4", "4"); this line will throw ConcurrentModificationException
			}
		}

	}

}
