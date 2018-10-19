package com.learning.basics.J8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * One of the most frequently exception in java programming is NullPointerException. 
 * A Null value often represents an absence of value which has to be handled before proceeding 
 * with the usual business logic, which leads to unnecessary null checks.
 *	To handle such boiler plate code for null check situations, Java 8 introduced Optional class.
 * 
 * Java 8 stream API and collection methods can return Optional objects.
 *  It may or may not contain a non-null value. 
 *  There are various methods available in the API to deal with the Optional value in a convenient and reliable manner.
 *	Java Optional is a final class.
 * 
 * 
 * 
 */

public class J8Optional_NPE {
	
	public static void main(String[] args){
		
		List<String> listOfNames = Arrays.asList("tausif Nawaz","Asharrr Shaik","baby Shaik");
		
		Optional<String> smallName = listOfNames.stream().filter(str -> str.length() < 12).findAny();
		smallName.ifPresent(System.out::println);
		
		Optional<String> bigName = listOfNames.stream().filter(str -> str.length() > 15).findAny();
		bigName.ifPresent(System.out::println);
		 //System.out.println(bigName.get()); --> will give no such element exception
		 Optional<String> empty = Optional.empty();
		 System.out.println(empty.isPresent());
		 System.out.println(empty.orElse("Default Value"));
		 System.out.println(empty.orElseGet(() -> "Default Value"));
		 Optional<String> opt = Optional.of("static value");
		 System.out.println(opt.get());
		 
		 Optional<Integer> intOptional = Optional.of(34);
		 Optional<Integer> evenIntOptional = intOptional.filter(i -> i % 2 == 0);
		 System.out.println(evenIntOptional.orElse(0));

		 Optional<Integer> oddIntOptional = intOptional.filter(i -> i % 2 != 0);
		 System.out.println(oddIntOptional.orElse(0));
		
		/*
		 * Java Optional Methods
		 * 
		 * 1.static Optional empty(): It creates and returns an empty Optional instance.
		 * 2.boolean isPresent(): It return true if there is a value present, otherwise false.
		 * 3.void ifPresent(Consumer consumer): If a value is present, this method invokes the specified consumer with the value, 
		 * otherwise does nothing. As we can see, in our above example:
		 * 4.T get(): If a value is present in the Optional, this method returns the value, otherwise throws NoSuchElementException.
		 *  As you might have gussed
		 *  System.out.println(largeString.get());
		 * 5.T orElse(T otherValue): This method returns the value if present, otherwise returns the otherValue provided in the argument.
		 *  When we are not sure whether Optional will contain value, it’s always good idea to use this method rather than simple get().
		 *  Optional<String> empty = Optional.empty();
		 *  System.out.println(empty.orElse("Default Value")); 
		 *  
		 *  static Optional<T> of(T value): It returns an Optional with the specified present non-null value.
		 *  Optional<String> opt = Optional.of("static value");
		 *  
		 *  Optional filter(Predicate predicate):
		 *   It takes a predicate as an argument and returns an Optional object. 
		 *   If condition of the predicate is met, then the Optional is returned as is, Otherwise it will return an empty Optional.
		 *   
		 */
		
		
	}

}
