package com.Practice.SpringSecurity.DTO_Validations.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Practice.SpringSecurity.DTO_Validations.Entity.User_Entity;

public interface UserRepository extends JpaRepository<User_Entity,Long>{

	
	
}
