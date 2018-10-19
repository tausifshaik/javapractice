package com.learning.basics.collections;

import java.io.*; 
import java.util.*;
	/*
	 * HashMap and HashSet use the hashcode value of an object to find out how the object would be stored in the collection, 
	 * and subsequently hashcode is used to help locate the object in the collection.
	 *  Hashing retrieval involves:
	 *  First, find out the right bucket using hashCode().
	 *  Secondly, search the bucket for the right element using equals()
	 */
	
	/*
	 * Case 1: Overriding both equals(Object) and hashCode() method (See class EqualsHashCodeQs.java)
	 * 
	 * Case 2 : Overriding only the equals(Object) method:(SEE below example)
	 * If we only override equals(Object) method, when we call map.put(g1, “CSE”);
	 *  it will hash to some bucket location and when we call map.put(g2, “IT”); 
	 *  it will hash to some other bucket location because of different hashcode value as hashCode() method has not been overridden.
	 *  
	 * Case 3: Overriding only hashCode() method
	 * When we call map.put(“xyz”, “CSE”); it will generate hashcode value and stores it to the bucket location that is specified with this address (hashcode value). 
	 * And when we call map.put(“xyz”, “IT”); it generates same hashcode value as previous entry since key objects are same and hashCode() method has been overridden. 
	 * So it should replace first with second as per rule. But it didn’t.
	 *  Reason is, when it iterate through that bucket and seeks to find k such that k.equals(“xyz”) i.e. if searching key already exist. 
	 *  But it fails to find because equals(Object ) method has not been overridden. It is violation of rule of hashing.
	 * 
	 */
//Java program to illustrate 
//Overriding only the equals(Object) method 
 

class Geek1  
{ 
 String name; 
 int id; 
    
 Geek1(String name, int id) 
 { 
     this.name = name; 
     this.id = id; 
  } 
    
 @Override
 public boolean equals(Object obj) 
 { 
    // if both the object references are  
    // referring to the same object. 
    if(this == obj) 
         return true; 
         
     // it checks if the argument is of the  
     // type Geek by comparing the classes  
     // of the passed argument and this object. 
     // if(!(obj instanceof Geek)) return false; ---> avoid. 
     if(obj == null || obj.getClass()!= this.getClass()) 
         return false; 
         
     // type casting of the argument.     
     Geek1 geek = (Geek1) obj; 
         
     // comparing the state of argument with  
     // the state of 'this' Object. 
     return (geek.name == this.name && geek.id == this.id); 
 } 
} 

class GFG1  
{ 
 public static void main (String[] args)  
 { 
       
     // creating two Objects with  
     // same state 
     Geek1 g1 = new Geek1("aditya", 1); 
     Geek1 g2 = new Geek1("aditya", 1); 
       
     Map<Geek1, String> map = new HashMap<Geek1, String>(); 
     map.put(g1, "CSE"); 
     map.put(g2, "IT"); 
       
     for(Geek1 geek : map.keySet()) 
     { 
         System.out.println(map.get(geek).toString()); 
     } 

 } 
}
/*
 * OUTPUT:
 * CSE
 * IT
 * */
