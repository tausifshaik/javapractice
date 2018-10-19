package com.learning.basics.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListEx {
	
	/*
	 * Java ArrayList is one of the most widely used Collection class. java.util.ArrayList class implements java.util.List interface. 
	 * Java ArrayList also implements RandomAccess, Cloneable and Serializable interfaces.
	 * Java ArrayList class extends AbstractList class that is the skeleton implementation of List interface.
	 * 
	 * Java ArrayList is the resizable array implementation of List interface, 
	 * that means it starts with default size and grows automatically when more data is added into array list.
	 * 
	 *  Some important points about Java ArrayList are:
	 *  Java ArrayList is almost similar to Vector except that it’s unsynchronized, so performance is better in single threaded environment.
	 *  Java ArrayList is not thread safe, so special care must be given when used in multithreaded environment.
	 *  Java ArrayList can contain duplicate values, it also allows “null” value.
	 *  Objects in java ArrayList are added in order. So you can always retrieve the first object by index 0.
	 *  Java ArrayList default capacity is defined as 10. However we can change the default capacity through it’s constructor or by calling ensureCapacity(int minCapacity) method.
	 *  Java ArrayList Iterator and ListIterator implementation is fail-fast. 
	 *  	 If the list structure is modified after creating the iterator in any other way except the iterator add or remove methods, it will throw ConcurrentModificationException.
	 *  Java ArrayList provides random access to it’s elements because it works on index. We can retrieve any element through it’s index.
	 *  Java ArrayList supports Generics and it’s the recommended way to create an ArrayList.
	 */
	
	/*
	 * public boolean add(E e): Appends the specified element to the end of this list.
	 * public void add(int index, E element): Inserts the specified element at the specified position in the list. Shifts the element currently at that position (if any) and any subsequent elements to the right. If index is greater than list size or negative, it will throw IndexOutOfBoundsException.
	 * public boolean addAll(Collection<? extends E> c): Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection’s Iterator. This operation throws NullPointerException if the specified collection is null.
	 * public boolean addAll(int index, Collection<? extends E> c): Inserts all of the elements in the specified collection into this list, starting at the specified position. Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). This method will throw IndexOutOfBoundsException if the index value is greater than list size or negative. This method also throws NullPointerException if specified collection is null.
	 * public boolean contains(Object o): Returns true if this list contains the specified element.
	 * public void clear(): Removes all of the elements from this list.
	 * public void ensureCapacity(int minCapacity): Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.
	 * public void forEach(Consumer<? super E> action): Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.
	 * public E get(int index): Returns the element at the specified position in this list.
	 * public boolean isEmpty(): Returns true if this list contains no elements.
	 * public int indexOf(Object o): Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
	 * public Iterator<E> iterator(): Returns an iterator over the elements in this list in proper sequence. The returned iterator is fail-fast.
	 * public int lastIndexOf(Object o): Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
	 * public ListIterator<E> listIterator(): Returns a list iterator over the elements in this list (in proper sequence). The returned list iterator is fail-fast.
	 * public ListIterator<E> listIterator(int index): Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list. The specified index indicates the first element that would be returned by an initial call to next. An initial call to previous would return the element with the specified index minus one. This method throws IndexOutOfBoundsException if index value is greater than list size or negative.
	 * public E remove(int index): Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
	 * public boolean remove(Object o): Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged.
	 * public boolean removeAll(Collection<E> c): Removes from this list all of its elements that are contained in the specified collection.
	 * public boolean retainAll(Collection<E> c): Retains only the elements in this list that are contained in the specified collection. In other words, removes from this list all of its elements that are not contained in the specified collection.
	 * public boolean removeIf(Predicate<? super E> filter): Removes all of the elements of this collection that satisfy the given predicate.
	 * public void replaceAll(UnaryOperator<E> operator): Replaces each element of this list with the result of applying the operator to that element.
	 * public int size(): Returns the number of elements in this list.
	 * public E set(int index, E element): Replaces the element at the specified position in this list with the specified element.
	 * public List<E> subList(int fromIndex, int toIndex): Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa.
	 * public Spliterator<E> spliterator(): Creates a late-binding and fail-fast Spliterator over the elements in this list.
	 * public void sort(Comparator<? super E> c): Sorts this list according to the order induced by the specified Comparator.
	 * public void trimToSize(): Trims the capacity of this ArrayList instance to be the list’s current size. An application can use this operation to minimize the storage of an ArrayList instance.
	 * public Object[] toArray(): Returns an array containing all of the elements in this list in proper sequence (from first to last element). The returned array will be “safe” in that no references to it are maintained by this list. (In other words, this method must allocate a new array). The caller is thus free to modify the returned array.
	 * public <T> T[] toArray(T[] a): Returns an array containing all of the elements in this list in proper sequence. If the list fits in the specified array, it is returned as is. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list.
	 */
	public static void main(String[] args) {
		List<String> letters = new ArrayList<String>();
		
		//add example
		letters.add("A");
		letters.add("C");
		letters.add("D");
		
		//let's insert B between A and C
		letters.add(1,"B");
		System.out.println(letters);
		
		List<String> list = new ArrayList<String>();
		list.add("E");list.add("H");
		
		//appending list elements to letters
		letters.addAll(list);
		System.out.println(letters);
		
		//clear example to empty the list
		list.clear();
		
		list.add("F");list.add("G");
		
		//inserting list inside letters to get right sequence
		letters.addAll(5, list);
		System.out.println(letters);
		
		//contains example
		System.out.println("Letters list contains E ? "+letters.contains("E"));
		System.out.println("Letters list contains Z ? "+letters.contains("Z"));
		
		//ensureCapacity example, it's ArrayList method, so object should be defined like below.
		ArrayList<String> tempList = new ArrayList<>();
		tempList.ensureCapacity(1000);
		//tempList is empty?
		System.out.println("tempList is empty ? "+tempList.isEmpty());
		//get example
		String e = letters.get(4);
		System.out.println("Letter at 5th place: "+e);
		
		//indexOf example
		System.out.println("First index of D = "+letters.indexOf("D"));
		System.out.println("Last index of D = "+letters.lastIndexOf("D"));
		
		//remove examples
		System.out.println(letters);
		String removed = letters.remove(3);
		System.out.println("After removing '"+removed+"' letters contains "+letters);
		
		//remove first occurrence of H
		boolean isRemoved = letters.remove("H");
		System.out.println("H removed? "+isRemoved+". Letters contains "+letters);
		System.out.println("list contains "+list);
		
		//remove all matching elements between letters and list
		letters.removeAll(list);
		System.out.println(letters);
		
		//retainAll example
		list.clear();list.add("A");list.add("B");list.add("C");
		letters.retainAll(list);
		System.out.println("letters elements after retainAll operation: "+letters);
		
		//size example
		System.out.println("letters ArrayList size = "+letters.size());
		
		//set example
		letters.set(2, "D");
		System.out.println(letters);
		
		//toArray example
		String[] strArray = new String[letters.size()];
		strArray = letters.toArray(strArray);
		System.out.println(Arrays.toString(strArray));
	}

}
