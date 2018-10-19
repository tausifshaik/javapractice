package com.learning.basics.collections;

/*
 * This class consists exclusively of static methods that operate on or return collections.
 * It contains polymorphic algorithms that operate on collections, “wrappers”, which return a new collection backed by a specified collection, and a few other odds and ends.
 * This class contains methods for collection framework algorithms, such as binary search, sorting, shuffling, reverse etc.
 */

/*
 * Synchronized Wrappers
 * The synchronization wrappers add automatic synchronization (thread-safety) to an arbitrary collection. Each of the six core collection interfaces — Collection, Set, List, Map, SortedSet, and SortedMap — has one static factory method.
	public static  Collection synchronizedCollection(Collection c);
	public static  Set synchronizedSet(Set s);
	public static  List synchronizedList(List list);
	public static <K,V> Map<K,V> synchronizedMap(Map<K,V> m);
	public static  SortedSet synchronizedSortedSet(SortedSet s);
	public static <K,V> SortedMap<K,V> synchronizedSortedMap(SortedMap<K,V> m);
	Each of these methods returns a synchronized (thread-safe) Collection backed up by the specified collection.
 */

/*
 * Unmodifiable wrappers
	Unmodifiable wrappers take away the ability to modify the collection by intercepting all the operations that would modify the collection and throwing an UnsupportedOperationException. It’s main usage are;
	
	To make a collection immutable once it has been built. In this case, it’s good practice not to maintain a reference to the backing collection. This absolutely guarantees immutability.
	To allow certain clients read-only access to your data structures. You keep a reference to the backing collection but hand out a reference to the wrapper. In this way, clients can look but not modify, while you maintain full access.
	These methods are;
	public static  Collection unmodifiableCollection(Collection<? extends T> c);
	public static  Set unmodifiableSet(Set<? extends T> s);
	public static  List unmodifiableList(List<? extends T> list);
	public static <K,V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m);
	public static  SortedSet unmodifiableSortedSet(SortedSet<? extends T> s);
	public static <K,V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> m);
 */

/*
 * Thread Safe Collections
Java 1.5 Concurrent package (java.util.concurrent) contains thread-safe collection classes that allow collections to be modified while iterating. 
By design iterator is fail-fast and throws ConcurrentModificationException. Some of these classes are CopyOnWriteArrayList, ConcurrentHashMap, CopyOnWriteArraySet.
 */


/*
 * Collections API Algorithms
	Java Collections Framework provides algorithm implementations that are commonly used such as sorting and searching.
	Collections class contain these method implementations. Most of these algorithms work on List but some of them are applicable for all kinds of collections.

Sorting
	The sort algorithm reorders a List so that its elements are in ascending order according to an ordering relationship.
	 Two forms of the operation are provided. 
	 The simple form takes a List and sorts it according to its elements’ natural ordering. 
	 The second form of sort takes a Comparator in addition to a List and sorts the elements with the Comparator.

Shuffling
	The shuffle algorithm destroys any trace of order that may have been present in a List. 
	That is, this algorithm reorders the List based on input from a source of randomness such that all possible permutations occur with equal likelihood, assuming a fair source of randomness. 
	This algorithm is useful in implementing games of chance.

Searching
	The binarySearch algorithm searches for a specified element in a sorted List. 
	This algorithm has two forms. 
	The first takes a List and an element to search for (the “search key”).
	This form assumes that the List is sorted in ascending order according to the natural ordering of its elements. 
	The second form takes a Comparator in addition to the List and the search key, and assumes that the List is sorted into ascending order according to the specified Comparator.
	The sort algorithm can be used to sort the List prior to calling binarySearch.

Composition
	The frequency and disjoint algorithms test some aspect of the composition of one or more Collections.
	frequency: counts the number of times the specified element occurs in the specified collection
	disjoint: determines whether two Collections are disjoint; that is, whether they contain no elements in common

Min and Max values
	 The min and the max algorithms return, respectively, the minimum and maximum element contained in a specified Collection.
	 Both of these operations come in two forms. 
	 The simple form takes only a Collection and returns the minimum (or maximum) element according to the elements’ natural ordering.
	 The second form takes a Comparator in addition to the Collection and returns the minimum (or maximum) element according to the specified Comparator.
 */
public class CollectionSClass {

}
