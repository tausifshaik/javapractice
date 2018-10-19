package com.learning.basics.J8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class J8lambdaExample {
	
	private static boolean isPrime(int number){
		if(number < 2) return false;
		for(int i=2; i< number; i++){
			if(number % i == 0) return false;
		}
		return true;
	}
	
	private static boolean isLambdaPrime(int number){
		return number >1 && IntStream.range(2,number).noneMatch(index -> number % index == 0);
	}
	private static int findSquareOfMaxOdd(List<Integer> numbers) {
		int max = 0;
		for (int i : numbers) {
			if (i % 2 != 0 && i > 3 && i < 11 && i > max) {
				max = i;
			}
		}
		return max * max;
	}
	
	public static int findSquareOfMaxOddWithLambda(List<Integer> numbers) {
		return numbers.stream()
				.filter(J8lambdaExample::isOdd) 		//Predicate is functional interface and
				.filter(J8lambdaExample::isGreaterThan3)	// we are using lambdas to initialize it
				.filter(J8lambdaExample::isLessThan11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isGreaterThan3(int i){
		return i > 3;
	}
	
	public static boolean isLessThan11(int i){
		return i < 11;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J8lambdaExample  ex = new J8lambdaExample();
		System.out.println("is prime:"+ ex.isPrime(1));
		System.out.println("is Lambda prime:"+ ex.isLambdaPrime(1));
		
		List <Integer> listOfNumbers = new ArrayList<Integer>();
		listOfNumbers.add(10);
		listOfNumbers.add(5);
		listOfNumbers.add(7);
		listOfNumbers.add(9);
		System.out.println(listOfNumbers);
		System.out.println("lambda method reference::::"+ ex.findSquareOfMaxOddWithLambda(listOfNumbers));
	}


}
