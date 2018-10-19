package com.learning.basics.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListForEachJ8 {
		
	/*
	 * Java ArrayList forEach method was added in Java 8. 
	 * It’s useful when you want to perform same action on all the elements. 
	 * The method argument Consumer is a functional interface, so we can use lambda expressions too. 
	 * Below is an example of forEach method showing the old school way as well as lambda expression way.
	 */

	public static void main(String[] args) {
		List<String> stocks = new ArrayList<>();
		stocks.add("Google"); stocks.add("Apple");
		stocks.add("Microsoft"); stocks.add("Facebook");
		
		Consumer<Object> consumer = new ArrayListForEachJ8().new MyConsumer();
		
		stocks.forEach(consumer);
		
		//lambda style
		stocks.forEach(x -> {System.out.println("Processed "+x);});
	}
	class MyConsumer implements Consumer<Object>{

		@Override
		public void accept(Object t) {
			System.out.println("Processing "+t);
		}
		
	}

}
