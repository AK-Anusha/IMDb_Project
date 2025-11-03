package com.Practice.APIs.DataJPA_MySQL.Controller;
import com.Practice.APIs.DataJPA_MySQL.Model.Employee;
import com.Practice.APIs.DataJPA_MySQL.ServiceLayer.Service_Layer_Interface;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/EmployeePage")
public class Employee_Controller {

	Service_Layer_Interface SLI;
	public Employee_Controller(Service_Layer_Interface sLI) {
		this.SLI = sLI;
	}

	@GetMapping("{ID}")
	public Employee getEmployeeInfo(@PathVariable("ID") String ID) {
		return  SLI.GetEmployeeById(ID);
	}
	
	@GetMapping()
	public List<Employee> getAllEmployeesInfo() {
		return  SLI.GetAllEmployees();
	}
	
	@PostMapping
	public String createNewEmpData(@RequestBody Employee e) {
		SLI.AddNewEmployee(e);
		return "Created New Employee details";
	}
	@PutMapping
	public String UpdateEmpData(@RequestBody Employee e) {
		SLI.UpdateExistingEmployee(e);
		return "Updated Employee details";
	}
	@DeleteMapping("{ID}")
	public String DeleteEmpData(@PathVariable("ID") String ID) {
		SLI.DeleteEmpById(ID);
		return "Deleted Employee details based on given ID";
	}
}
