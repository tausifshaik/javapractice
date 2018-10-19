package com.learning.basics.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionInterfaces {
	
	/*
	 * all the core collection interfaces are generic; for example public interface Collection<E>. 
	 * The <E> syntax is for Generics and when we declare Collection, we should use it to specify the type of Object it can contain. 
	 * It helps in reducing run-time errors by type-checking the Objects at compile-time.
	 * 
	 * The interface has methods to tell you how many elements are in the collection (size, isEmpty),
	 *  to check whether a given object is in the collection (contains), 
	 *  to add and remove an element from the collection (add, remove), 
	 *  and to provide an iterator over the collection (iterator).
	 *  Collection interface also provides bulk operations methods that work on entire collection – containsAll, addAll, removeAll, retainAll, clear.
	 *  The toArray methods are provided as a bridge between collections and older APIs that expect arrays on input.
	 */
	
	
	/*
	 * Iterator interface:
	 * Iterator interface provides methods to iterate over any Collection. We can get iterator instance from a Collection using iterator method. 
	 * Iterator takes the place of Enumeration in the Java Collections Framework. 
	 * Iterators allow the caller to remove elements from the underlying collection during the iteration. 
	 * Iterators in collection classes implement Iterator Design Pattern.
	 * 
	 * 
	 * Set Interface:
	 * Set is a collection that cannot contain duplicate elements. 
	 * This interface models the mathematical set abstraction and is used to represent sets, such as the deck of cards.
	 * The Java platform contains three general-purpose Set implementations: HashSet, TreeSet, and LinkedHashSet. 
	 * Set interface doesn’t allow random-access to an element in the Collection.
	 * You can use iterator or foreach loop to traverse the elements of a Set.
	 * 
	 * List Interface:List is an ordered collection and can contain duplicate elements. You can access any element from it’s index.
	 *  List is more like array with dynamic length.
	 *  List is one of the most used Collection type.
	 *  ArrayList and LinkedList are implementation classes of List interface.
	 *  
	 *  List interface provides useful methods to add an element at specific index, 
	 *  remove/replace element based on index and
	 *  to get a sub-list using index.
	 *  Collections class provide some useful algorithm for List – sort, shuffle, reverse, binarySearch etc.
	 *  :::::::: CHECK BELOW EXAMPLE FOR LIST ::::::::::::::
	 *  
	 *  Queue Interface:
	 *  Queue is a collection used to hold multiple elements prior to processing.
	 *   Besides basic Collection operations, a Queue provides additional insertion, extraction, and inspection operations.
	 *   Queues typically, but do not necessarily, order elements in a FIFO (first-in, first-out) manner.
	 *   Among the exceptions are priority queues, which order elements according to a supplied comparator or the elements’ natural ordering. 
	 *   Whatever the ordering used, the head of the queue is the element that would be removed by a call to remove or poll. 
	 *   In a FIFO queue, all new elements are inserted at the tail of the queue.
	 *   
	 *   Dequeue Interface
	 *    linear collection that supports element insertion and removal at both ends. The name deque is short for “double ended queue” and is usually pronounced “deck”.
	 *    Most Deque implementations place no fixed limits on the number of elements they may contain, 
	 *    but this interface supports capacity-restricted deques as well as those with no fixed size limit.
	 *    
	 *  SortedSet Interface 
	 *  SortedSet is a Set that maintains its elements in ascending order.
	 *  Several additional operations are provided to take advantage of the ordering.
	 *  Sorted sets are used for naturally ordered sets, such as word lists and membership rolls.
	 *  
	 *  SortedMap Interface
	 *  Map that maintains its mappings in ascending key order.
	 *  This is the Map analog of SortedSet. Sorted maps are used for naturally ordered collections of key/value pairs, such as dictionaries and telephone directories.
	 * 
	 */
	
	public static void main(String[] args) {
		
		List strList = new ArrayList<>();

		//add at last
		strList.add(0, "0");

		//add at specified index
		strList.add(1, "1");

		//replace
		strList.set(1, "2");

		//remove
		strList.remove("1");
		System.out.println(strList);

	}

}
