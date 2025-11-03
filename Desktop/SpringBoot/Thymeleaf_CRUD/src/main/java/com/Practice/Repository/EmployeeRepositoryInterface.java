package com.Practice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Practice.Model.EmployeeModel;

@Repository
public interface EmployeeRepositoryInterface extends JpaRepository<EmployeeModel, Integer>{

	
	
}
