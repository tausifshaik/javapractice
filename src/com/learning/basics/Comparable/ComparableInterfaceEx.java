package com.learning.basics.Comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableInterfaceEx {
	
	/*
	 * Comparable and Comparator in Java are very useful for sorting collection of objects. 
	 * Java provides some inbuilt methods to sort primitive types array or Wrapper classes array or list. 
	 * Here we will first learn how we can sort an array/list of primitive types and wrapper classes and
	 * then we will use java.lang.Comparable and java.util.Comparator interfaces to sort array/list of custom classes.
	 */
	public static void main(String[] args) {
		//sort primitives array like int array
        int[] intArr = {5,9,1,10};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));
        
        //sorting String array
        String[] strArr = {"A", "C", "B", "Z", "E"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
        
        //sorting list of objects of Wrapper classes
        List<String> strList = new ArrayList<String>();
        strList.add("A");
        strList.add("C");
        strList.add("B");
        strList.add("Z");
        strList.add("E");
        Collections.sort(strList);
        for(String str: strList) System.out.print(" "+str);
        ComparableInterfaceEx x = new ComparableInterfaceEx();
        Employee[] empArr = new Employee[4];
        empArr[0] = x .new Employee(10, "Mikey", 25, 10000);
        empArr[1] = x .new Employee(20, "Arun", 29, 20000);
        empArr[2] = x .new Employee(5, "Lisa", 35, 5000);
        empArr[3] = x .new Employee(1, "Pankaj", 32, 50000);

        //sorting employees array using Comparable interface implementation
        Arrays.sort(empArr);
        System.out.println("Default Sorting of Employees list:\n"+Arrays.toString(empArr));

	}
	/*
	 * Java provides Comparable interface which should be implemented by any custom class if we want to use Arrays or Collections sorting methods. 
	 * Comparable interface has compareTo(T obj) method which is used by sorting methods, you can check any Wrapper, String or Date class to confirm this.
	 *  We should override this method in such a way that it returns a negative integer, zero, 
	 *  or a positive integer if “this” object is less than, equal to, or greater than the object passed as argument.
	 *  After implementing Comparable interface in Employee class, here is the resulting Employee class.
	 */
	
	/*
	 * But, in most real life scenarios, we want sorting based on different parameters.
	 *  For example, as a CEO, I would like to sort the employees based on Salary,
	 *   an HR would like to sort them based on the age. 
	 *   This is the situation where we need to use Java Comparator interface because
	 *    Comparable.compareTo(Object o) method implementation can sort based on one field only and we can’t chose the field on which we want to sort the Object.
	 */
	public class Employee implements Comparable<Employee> {

	    private int id;
	    private String name;
	    private int age;
	    private long salary;

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public long getSalary() {
	        return salary;
	    }

	    public Employee(int id, String name, int age, int salary) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	    }
	    @Override
	    public int compareTo(Employee emp) {
	        //let's sort the employee based on id in ascending order
	        //returns a negative integer, zero, or a positive integer as this employee id
	        //is less than, equal to, or greater than the specified object.
	        return (this.id - emp.id);
	    }

	    
	    @Override
	    //this is overriden to print the user friendly information about the Employee
	    public String toString() {
	        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
	                this.salary + "]";
	    }

	}
}

