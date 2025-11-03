package com.Practice.Spring_Security.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ProductController {

	private record Product(Integer Id,String Name, double Price, Integer Quantity) 
	{}
	List<Product> products= new ArrayList<>(
			List.of(new Product(1,"Mac_Laptop",80000,100))
			);
	@GetMapping("/currentProducts")
	public List<Product> getProducts(){
		return products;
	}
	@PostMapping("/savingProduct")
	public Product addProducts(@RequestBody Product p) {
		products.add(p);
		return p; 
	}
	
}
