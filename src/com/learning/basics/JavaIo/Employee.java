package com.learning.basics.JavaIo;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -299482035708790407L;

	private String name;
	
	private String gender;
	private int age;

	//private String role;
	 private transient String role;
	 private int salary;
	 private String address;

	

	public Employee(String n) {
		this.name = n;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee:: Name=" + this.name + " Age=" + this.age + " Gender=" + this.gender + " Role=" + this.role;
	}
}