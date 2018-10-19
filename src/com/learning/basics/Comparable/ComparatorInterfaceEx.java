package com.learning.basics.Comparable;

import java.util.Arrays;
import java.util.Comparator;


public class ComparatorInterfaceEx {
	/*
	 * Java Comparator
		Comparator interface compare(Object o1, Object o2) method need to be implemented that takes two Object argument,
		it should be implemented in such a way that it returns negative int if first argument is less than the second one 
		and returns zero if they are equal 
		and positive int if first argument is greater than second one.
	 */
	
	/*
	 * Comparable vs Comparator
		Comparable interface can be used to provide single way of sorting whereas Comparator interface is used to provide different ways of sorting.
		For using Comparable, Class needs to implement it whereas for using Comparator we don’t need to make any change in the class.
		Comparable interface is in java.lang package whereas Comparator interface is present in java.util package.
		We don’t need to make any code changes at client side for using Comparable, Arrays.sort() or Collection.sort() methods automatically uses the compareTo() method of the class.
	    For Comparator, client needs to provide the Comparator class to use in compare() method.
	 */
	public static void main(String[] args) {
		ComparatorInterfaceEx x = new ComparatorInterfaceEx();
        Employee[] empArr = new Employee[4];
        empArr[0] = x .new Employee(10, "Mikey", 25, 10000);
        empArr[1] = x .new Employee(20, "Arun", 29, 20000);
        empArr[2] = x .new Employee(5, "Lisa", 35, 5000);
        empArr[3] = x .new Employee(1, "Pankaj", 32, 50000);
		//sort employees array using Comparator by Salary
		Arrays.sort(empArr, Employee.SalaryComparator);
		System.out.println("Employees list sorted by Salary:\n"+Arrays.toString(empArr));

		//sort employees array using Comparator by Age
		Arrays.sort(empArr, Employee.AgeComparator);
		System.out.println("Employees list sorted by Age:\n"+Arrays.toString(empArr));

		//sort employees array using Comparator by Name
		Arrays.sort(empArr, Employee.NameComparator);
		System.out.println("Employees list sorted by Name:\n"+Arrays.toString(empArr));
	}
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

	    /**
	     * Comparator to sort employees list or array in order of Salary
	     */
	    public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {

	        @Override
	        public int compare(Employee e1, Employee e2) {
	            return (int) (e1.getSalary() - e2.getSalary());
	        }
	    };

	    /**
	     * Comparator to sort employees list or array in order of Age
	     */
	    public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {

	        @Override
	        public int compare(Employee e1, Employee e2) {
	            return e1.getAge() - e2.getAge();
	        }
	    };

	    /**
	     * Comparator to sort employees list or array in order of Name
	     */
	    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

	        @Override
	        public int compare(Employee e1, Employee e2) {
	            return e1.getName().compareTo(e2.getName());
	        }
	    };

	}
	

}
