package com.learning.basics.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorVsListIterator {
	
	/*
	 * differences between them:
	 * With iterator you can move only forward, but with ListIterator you can move backword also while reading the elements.
	 * With ListIterator you can obtain the index at any point while traversing, which is not possible with iterators.
	 * With iterator you can check only for next element available or not, but in listiterator you can check previous and next elements.
	 * With listiterator you can add new element at any point of time, while traversing. Not possible with iterator.
	 * With listiterator you can modify an element while traversing, which is not possible with iterator.
	 */
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		ListIterator<Integer> litr = null;
		li.add(23);
		li.add(98);
		li.add(29);
		li.add(71);
		li.add(5);
		litr=li.listIterator();
		System.out.println("List Iterator Elements in forward directiton");
		while(litr.hasNext()){
		  System.out.println(litr.next());
		}
		System.out.println("List Iterator Elements in backward directiton");
		while(litr.hasPrevious()){
			System.out.println(litr.previous());
		}
		
		
		List<String> myList = new ArrayList<String>();
		myList.add("Java");
		myList.add("Unix");
		myList.add("Oracle");
		myList.add("C++");
		myList.add("Perl");
		Iterator<String> itr = myList.iterator();
		System.out.println("iterator:: ");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
