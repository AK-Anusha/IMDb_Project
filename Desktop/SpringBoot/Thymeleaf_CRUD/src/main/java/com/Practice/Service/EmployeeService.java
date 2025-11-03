package com.Practice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Practice.Model.EmployeeModel;
import com.Practice.Repository.EmployeeRepositoryInterface;

@Service
public class EmployeeService implements EmployeeService_Interface{
	
    @Autowired
    private EmployeeRepositoryInterface employeeRepository;

    @Override
    public List < EmployeeModel > getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(EmployeeModel employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public EmployeeModel getEmployeeById(int id) {
        Optional < EmployeeModel > optional = employeeRepository.findById(id);
        EmployeeModel employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Page < EmployeeModel > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
            Sort.by(sortField).descending();

        //gives requested page in requested sorted order 
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }
}