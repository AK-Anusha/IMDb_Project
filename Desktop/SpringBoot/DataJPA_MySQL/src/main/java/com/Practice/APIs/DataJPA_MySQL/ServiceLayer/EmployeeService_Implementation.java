package com.Practice.APIs.DataJPA_MySQL.ServiceLayer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Practice.APIs.DataJPA_MySQL.Model.Employee;
import com.Practice.APIs.DataJPA_MySQL.Repository.Employee_Repository;

@Service
public class EmployeeService_Implementation implements Service_Layer_Interface {

	Employee_Repository ER;
	public EmployeeService_Implementation(Employee_Repository eR) {
		ER = eR;
	}

	@Override
	public String AddNewEmployee(Employee e) {
		ER.save(e);
		return "success";
	}

	@Override
	public String UpdateExistingEmployee(Employee e) {
		ER.save(e);
		return "success";
	}

	@Override
	public Employee GetEmployeeById(String ID) {
		return ER.findById(ID).get();
	}

	@Override
	public List<Employee> GetAllEmployees() {
		return ER.findAll();
	}

	@Override
	public String DeleteEmpById(String ID) {
		ER.deleteById(ID);
		return "success";
	}

	
}
