package com.learning.basics;

import java.util.ArrayList;
import java.util.List;

/*
 * Autoboxing in java was introduced in Java 1.5. 
 * Autoboxing and unboxing is a convenient way to auto transform primitive data type to it’s corresponding java wrapper classes and vice versa.
 */

/*
 * Autoboxing in Java
	Converting a primitive data type into an object of the corresponding wrapper class is called autoboxing. For example, converting int to Integer or converting long to Long object.

	Java compiler applies autoboxing when a primitive value is:

	Passed as a parameter to a method that expects an object of the corresponding wrapper class. 
	For example a method with Integer argument can be called by passing int, java compiler will do the conversion of int to Integer.
	Assigned to a variable of the corresponding wrapper class. For example, assigning a Long object to long variable.
 */

/*
 * Unboxing in Java
Converting an object of a wrapper type to its corresponding primitive data type is called unboxing.

Java compiler applies unboxing when an object of a wrapper class is:

Passed as a parameter to a method that expects a value of the corresponding primitive type.
Assigned to a variable of the corresponding primitive type.
 */
public class AutoBoxingUnBoxingEx {
	public static void main(String[] args) {
		int i = 5;
		long j = 105L;

		// passed the int, will get converted to Integer object at Runtime using
		// autoboxing in java
		doSomething(i);

		List<Long> list = new ArrayList<>();

		// java autoboxing to add primitive type in collection classes
		list.add(j);
	}

	private static void doSomething(Integer in) {
		// unboxing in java, at runtime Integer.intValue() is called implicitly to
		// return int
		int j = in;

		// java unboxing, Integer is passed where int is expected
		doPrimitive(in);
	}

	private static void doPrimitive(int i) {

	}
}
