package com.learning.basics.oops;

/*
 * Inheritance in java is one of the core concepts of Object Oriented Programming.
 * Inheritance is used when we have is-a relationship between objects. Inheritance in Java is implemented using extends keyword.
 * 
 * Inheritance in java is the method to create a hierarchy between classes by inheriting from other classes.
Inheritance in java is transitive – so if Sedan extends Car and Car extends Vehicle, then Sedan is also inherited from Vehicle class. Vehicle becomes the superclass of both Car and Sedan.
Inheritance is widely used in java applications, for example extending Exception class to create an application specific Exception class that contains more information like error codes.
 For example NullPointerException.
 */
public class Animal {

	private boolean vegetarian;

	private String eats;

	private int noOfLegs;

	public Animal(){}

	public Animal(boolean veg, String food, int legs){
		this.vegetarian = veg;
		this.eats = food;
		this.noOfLegs = legs;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public String getEats() {
		return eats;
	}

	public void setEats(String eats) {
		this.eats = eats;
	}

	public int getNoOfLegs() {
		return noOfLegs;
	}

	public void setNoOfLegs(int noOfLegs) {
		this.noOfLegs = noOfLegs;
	}

}