package com.Practice.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Practice.Model.EmployeeModel;

public interface EmployeeService_Interface {

	List < EmployeeModel > getAllEmployees();
    void saveEmployee(EmployeeModel employee);
    EmployeeModel getEmployeeById(int id);
    void deleteEmployeeById(int id);
    Page < EmployeeModel > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
