package com.ics499.loyalty.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.loyalty.model.Product;
import com.ics499.loyalty.repositories.ProductRepo;
import java.util.Optional;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired 
	private ProductRepo productRepo;
	
	private HashMap<String, Product> products = new HashMap<String, Product>();
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Product> all() {
		StringBuilder displayProducts = new StringBuilder();
		for (String i: products.keySet()) {
			displayProducts.append("" + products.get(i).toString() + ", ");
		}
		
		return productRepo.findAll();
	}
	
	 @GetMapping("/get/{id}")
		public Optional<Product> getProduct(@PathVariable("id") Long id) {
			return productRepo.findById(id);
	}
	 
	//  @GetMapping("/get/{price}")
	// 	public double getPrice(@PathVariable("price") Product product) {
	// 		return products.get(product).getPrice();
	// }
	 
	 @PostMapping("/add")
		public String addProduct(@RequestBody String name, @RequestBody double price) {
	        products.put(name, new Product(price, name));
	        productRepo.save(new Product(price, name));
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
