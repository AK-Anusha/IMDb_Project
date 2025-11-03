package com.Practice.SpringSecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository_Interface extends JpaRepository<ProductEntity,Long>{

	
}
