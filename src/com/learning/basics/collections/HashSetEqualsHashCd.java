package com.learning.basics.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEqualsHashCd {
	
	/*
	 * HashSet utilise HashMap for storing it’s elements. 
	 * HashSet works with equals() and hashCode() method to check for duplicate element when you try to add an element.
	 *  Let’s see what happens if you Set object doesn’t provide equals() method implementation.
	 */
	public static void main(String[] args) {
		Set<Emp> emps = new HashSet<>();
		emps.add(new Emp(1,"Pankaj"));
		emps.add(new Emp(2, "David"));
		emps.add(new Emp(1, "Pankaj"));
		
		System.out.println(emps);
		
		/*
		 * So it looks like we were able to store duplicate elements in the Set.
		 *  Actually not, it’s happening because Emp class doesn’t define equals() method, so Object class equals() method implementation is used. 
		 *  So when adding a new element, object reference is being checked rather than content. 
		 *  Hence we have objects with duplicate content, however they are having different references. 
		 *  Let’s see what happens when we define hashCode() and equals() methods in the Emp class.
		 */
		Emp e = new Emp(3, "Lisa");
		emps.add(e);
		System.out.println(emps);
		
		//set values to make it duplicate
		e.setId(1);
		System.out.println(emps);
		e.setName("Pankaj");
		System.out.println(emps);
		/*
		 * Notice that HashSet was able to check for duplicate when we tried to add an element.
		 * But we can change the object values using setter methods and make it duplicate.
		 * It worked because there is no operation done on Set. This is why Immutable objects works better with Set and Map.
		 */
		
	}

}


/*
 * In hashCode() it says:
 * If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
 * If you only override equals() and not hashCode() your class violates this contract.
 * This is also said in the JavaDoc of the equals() method:
 * Note that it is generally necessary to override the hashCode method whenever this method is overridden, so as to maintain the general contract for the hashCode method, which states that equal objects must have equal hash codes.
 */

class Emp {
	private String name;
	private int id;

	public Emp(int i, String n) {
		this.id = i;
		this.name = n;
	}
	@Override
	public boolean equals(Object obj){
		if(obj == null || !(obj instanceof Emp)) return false;
		Emp e = (Emp) obj;
		if(e.getId() == this.getId() && this.getName().equals(e.getName())) return true;
		return false;
	}
	
	@Override
	public int hashCode(){
		return getId();
	}
	@Override
	public String toString(){
		return "{"+id+","+name+"}";
	}
	
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

}