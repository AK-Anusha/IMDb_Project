package com.Practice.BasicEmployee_API.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Practice.BasicEmployee_API.model.Employee;

@RestController
@RequestMapping("/EmployeePage")
public class EmployeeAPI_Controller {

	Employee e = new Employee();
	@GetMapping("{ID}")
	public Employee getEmployeeInfo(String ID) {
		return e;
	}
	
	@PostMapping
	public String createNewEmpData(@RequestBody Employee e) {
		this.e = e;
		return "Created New Employee details";
	}
	@PutMapping
	public String UpdateEmpData(@RequestBody Employee e) {
		this.e = e;
		return "Updated Employee details";
	}
	@DeleteMapping("{ID}")
	public String DeleteEmpData(String ID) {
		this.e = null;
		return "Deleted Employee details based on given ID";
	}
}
