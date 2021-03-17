package com.ics499.loyalty.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Transaction")
public class Transaction {


	@Id
	@Column(name = "TransactionID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int transactionID;
	
	@Column (name = "Date")
	@Temporal (TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	@Column (name = "Subtotal")
	private float subtotal;
	
	@Column (name = "Discount")
	private float discounts;
	
	@Column (name = "Tax")
	private float tax;
	
	@ManyToOne
	private LoyaltyAccount loyalty;
	
	@OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable (
					name = "Transaction_Product",
					joinColumns = @ JoinColumn (name = "transactionID"),
					inverseJoinColumns = @JoinColumn (name = "productID"))
	private ArrayList <Product> products;

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getDiscounts() {
		return discounts;
	}

	public void setDiscounts(float discounts) {
		this.discounts = discounts;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public LoyaltyAccount getLoyalty() {
		return loyalty;
	}

	public void setLoyalty(LoyaltyAccount loyalty) {
		this.loyalty = loyalty;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
	
}	
