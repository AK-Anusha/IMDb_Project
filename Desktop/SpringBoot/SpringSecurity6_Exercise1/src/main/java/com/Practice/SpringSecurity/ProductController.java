package com.Practice.SpringSecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository_Interface productRepo;

    private record Product(Integer id, String name, double price, Integer quantity) {}

    List<Product> products = new ArrayList<>(
            List.of(new Product(1, "Mac_Laptop", 80000, 100))
    );

    @GetMapping("/currentProducts")
    public List<Product> getProducts() {
        return products;
    }
    
    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
    	
    }

    @PostMapping("/savingProduct")
    public Product addProducts(@RequestBody Product p) {
        products.add(p);
        return p;
    }
}
