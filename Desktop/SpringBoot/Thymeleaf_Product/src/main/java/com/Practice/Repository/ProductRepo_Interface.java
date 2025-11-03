package com.Practice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Practice.Model.Product;

@Repository
public interface ProductRepo_Interface extends JpaRepository<Product,String>{

}
