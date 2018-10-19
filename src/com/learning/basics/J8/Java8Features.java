package com.learning.basics.J8;

public class Java8Features {
	
	/*
	 * Java 8 interface changes include static methods and default methods in interfaces. 
	 * Prior to Java 8, we could have only method declarations in the interfaces. 
	 * But from Java 8, we can have default methods and static methods in the interfaces.
	 * 
	 * Why this feature was introduced?
	 * Designing interfaces have always been a tough job because if we want to add additional methods in the interfaces, it will require change in all the implementing classes.
	 * As interface grows old, the number of classes implementing it might grow to an extent that it’s not possible to extend interfaces. 
	 * That’s why when designing an application, most of the frameworks provide a base implementation class and then we extend it and override methods that are applicable for our application
	 * 
	 * 
	 */
	
	// check J8 Interface default methods
	
	/*
	 * 1. Java interface default methods will help us in extending interfaces without having the fear of breaking implementation classes.
	 * 2. Java interface default methods has bridge down the differences between interfaces and abstract classes.(you should know the difference between interface and abstract class)
	 * 3. Java 8 interface default methods will help us in avoiding utility classes, such as all the Collections class method can be provided in the interfaces itself.
	 * 4. Java interface default methods will help us in removing base implementation classes, we can provide default implementation and the implementation classes can chose which one to override.
	 * 5. One of the major reason for introducing default methods in interfaces is to enhance the Collections API in Java 8 to support lambda expressions.
	 * 6. If any class in the hierarchy has a method with same signature, then default methods become irrelevant. A default method cannot override a method from java.lang.Object.
	 * 
	 */
	
	
	// check J8 Interface static methods
	
	/*
	 * Java interface static method is similar to default method except that we can’t override them in the implementation classes. 
	 * This feature helps us in avoiding undesired results in case of poor implementation in implementation classes.
	 * 
	 * 1. Java interface static method is part of interface, we can’t use it for implementation class objects.
	 * 2. Java interface static methods are good for providing utility methods, for example null check, collection sorting etc.
	 * 3. Java interface static method helps us in providing security by not allowing implementation classes to override them.
	 * 4. We can’t define interface static method for Object class methods, we will get compiler error as “This static method cannot hide the instance method from Object”. 
	 * 5. We can use java interface static methods to remove utility classes such as Collections and 
	 *    move all of it’s static methods to the corresponding interface, that would be easy to find and use.
	 * 
	 * 
	 */
	
	
	/*
	 * LAMBDA EXPRESSIONS:
	 * Lambda Expression are the way through which we can visualize functional programming in the java object oriented world. 
	 * Objects are the base of java programming language and we can never have a function without an Object,
	 * that’s why Java language provide support for using lambda expressions only with functional interfaces.
	 * 
	 * Since there is only one abstract function in the functional interfaces, there is no confusion in applying the lambda expression to the method.
	 * Lambda Expressions syntax is (argument) -> (body). Now let’s see how we can write above anonymous Runnable using lambda expression.
	 * 
	 * 
	 * Reduced Lines of Code
	 * Sequential and Parallel Execution Support
	 * 
	 * 
	 */
	
	Runnable r = () -> System.out.println("My Runnable");
	public static void main(String [] args){
		
		
	}

}
