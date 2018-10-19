package com.learning.basics.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListListIteratorEx {

	/*
	 * We can use ListIterator to traverse the list in both the direction. 
	 * It allows us to remove as well as add an element to the list. 
	 * You can also get the iterator current position in ListIterator. 
	 */
	public static void main(String[] args) {
		
		List<Integer> ints = new ArrayList<>();
		for (int i = 0; i < 10; i++) ints.add(i);
		
		ListIterator<Integer> lit = ints.listIterator(ints.size());
		
		while(lit.hasPrevious()){
			int x = lit.previous();
			System.out.print(x + ", ");
			if(x==5){
				lit.remove();
				lit.add(20);
			}
		}
		System.out.println("\n"+ints);
	}

}
