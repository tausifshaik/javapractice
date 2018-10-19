package com.learning.basics.J8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.*;

public class J8StreamExamples {
	
	
	public static void main(String[] args){
		
	/*
	 * Creating Java Streams
	 * There are several ways through which we can create a java stream from array and collections
	 */
		
		/*
		 *  stream.of()
		 *  We can use Stream.of() to create a stream from similar type of data. For example, we can create Java Stream of integers from a group of int or Integer objects.
		 */
		
		Stream<Integer> stream = Stream.of(1,2,3,4);
		System.out.println(stream);
		
		Stream<Integer> integerStream = Stream.of(new Integer[]{1,2,3,4});
		System.out.println(integerStream);
		
		//Stream<Integer> stream1 = Stream.of(new int[]{1,2,3,4}); 
		//Compile time error, Type mismatch: cannot convert from Stream<int[]> to Stream<Integer>
		
		/*
		 * Sequential stream and parallel stream
		 */
		
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		
		//sequential stream
		Stream<Integer> sequentialStream = myList.stream();
				
		//parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();
		
		/*
		 * We can use Stream.generate() and Stream.iterate() methods to create Stream.
		 */
		
		Stream<String> stream1 = Stream.generate(() -> {return "abc";});
		Stream<String> stream2 = Stream.iterate("abc", (i) -> i);
		
		
		
		/*
		 * Converting Java Stream to Collection or Array
		 * 
		 * 1. We can use java Stream collect() method to get List, Map or Set from stream.
		 * 
		 */
		
		List<Integer> convList = stream.collect(Collectors.toList());
		System.out.println(convList);
		
		stream = Stream.of(1,2,3,4);//stream is closed, so we need to create it again
		
		Map<Integer,Integer> mapStream = stream.collect(Collectors.toMap(i -> i , i -> i+10));
		System.out.println(mapStream);
		
		stream = Stream.of(1,2,3,4);//stream is closed, so we need to create it again
		Integer [] intArray = stream.toArray(Integer[]::new); // what is this :: syntax.
		
		
		
		/*
		 * Java Stream Intermediate Operations Examples
		 * 
		 * 1.Filter()
		 * We can use filter() method to test stream elements for a condition and generate filtered list.
		 * 
		 * 
		 */
		
		List<Integer> myList1 = new ArrayList<>();
		for(int i=0; i<100; i++) myList1.add(i);
		
		Stream<Integer> str = myList1.stream();
		Stream<Integer> highNums = str.filter(i -> i > 90);
		System.out.print("High Nums greater than 90=");
		highNums.forEach(i -> System.out.print(i+" "));
		
		/*
		 * 2. MAP()
		 * We can use map() to apply functions to an stream. Let’s see how we can use it to apply upper case function to a list of Strings.
		 */
		
		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.println(names.map(s -> {
				return s.toUpperCase();
			}).collect(Collectors.toList()));
		
		/*
		 * 3.SORTED()
		 * We can use sorted() to sort the stream elements by passing Comparator argument.
		 * 
		 * 
		 */
		
		Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
		List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSorted);
		
		Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
		List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
		System.out.println(naturalSorted); 
		
		/*
		 *4.FlatMap()
		 * We can use flatMap() to create a stream from the stream of list. Let’s see a simple example to clear this doubt.
		 *
		 */
		Stream<List<String>> namesOriginalList = Stream.of(
				Arrays.asList("Pankaj"), 
				Arrays.asList("David", "Lisa"),
				Arrays.asList("Amit"));
		
		//flat the stream from List<String> to String stream
		Stream<String> flatStream = namesOriginalList
			.flatMap(strList -> strList.stream());
		flatStream.forEach(System.out::println);
		
		
		
		/*
		 * :::Stream Terminal Operations::: 
		 * 1.reduce() We can use reduce() to perform a reduction on the elements of the stream, using an associative accumulation function, and return an Optional. 
		 */
		Stream<Integer> numbers = Stream.of(1,2,3,4,5);
		
		Optional<Integer> intOptional = numbers.reduce((i,j) -> {return i*j;});
		if(intOptional.isPresent()) System.out.println("Multiplication = "+intOptional.get()); //120
		
		/*
		 * 2.count()
		 */
		Stream<Integer> numbers1 = Stream.of(1,2,3,4,5);
		
		System.out.println("Number of elements in stream="+numbers1.count());
		
		/*
		 * 3.forEach() 
		 * This can be used for iterating over the stream. We can use this in place of iterator.
		 */
		Stream<Integer> numbers2 = Stream.of(1,2,3,4,5);
		numbers2.forEach(i -> System.out.print(i+",")); //1,2,3,4,5,
		
		/*
		 * 4.match()
		 */
		Stream<Integer> numbers3 = Stream.of(1,2,3,4,5);
		System.out.println("Stream contains 4? "+numbers3.anyMatch(i -> i==4));
		//Stream contains 4? true

		Stream<Integer> numbers4 = Stream.of(1,2,3,4,5);
		System.out.println("Stream contains all elements less than 10? "+numbers4.allMatch(i -> i<10));
		//Stream contains all elements less than 10? true

		Stream<Integer> numbers5 = Stream.of(1,2,3,4,5);
		System.out.println("Stream doesn't contain 10? "+numbers5.noneMatch(i -> i==10));
		//Stream doesn't contain 10? true
		
		/*
		 * 5.findFirst() 
		 * 
		 */
		Stream<String> names4 = Stream.of("Pankaj","Amit","David", "Lisa");
		Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
		if(firstNameWithD.isPresent()){
			System.out.println("First Name starting with D="+firstNameWithD.get()); //David
		}
		
		
		/*
		 * Stream limitations
		 * 1. parallelstream and lamba expressions
		 * 
		 * 
		 */
		
		List<Integer> ss = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		List<Integer> result = new ArrayList<Integer>();
		 
		Stream<Integer> pstream = ss.parallelStream();
		 
		pstream.map(s -> {
		        synchronized (result) {
		          if (result.size() < 10) {
		            result.add(s);
		          }
		        }
				return s;
		    }).forEach( e -> {});
		 System.out.println(result);
	}
	 //you will get different results because it depends on the way stream is getting iterated 
	//and we don’t have any order defined for parallel processing. If we use sequential stream, then this problem will not arise.
	
	/*
	 * 2.Once a Stream is consumed, it can’t be used later on. As you can see in above examples that every time I am creating a stream.
	 * 
	 * 3.There are a lot of methods in Stream API and the most confusing part is the overloaded methods. It makes the learning curve time taking.
	 */
}
