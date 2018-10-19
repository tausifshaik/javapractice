package com.learning.basics.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapInterface {
	
	/*
	 * Java Map is an object that maps keys to values. A map cannot contain duplicate keys: Each key can map to at most one value.
	 * The Java platform contains three general-purpose Map implementations: HashMap, TreeMap, and LinkedHashMap.
	 * The basic operations of Map are put, get, containsKey, containsValue, size, and isEmpty.
	 * 
	 * Important points about Map:
	 * 1. Map provides three collection views – set of keys, set of key-value mappings and collection of values.
	 * 2.Map doesn’t guarantee order of mappings, however it depends on the implementation. For example, HashMap doesn’t guarantee the order of mappings but TreeMap does.
	 * 3.Map utilise hashCode and equals methods on Key for get and put operations. So mutable classes are not a good fit for Map keys.
	 *  If the values of hashCode or equals change after put, you won’t get the correct value in get operation.
	 * 4.Popular implementation classes of Map in Java are HashMap, Hashtable, TreeMap, ConcurrentHashMap and LinkedHashMap.
	 * 5.AbstractMap class provides skeletal implementation of the Map interface, most of the Map concrete classes extend AbstractMap class and implement required methods.
	 */
	
	/*
	 * Map Methods:
	 * int size(): returns the number of key-value mappings in this Map.
	 * boolean isEmpty(): returns true if there are no mappings present, otherwise false.
	 * boolean containsValue(Object value): returns true if there are at least one key mapped to the specified value, otherwise false.
	 * V get(Object key): returns the value mapped to the given key, if no mapping found then returns null.
	 * V put(K key, V value): adds the mapping of key-value pair to the map. If there is already a value mapped to this key, then replace the value. This method returns the previous value associated with key, or null if there was no mapping for key.
	 * V remove(Object key): Removes the mapping for a key from this map if it is present. Returns the value to which this map previously associated the key, or null if the map contained no mapping for the key.
	 * void putAll(Map<? extends K, ? extends V> m): Copies all of the mappings from the specified map to this map.
	 * void clear(): removes all the mappings from the Map.
	 * Set<K> keySet(): returns the Set view of all the keys in the Map. This key set is backed by Map, so any modifications to Map will be reflected to the key set and vice versa.
	 * Collection<V> values(): returns the collection view of all the values in the Map. This collection is backed by Map, so any change in Map will reflect to this values collection and vice versa.
	 * Set<Map.Entry<K, V>> entrySet(): returns the Set view of the mappings in the Map. This Set is backed by Map, so any modifications in Map will be reflected in the entry set and vice versa.
	 */
	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<>();
		map.put("A","A");
		map.put("B","B");
		map.put("C","C");
		map.put(null,"D");
		map.put("E",null);
		
		String value = map.get("C"); // get example
		System.out.println("Key = C, Value = " + value);
		
		value = map.getOrDefault("D", "Default Value");
		System.out.println("Key = D, Value=" + value);
		
		boolean keyExists = map.containsKey(null);
		boolean valueExists = map.containsValue("D");
		System.out.println("keyExists= " + keyExists + ", valueExists= " + valueExists);

		Set<Entry<String, String>> entrySet = map.entrySet();
		System.out.println(" Entry Set"+ entrySet);
		
		System.out.println("data map size=" + map.size());
		
		Map<String, String> data1 = new HashMap<>();
		data1.putAll(map);
		System.out.println("data1 mappings= " + data1);
		
		String nullKeyValue = data1.remove(null);
		System.out.println("data1 null key value = " + nullKeyValue);
		System.out.println("data1 after removing null key = " + data1);
		
		Set<String> keySet = map.keySet();
		System.out.println("data map keys = " + keySet);

		Collection<String> values = map.values();
		System.out.println("data map values = " + values);

		map.clear();
		System.out.println("data map is empty =" + map.isEmpty());
		
		
	}

}
