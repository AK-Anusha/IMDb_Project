package com.Practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Practice.Model.Product;
import com.Practice.Repository.ProductRepo_Interface;

@Controller
public class ProductController {

	@Autowired
	private ProductRepo_Interface Repo;
	
	/* *** method to get all products listed on the page ***** */
	
	@GetMapping({"/AllProducts", "/", "/list"})						
	public ModelAndView getAllProducts() {
		ModelAndView mavObj = new ModelAndView("ProductHomePage_ThymeleafTemplate");
		List<Product> list = Repo.findAll();
		mavObj.addObject("Products", list);
		return mavObj;
	}
	
	/* *** method to add new product into the page *** */
	
	@GetMapping("/AddNewProduct")
	public ModelAndView AddNewProduct() {
	    ModelAndView mavObj = new ModelAndView("AddProductForm_ThymeleafTemplate");
	    Product ProdObj = new Product();
	    mavObj.addObject("p", ProdObj);
	    return mavObj;
	}

	
	/* *** method to post newly added product details from the product form to product table *** */
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute Product p) {
		Repo.save(p);
		return "redirect:/list";
	}
	
	/* *** method to update the product details using update form by product Id *** */
	
	  @GetMapping("/ShowUpdateForm")
	    public ModelAndView UpdateProduct(@RequestParam String id) {
	        ModelAndView mav = new ModelAndView("UpdateProductForm_ThymeleafTemplate");
	        Product prodObj = Repo.findById(id).get();
	        mav.addObject("p", prodObj);
	        return mav;
	    }
	
	@GetMapping("/DeleteProduct")
	public String deleteProduct(@RequestParam String id) {
		Repo.deleteById(id);
		return "redirect:/list";
	}
	
	
	
	
	
	
}
