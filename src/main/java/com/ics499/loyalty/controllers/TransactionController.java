package com.ics499.loyalty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.loyalty.model.Transaction;
import com.ics499.loyalty.services.TransactionService;
import java.util.Optional;

@RestController
@RequestMapping ("/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping ("/all")
	public @ResponseBody Iterable<Transaction> list(){
		return transactionService.findAll();
	}
	
	@GetMapping ("/id")
	public Optional<Transaction> getByID (@PathVariable int id) {
		return transactionService.findById(id);
	}
	
	@PostMapping
	public String add (@RequestBody final Transaction transaction) {
		transactionService.add(transaction);
		return "Transaction complete";
	}

}
