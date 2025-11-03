package com.Practice.BasicEmployee_API.model;

public class Employee {

	private String ID;
	private String Name;
	private String Email;
	
	
	public Employee() {
	}
	public Employee(String iD, String name, String email) {
		super();
		ID = iD;
		Name = name;
		Email = email;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
	
}
