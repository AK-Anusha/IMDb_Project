package com.Practice.APIs.DataJPA_MySQL.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_table")
public class Employee {

	@Id
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
