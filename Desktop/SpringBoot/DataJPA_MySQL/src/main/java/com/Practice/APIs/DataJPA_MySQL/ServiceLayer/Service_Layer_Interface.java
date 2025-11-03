package com.Practice.APIs.DataJPA_MySQL.ServiceLayer;

import java.util.List;

import com.Practice.APIs.DataJPA_MySQL.Model.Employee;

public interface Service_Layer_Interface {

	public String AddNewEmployee(Employee e);
	public String UpdateExistingEmployee(Employee e);
	public String DeleteEmpById(String ID);
	public Employee GetEmployeeById(String ID);
	public List<Employee> GetAllEmployees();
	
	
}
