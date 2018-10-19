package com.learning.basics.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionClassesHashSet {
	
	/*
	 * Java Collections Classes
	 * Java Collections framework comes with many implementation classes for the interfaces. 
	 * Most common implementations are ArrayList, HashMap and HashSet.
	 * Java 1.5 included Concurrent implementations; for example ConcurrentHashMap and CopyOnWriteArrayList. 
	 * Usually Collection classes are not thread-safe and their iterator is fail-fast.
	 * 
	 * Java HashSet is the most popular implementation of Set interface. java.util.HashSet is backed by a HashMap. 
	 * HashSet extends AbstractSet class and implements Set, Cloneable and Serializable interfaces.
	 * 
	 * 
	 * Some of the important points about HashSet in java are;
	 * HashSet doesn’t allow duplicate entries.
	 * HashSet allows null as a value.
	 * HashSet doesn’t guarantee the insertion order of elements.
	 * HashSet is not thread-safe. You can get thread-safe HashSet using Collections.synchronizedSet method at the cost of performance.
	 *  You can also use CopyOnWriteArraySet concurrency class for thread safety.
	 * HashSet iterator methods are fail-fast. So any structural modification to the set after creation of iterator will throw ConcurrentModificationException.
	 * HashSet supports Generics, this is the recommended approach to avoid ClassCastException at runtime.
	 * HashSet uses HashMap for storing elements, so the objects should provide good implementation of hashCode() and equals() method to avoid unwanted results.
	 */
	/*
	 * HashSet Methods:
	 * public boolean add(E e): Adds the given element to the Set if not already present.
	 *  This method internally uses equals() method to check for duplicates, so make sure your object defines equals() method properly.
	 * public void clear(): Removes all the elements from the Set.
	 * public Object clone(): Returns a shallow copy of the Set instance.
	 * public boolean contains(Object o): Returns true if the Set contains the given element, othrweise false.
	 * public boolean isEmpty(): Returns true if Set contains no elements, otherwise false.
	 * public Iterator<E> iterator(): Returns an iterator over the elements in this set. The elements are returned in no particular order.
	 * public boolean remove(Object o): Removes the given element from this set if it is present and return true. If the element is not present in the set, just returns false.
	 * public int size(): Returns the number of elements in the set.
	 * public Spliterator<E> spliterator(): Creates a late-binding and fail-fast Spliterator over the elements in this set. 
	 *  This is introduced in Java 8, however I have not used it till now.
	 * public boolean removeAll(Collection<?> c): HashSet inherits this method from AbstractSet.
	 *  This method will remove all the elements in the set that are part of the specified collection.
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();

		//initial capacity should be power of 2
		set = new HashSet<>(32); 

		//setting backing HashMap initial capacity and load factor
		set = new HashSet<>(32, 0.80f);

		//creating HashSet from another Collection
		Set<String> set1 = new HashSet<>(set);
		Set<String> set2 = new HashSet<>(new ArrayList<>());
		
		
		Set<String> fruits = new HashSet<>();
		
		//add example
		fruits.add("Apple");
		fruits.add("Banana");
		
		//isEmpty example
		System.out.println("fruits set is empty = "+fruits.isEmpty());
		
		//contains example
		System.out.println("fruits contains Apple = "+fruits.contains("Apple"));
		System.out.println("fruits contains Mango = "+fruits.contains("Mango"));
		
		//remove example
		System.out.println("Apple removed from fruits set = "+fruits.remove("Apple"));
		System.out.println("Mango removed from fruits set = "+fruits.remove("Mango"));
		
		//size example
		System.out.println("fruits set size = "+fruits.size());
		
		//addAll example
		List<String> list = new ArrayList<>(); 
		list.add("Apple"); list.add("Apple"); 
		list.add("Banana"); list.add("Mango");
		
		System.out.println("fruits set before addAll = "+fruits);
		System.out.println("list = "+list);
		fruits.addAll(list);
		System.out.println("fruits set after addAll = "+fruits);
		
		//iterator example
		Iterator<String> iterator = fruits.iterator();
		while(iterator.hasNext()){
			System.out.println("Consuming fruit "+iterator.next());
		}
		
		fruits.add("Orange");
		System.out.println("fruits set before removeAll = "+fruits);
		System.out.println("list = "+list);
		fruits.removeAll(list);
		System.out.println("fruits set after removeAll = "+fruits);
		
		//clear example
		fruits.clear();
		System.out.println("fruits set is empty = "+fruits.isEmpty());
		
		
		/*
		 * Java HashSet ConcurrentModificationException
		 */
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");
		Iterator<String> iterator1 = fruits.iterator();
		while(iterator1.hasNext()){
			String fruit = iterator1.next();
			System.out.println("Processing "+fruit);
			
			//wrong way of removing from Set, can throw java.util.ConcurrentModificationException
			/*
			 * Note that HashSet elements are not guaranteed to be ordered and ConcurrentModificationException is being thrown by iterator.next() call.
			 * So if the “Orange” is the last one in the iterator, you will not get the exception because iterator.hasNext() will return false and iterator.next() will not get called.
			 */
			if("Orange".equals(fruit)) fruits.remove("Orange");
			//We should always use Iterator methods for structural modification, as shown in below example code.
			//correct way of structural modification of Set
			if("Orange".equals(fruit)) iterator.remove();
		}
		
		

	}

}
