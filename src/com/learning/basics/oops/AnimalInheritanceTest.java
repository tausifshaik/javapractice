package com.learning.basics.oops;

public class AnimalInheritanceTest {

	public static void main(String[] args) {
		Cat cat = new Cat(false, "milk", 4, "black");
		System.out.println("Cat is Vegetarian?" + cat.isVegetarian());
		System.out.println("Cat eats " + cat.getEats());
		System.out.println("Cat has " + cat.getNoOfLegs() + " legs.");
		System.out.println("Cat color is " + cat.getColor());
	}
	
	/*
	 * Important Points for Inheritance in Java
	Most important benefit of inheritance is code reuse because subclasses inherits the variables and methods of superclass.
	Private members of superclass are not directly accessible to subclass. 
	 As in this example, Animal variable noOfLegs is not accessible to Cat class but it can be indirectly accessible via getter and setter methods.
	Superclass members with default access is accessible to subclass ONLY if they are in same package.
	Superclass constructors are not inherited by subclass.
	If superclass doesn’t have default constructor, then subclass also needs to have an explicit constructor defined. Else it will throw compile time exception.
	 In the subclass constructor, call to superclass constructor is mandatory in this case and it should be the first statement in the subclass constructor.
	Java doesn’t support multiple inheritance, a subclass can extends only one class.
	 So here Animal is implicitly extending Object class and Cat is extending Animal class but due to java inheritance transitive nature, Cat class also extends Object class.
	 We can create an instance of subclass and then assign it to superclass variable, this is called upcasting. Below is a simple example of upcasting:

			Cat c = new Cat(); //subclass instance
			Animal a = c; //upcasting, it's fine since Cat is also an Animal
	When an instance of Superclass is assigned to a Subclass variable, then it’s called downcasting. We need to explicitly cast this to Subclass. For example;
			Cat c = new Cat();
			Animal a = c;
			Cat c1 = (Cat) a; //explicit casting, works fine because "c" is actually of type Cat
			
	We can override the method of Superclass in the Subclass.
	 However we should always annotate overridden method with @Override annotation so that Compiler knows that we are overriding a method and if something changes in the superclass method, we get to know at compile time rather than getting unwanted results at the runtime.
	We can call the superclass methods and access superclass variables using super keyword. 
	 It comes handy when we have a same name variable/method in the subclass but we want to access the superclass variable/method.
	 This is also used when Constructors are defined in the superclass and subclass and we have to explicitly call the superclass constructor.
	We can use instanceof instruction to check the inheritance between objects,
	  
	  	Cat c = new Cat();
		Dog d = new Dog();
		Animal a = c;
		
		boolean flag = c instanceof Cat; //normal case, returns true
		
		flag = c instanceof Animal; // returns true since c is-an Animal too
		
		flag = a instanceof Cat; //returns true because a is of type Cat at runtime
		
		flag = a instanceof Dog; //returns false for obvious reasons.
		
		We can’t extend Final classes in java.
		If you are not going to use Superclass in the code i.e your Superclass is just a base to keep reusable code then you can keep them as 
		Abstract class to avoid unnecessary instantiation by client classes. It will also restrict the instance creation of base class.
	 */

}
