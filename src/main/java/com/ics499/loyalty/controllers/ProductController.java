package com.ics499.loyalty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ics499.loyalty.model.Product;
import com.ics499.loyalty.repositories.ProductRepo;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Product> all() {
		return productRepo.findAll();
	}
	
	@GetMapping("/get/{id}")
	public @ResponseBody Optional<Product> getProduct(@PathVariable("id") Long id) {
		return productRepo.findById(id);
	}
	 
	@PostMapping("/add")
	public @ResponseBody Product addProduct(@RequestBody String name, double price) {
	       return productRepo.save(new Product(price, name));
	}	 
	

/**
 * COMMENTED OUT FOR DEMOING PURPOSES
 * 
 */
//	@GetMapping("/all")
//	public List<Product> ProductList(){
//		return productRepo.findAll();
//	}
//	
//	@GetMapping("/price")
//	public Product getPrice(Long price) {
//		return productRepo.getOne(price);
//	}
//
//	@GetMapping("/name")
//	public Product getProductName(Long name) {
//		return productRepo.getOne(name);
//	}
//
//	@GetMapping("/id")
//	public Product getProductID(Long id) {
//		return productRepo.getOne(id);
//	}
//	
//	@PostMapping("/create")
//	public Product create(final Product product) {
//		
//		
//		return productRepo.saveAndFlush(product);
//	}
//	
//	@PostMapping("/delete")
//	public void delete(final Product product) {
//		productRepo.delete(product);
//	}
	
	// public String demo() {
	// 	return "demo successful";
	// }
}
