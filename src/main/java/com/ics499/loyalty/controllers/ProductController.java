package com.ics499.loyalty.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.loyalty.model.Product;
import com.ics499.loyalty.repositories.ProductRepo;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	private ProductRepo productRepo;
	
	private HashMap<String, Product> products = new HashMap<String, Product>();
	static private int productIncrement = 0;
	
	@Autowired
	public ProductController() {
		
	}
	
	@GetMapping("/all")
	public String all() {
		StringBuilder displayProducts = new StringBuilder();
		for (String i: products.keySet()) {
			displayProducts.append("" + products.get(i).toString() + ", ");
		}
		
		return displayProducts.toString();
	}
	
	 @GetMapping("/get/{product}")
		public String getProduct(@PathVariable("product") Product product) {
			return products.get(product).toString();
	}
	 
	 @GetMapping("/get/{price}")
		public double getPrice(@PathVariable("price") Product product) {
			return products.get(product).getPrice();
	}
	 
	 @PostMapping("/add")
		public String addProduct(@RequestBody String name, @RequestBody double price) {
	        products.put(name, new Product(price, name));
	        productIncrement++;
	        return "{\"message\": \"New product " + name + " added.\"}";
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
	
	public String demo() {
		return "demo successful";
	}
}
