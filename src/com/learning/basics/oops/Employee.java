package com.learning.basics.oops;

public class Employee  extends AbstractPerson {

	public static void main(String[] args) {
		//coding in terms of abstract classes
		AbstractPerson student = new Employee("Dove","Female",0);
		AbstractPerson employee = new Employee("Pankaj","Male",123);
		student.work();
		employee.work();
		//using method implemented in abstract class - inheritance
		employee.changeName("Pankaj Kumar");
		System.out.println(employee.toString());

	}

private int empId;
	
	public Employee(String nm, String gen, int id) {
		super(nm, gen);
		this.empId=id;
	}

	@Override
	public void work() {
		if(empId == 0){
			System.out.println("Not working");
		}else{
			System.out.println("Working as employee!!");
		}
	}
	

}
