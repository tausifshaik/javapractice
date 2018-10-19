package com.learning.basics.collections;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class hashMapMethodExs {
	
	/*
	 * How HashMap works in java?
	 * HashMap in java use it’s inner class Node<K,V> for storing mappings. 
	 * HashMap works on hashing algorithm and uses hashCode() and equals() method on key for get and put operations.
	 * HashMap use singly linked list to store elements, these are called bins or buckets. 
	 * 
	 * When we call put method, hashCode of key is used to determine the bucket that will be used to store the mapping
	 * Once bucket is identified, hashCode is used to check if there is already a key with same hashCode or not. 
	 * If there is an existing key with same hashCode, then equals() method is used on key. 
	 * If equals returns true, then value is overwritten, otherwise a new mapping is made to this singly linked list bucket.
	 * If there is no key with same hashCode then mapping is inserted into the bucket.
	 * 
	 * For HashMap get operation, again key hashCode is used to determine the bucket to look for the value. 
	 * After bucket is identified, entries are traversed to find out the Entry using hashCode and equals method.
	 * If match is found, value is returned otherwise null is returned.
	 */

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();

		map.put("1", "1"); // put example
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", null); // null value
		map.put(null, "100"); // null key

		String value = map.get("3"); // get example
		System.out.println("Key = 3, Value = " + value);
		String value1 = map.get(null); // get example
		System.out.println("Key = null, Value = " + value1);
		
		value = map.getOrDefault("5", "Default Value");
		System.out.println("Key = 5, Value=" + value);
		
		boolean keyExists = map.containsKey(null);
		boolean valueExists = map.containsValue("100");

		System.out.println("keyExists=" + keyExists + ", valueExists=" + valueExists);
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		System.out.println(entrySet);
		
		System.out.println("map size=" + map.size());
		
		Map<String, String> map1 = new HashMap<>();
		map1.putAll(map);
		System.out.println("map1 mappings= " + map1);
		
		String nullKeyValue = map1.remove(null);
		System.out.println("map1 null key value = " + nullKeyValue);
		System.out.println("map1 after removing null key = " + map1);
		
		Set<String> keySet = map.keySet();
		System.out.println("map keys = " + keySet);
	
		keySet.remove("1");
		System.out.println(map); // map is also modified
		
		Collection<String> values = map.values();
		System.out.println("map values = " + values);
		values.remove("2"); // changing values collection
		System.out.println(map); // updates in map too
		
		
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		Entry<String, String> next = null;
		
		System.out.println("map before processing = "+map);
		System.out.println("entrySet before processing = "+entrySet);
		while(iterator.hasNext()){
			next = iterator.next();
			System.out.println("Processing on: "+next.getValue());
			if(next.getKey() == null) 
				iterator.remove();
		}
		
		System.out.println("map after processing = "+map);
		System.out.println("entrySet after processing = "+entrySet);
		
		map.put("1", "1");
		System.out.println("map before processing = "+map);
		
		Entry<String, String> simpleEntry = new AbstractMap.SimpleEntry<String, String>("1","1");
		entrySet.remove(simpleEntry);
		System.out.println("map after removing Entry = "+map);
		System.out.println("entrySet after removing Entry = "+entrySet);
		
		map.clear();
		System.out.println("map is empty=" + map.isEmpty());
	}

}
