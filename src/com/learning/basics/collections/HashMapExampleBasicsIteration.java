package com.learning.basics.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExampleBasicsIteration {
	/*
	 * Java HashMap is one of the most popular Collection classes in java. Java HashMap is Hash table based implementation.
	 *  HashMap in java extends AbstractMap class that implements Map interface.
	 *  
	 *  Java HashMap allows null key and null values.
	 *  HashMap is not an ordered collection. You can iterate over HashMap entries through keys set but they are not guaranteed to be in the order of their addition to the HashMap.
	 *  HashMap is almost similar to Hashtable except that it’s unsynchronized and allows null key and values.
	 *  HashMap uses it’s inner class Node<K,V> for storing map entries.
	 *  HashMap stores entries into multiple singly linked lists, called buckets or bins. Default number of bins is 16 and it’s always power of 2.
	 *  HashMap uses hashCode() and equals() methods on keys for get and put operations. So HashMap key object should provide good implementation of these methods. This is the reason immutable classes are better suitable for keys, for example String and Interger.
	 *  Java HashMap is not thread safe, for multithreaded environment you should use ConcurrentHashMap class or get synchronized map using Collections.synchronizedMap() method.
	 *  
	 */
	
	/*
	 * hashMap methods:
	 * public void clear(): This HashMap method will remove all the mappings and HashMap will become empty.
	 * public boolean containsKey(Object key): This method returns ‘true’ if the key exists otherwise it will return ‘false’.
	 * public boolean containsValue(Object value): This HashMap method returns true if the value exists otherwise false.
	 * public Set<Map.Entry<K,V>> entrySet(): This method returns a Set view of the HashMap mappings. This set is backed by the map, so changes to the map are reflected in the set, and vice-versa.
	 * public V get(Object key): Returns the value mapped to the specified key, or null if there is no mapping for the key.
	 * public boolean isEmpty(): A utility method returning true if no key-value mappings are present.
	 * public Set<K> keySet(): Returns a Set view of the keys contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.
	 * public V put(K key, V value): Associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced.
	 * public void putAll(Map<? extends K, ? extends V> m): Copies all of the mappings from the specified map to this map. These mappings will replace any mappings that this map had for any of the keys currently in the specified map.
	 * public V remove(Object key): Removes the mapping for the specified key from this map if present.
	 * public int size(): Returns the number of key-value mappings in this map.
	 * public Collection<V> values(): Returns a Collection view of the values contained in this map. The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa.
	 * There are many new methods in HashMap introduced in Java 8.
	 */
	public static void main(String[] args) {
		
		/*
		 * Method #1: Iterating over entries using For-Each loop.
		 * This is the most common method and is preferable in most cases. Should be used if you need both map keys and values in the loop.
		 */
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//For-Each loop will throw NullPointerException if you try to iterate over a map that is null, so before iterating you should always check for null references.
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		
	
		/*
		 * Method #2: Iterating over keys or values using For-Each loop.
		 * If you need only keys or values from the map, you can iterate over keySet or values instead of entrySet.
		 */
		// Iterating over keys only
		for (Integer key : map.keySet()) {
		    System.out.println("Key = " + key);
		}

		// Iterating over values only
		for (Integer value : map.values()) {
		    System.out.println("Value = " + value);
		}
		/*This method gives slight performance advantage over entrySet iteration (about 10% faster) and is more clean.*/
		
		/*
		 * Method #3: Iterating using Iterator.
		 */
		// Using generics
		Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<Integer, Integer> entry = entries.next();
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		
		// without generics
		Iterator entriess = map.entrySet().iterator();
		while (entriess.hasNext()) {
		    Map.Entry entry = (Map.Entry) entriess.next();
		    Integer key = (Integer)entry.getKey();
		    Integer value = (Integer)entry.getValue();
		    System.out.println("Key = " + key + ", Value = " + value);
		}
		/*
		 *  The other important feature is that it is the only method that allows you to remove entries from the map during iteration by calling iterator.remove().
		 *  If you try to do this during For-Each iteration you will get "unpredictable results" according to javadoc.
		 *  From performance point of view this method is equal to For-Each iteration.
		 */
		
		/*
		 * Method #4: Iterating over keys and searching for values (inefficient).
		 */
		for(Integer key : map.keySet()){
			 Integer value = map.get(key);
			 System.out.println("Key = " + key + ", Value = " + value);
		}
		/*
		 * This might look like a cleaner alternative for method #1 but in practice it is pretty slow and inefficient as getting values by a key might be time consuming 
		 * (this method in different Map implementations is 20%-200% slower than method #1).
		 */
	}

}
