package com.ics499.loyalty.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.loyalty.model.Transaction;
import com.ics499.loyalty.repositories.TransactionRepo;

@RestController
@RequestMapping ("/transactions")
public class TransactionController {

	private TransactionRepo transactionRepo;
	
	@GetMapping ("/all")
	public List<Transaction> list(){
		return transactionRepo.findAll();
	}
	
	@GetMapping ("/id")
	public Transaction getByID (@PathVariable int id) {
		return transactionRepo.getOne(id);
	}
	
	@PostMapping
	public Transaction add (@RequestBody final Transaction transaction) {
		return transactionRepo.saveAndFlush(transaction);
	}

}
