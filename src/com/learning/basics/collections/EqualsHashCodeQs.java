package com.learning.basics.collections;

	/*
	 * Equals and HashCode methods in Java are two fundamental methods from java.lang.Object class,
	 *  which is used to compare equality of objects, primarily inside hash based collections such as Hashtable and HashMap. 
	 *  default equals() method return true if two objects are exactly same i.e. they are pointing to the same memory address
	 *   default implementation of hashcode method return int
	 *   
	 *   Java.lang.object has two very important methods defined: public boolean equals(Object obj) and public int hashCode().
	 *   
	 */
	
	/*
	 * equals() method
	 * In java equals() method is used to compare equality of two Objects. The equality can be compared in two ways:
	 * Shallow comparison: The default implementation of equals method is defined in Java.lang.Object class which simply checks
	 *  if two Object references (say x and y) refer to the same Object. i.e. It checks if x == y.
	 *  Since Object class has no data members that define its state, it is also known as shallow comparison.
	 * Deep Comparison: Suppose a class provides its own implementation of equals() method in order to compare the Objects of that class w.r.t state of the Objects.
	 *  That means data members (i.e. fields) of Objects are to be compared with one another. Such Comparison based on data members is known as deep comparison.
	 */
	
	/*
	 * Principles of equals():If some other object is equal to a given object, then it follows these rules:
	 *  1.Reflexive : for any reference value a, a.equals(a) should return true.
	 *  2.Symmetric : for any reference values a and b, if a.equals(b) should return true then b.equals(a) must return true.
	 *	3.Transitive : for any reference values a, b, and c, if a.equals(b) returns true and b.equals(c) returns true, then a.equals(c) should return true.
	 *	4.Consistent : for any reference values a and b, multiple invocations of a.equals(b) consistently return true or consistently return false, provided no information used in equals comparisons on the object is modified.
	 */
	
	

//Java program to illustrate  
//how hashCode() and equals() methods work 
import java.io.*;
import java.util.HashMap;
import java.util.Map; 

class Geek  
{ 
   
 public String name; 
 public int id; 
       
 Geek(String name, int id)  
 { 
           
     this.name = name; 
     this.id = id; 
 } 
   
 @Override
 public boolean equals(Object obj) 
 { 
       
 // checking if both the object references are  
 // referring to the same object. 
 if(this == obj) 
         return true; 
       
     // it checks if the argument is of the  
     // type Geek by comparing the classes  
     // of the passed argument and this object. 
     // if(!(obj instanceof Geek)) return false; ---> avoid. 
 /*
  * Line (b) ensures that it will return false 
  * if passed argument is an Object of subclass of class Geek. But the instanceof operator condition does not return false if it found the passed argument is a subclass of the class Geek.
  */
     if(obj == null || obj.getClass()!= this.getClass()) 
         return false; 
       
     // type casting of the argument.  
     Geek geek = (Geek) obj; 
       
     // comparing the state of argument with  
     // the state of 'this' Object. 
     return (geek.name == this.name && geek.id == this.id); 
 } 
   
 @Override
 public int hashCode() 
 { 
       
     // We are returning the Geek_id  
     // as a hashcode value. 
     // we can also return some  
     // other calculated value or may 
     // be memory address of the  
     // Object on which it is invoked.  
     // it depends on how you implement  
     // hashCode() method. 
     return this.id; 
 } 
   
} 

//Driver code 
class GFG 
{ 
   
 public static void main (String[] args) 
 { 
   
     // creating the Objects of Geek class. 
     Geek g1 = new Geek("aa", 1); 
     Geek g2 = new Geek("aa", 1); 
       
     // comparing above created Objects. 
     if(g1.hashCode() == g2.hashCode()) 
     { 

         if(g1.equals(g2)) 
             System.out.println("Both Objects are equal. "); 
         else
             System.out.println("Both Objects are not equal. "); 
   
     } 
     else
     System.out.println("Both Objects are not equal. ");  
     
     Map<Geek, String> map = new HashMap<Geek, String>(); 
     map.put(g1, "CSE"); 
     map.put(g2, "IT"); 
       
     for(Geek geek : map.keySet()) 
     { 
         System.out.println(map.get(geek).toString()); 
     } 
 }  
} 

/*
 * OUTPUT : IT
 * When we call map.put(g1, “CSE”); it will hash to some bucket location and when we call map.put(g2, “IT”);,
 *  it will generates same hashcode value (same as g1) and replace first value by second value because
 *   while iterating over same bucket it found a k such that k.equals(g2) is true, means searching key already exist. 
 *   So, it replaces old value of that key by new value.
 */

/*
 * hashCode() method
 * It returns the hashcode value as an Integer. Hashcode value is mostly used in hashing based collections like HashMap, HashSet, HashTable….etc. 
 * This method must be overridden in every class which overrides equals() method.
		Syntax :

		public int hashCode()
  * General Contract for hashCode():
  * 1. During the execution of the application, if hashCode() is invoked more than once on the same Object then it must consistently return the same Integer value, 
  * provided no information used in equals(Object) comparison on the Object is modified. 
  * 2.If two Objects are equal, according to the the equals(Object) method, then hashCode() method must produce the same Integer on each of the two Objects.
  * 3.If two Objects are unequal, according to the the equals(Object) method, It is not necessary the Integer value produced by hashCode() method on each of the two Objects will be distinct.
  *  It can be same but producing the distinct Integer on each of the two Objects is better for improving the performance of hashing based Collections like HashMap, HashTable…etc.
  * 
   */

