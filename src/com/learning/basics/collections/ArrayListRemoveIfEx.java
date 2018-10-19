package com.learning.basics.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ArrayListRemoveIfEx {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		for (int i = 0; i < 10; i++) ints.add(i);
		
		Predicate<Integer> filter = new ArrayListRemoveIfEx(). new MyPredicate();
		
		ints.removeIf(filter);
		
		System.out.println(ints);
		
		//lambda expression, remove elements divisible by 3
		ints.removeIf(x -> {return x %3 == 0;});
		System.out.println(ints);
		
		ints.replaceAll(x -> {return x*5;});
		System.out.println(ints);
	}

	class MyPredicate implements Predicate<Integer> {

		@Override
		public boolean test(Integer t) {
			return t %2 == 0;
		}
		
	}

}
