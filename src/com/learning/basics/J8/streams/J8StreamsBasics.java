package com.learning.basics.J8.streams;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class J8StreamsBasics {

	
	/*
	 * 
	 * We just want to know the sum of integers but we would also have to provide how the iteration will take place, this is also called external iteration because client program is handling the algorithm to iterate over the list.
	 *The program is sequential in nature, there is no way we can do this in parallel easily.
	 *There is a lot of code to do even a simple task.
	 * 
	 */
	private static int sumIterator(List<Integer> list){
		Iterator<Integer> it = list.iterator();
		int sum = 0;
		while(it.hasNext()){
			int num = it.next();
			if(num>10){
				sum+=sum;
			}
		}
		return sum;
	}
	
	private static int sumAsStream(List<Integer> list){
		return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
	}
	
	/*
	*A collection is an in-memory data structure to hold values and before we start using collection, all the values should have been populated. 
	*Whereas a java Stream is a data structure that is computed on-demand.
	*
	*Java 8 Stream internal iteration principle helps in achieving lazy-seeking in some of the stream operations.
	* For example filtering, mapping, or duplicate removal can be implemented lazily, allowing higher performance and scope for optimization.
	*/
	
	
	/*
	 * Java 8 Stream support sequential as well as parallel processing, 
	 * parallel processing can be very helpful in achieving high performance for large collections.
	 * TODO:try an example
	 * 
	 * 
	 * All the Java Stream API interfaces and classes are in the java.util.stream package. Since we can use primitive data types such as
	 *  int, long in the collections using auto-boxing and these operations could take a lot of time,
	 *   there are specific classes for primitive types – IntStream, LongStream and DoubleStream.
	 */
	
	
	/*
	 * ::::::::::::::::::::::Functional Interfaces in Java 8 Stream::::::::::::::::::::
	 * 
	 * 1. Function and BiFunction: Function represents a function that takes one type of argument and returns another type of argument.
	 * Function<T, R> is the generic form where T is the type of the input to the function and R is the type of the result of the function.
	 * examples:
	 * mapToInt()
	 * flatMapToInt()
	 * 
	 * 2.Predicate and BiPredicate: It represents a predicate against which elements of the stream are tested. 
	 * This is used to filter elements from the java stream. Just like Function, there are primitive specific interfaces for int, long and double.
	 * Some of the Stream methods where Predicate or BiPredicate specializations are used are:
	 * Stream<T> filter(Predicate<? super T> predicate)
		boolean anyMatch(Predicate<? super T> predicate)
		boolean allMatch(Predicate<? super T> predicate)
		boolean noneMatch(Predicate<? super T> predicate)
	 * 
	 * 
	 * 3.Consumer and BiConsumer: It represents an operation that accepts a single input argument and returns no result.
	 *  It can be used to perform some action on all the elements of the java stream.
	 * Some of the Java 8 Stream methods where Consumer, BiConsumer or it’s primitive specialization interfaces are used are:
	 * Stream<T> peek(Consumer<? super T> action)
	 *  void forEach(Consumer<? super T> action)
	 *	void forEachOrdered(Consumer<? super T> action)
	 *
	 *
	 * 4. Supplier: Supplier represent an operation through which we can generate new values in the stream. 
	 * 
	 * 
	 * java.util.Optional
	 * Java Optional is a container object which may or may not contain a non-null value.
	 *  If a value is present, isPresent() will return true and get() will return the value.
	 *   Stream terminal operations return Optional object. Some of these methods are:
	 *   Optional<T> reduce(BinaryOperator<T> accumulator)
	 *   Optional<T> min(Comparator<? super T> comparator)
	 *   Optional<T> max(Comparator<? super T> comparator)
	 *   Optional<T> findFirst()
	 *   Optional<T> findAny()
	 *   
	 *   
	 *   For supporting parallel execution in Java 8 Stream API,
	 *    Spliterator interface is used. Spliterator trySplit method returns a new Spliterator that manages a subset of the elements of the original Spliterator.
	 *    
	 *  ::::Java Stream Intermediate and Terminal Operations::::
	 *  Java Stream API operations that returns a new Stream are called intermediate operations.
     *  Most of the times, these operations are lazy in nature, so they start producing new stream elements and send it to the next operation.
     *  Intermediate operations are never the final result producing operations. 
     *  Commonly used intermediate operations are filter and map.
     *  
     *  Java 8 Stream API operations that returns a result or produce a side effect are called terminal operations.
     *  Once the terminal method is called on a stream, it consumes the stream and after that we can’t use stream. 
     *  Commonly used terminal methods are forEach, toArray, min, max, findFirst, anyMatch, allMatch etc. 
     *  You can identify terminal methods from the return type, they will never return a Stream.
     *  
     *  ::::Java Stream Short Circuiting Operations:::: 
     *  An intermediate operation is called short circuiting, 
     *  if it may produce finite stream for an infinite stream. 
     *  For example limit() and skip() are two short circuiting intermediate operations.
     *  A terminal operation is called short circuiting,
     *  if it may terminate in finite time for infinite stream. For example anyMatch, allMatch, noneMatch, findFirst and findAny are short circuiting terminal operations.
	 */
	
	public static void main(String[] args){
		J8StreamsBasics j8 = new J8StreamsBasics();
		//j8.sumIterator(list)
		
		 BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> " Bi-Function Result:" +(num1 + num2);
	     System.out.println(biFunction.apply(20,25));
	        
	     BiPredicate<Integer,String> condition = (i , s) -> i > 20 && s.startsWith("R");
	     System.out.println(condition.test(10,"Ram"));
	     System.out.println(condition.test(30,"Shyam"));
	     System.out.println(condition.test(30,"Ram"));
	     
	     Map<Integer,String> map = new HashMap<Integer,String>();
	     map.put(1, "alfu");
	     map.put(2, "ashar");
	     map.put(3, "babby");
	     
	     BiConsumer<Integer,String> biConsumer = (key,value) -> System.out.println("Key:"+ key+" Value:"+ value);
	     map.forEach(biConsumer);
		
	     
	}
	
}
