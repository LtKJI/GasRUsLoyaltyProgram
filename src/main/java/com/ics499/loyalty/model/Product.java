package com.ics499.loyalty.model;


import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Product")
public class Product {

    @Column(name="price")
	double price;

	@Column(name="product_name")
	String productName;

	@GeneratedValue @Id Long productID;
	static long productIdCounter = 0;
	
	
	@Autowired
	public Product(double p, String pN/*, PointStrategy pS*/) {
		price = p;
		productName = pN;
		productID = productIdCounter;
		productIdCounter++;
		//pointStrat = pS;
	}
	
	public Product() {
		price = 0;
		productName = "___";
		productID = (long) 0;
		//pointStrat = pS;
	}

	//Getters and Setters

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", productName=" + productName + ", productID=" + productID + "]";
	}
	
	

	/*public PointStrategy getPointStrat() {
		return pointStrat;
	}

	public void setPointStrat(PointStrategy pointStrat) {
		this.pointStrat = pointStrat;
	}*/
}


