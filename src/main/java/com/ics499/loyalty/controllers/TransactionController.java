package com.ics499.loyalty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.ics499.loyalty.model.Transaction;
import com.ics499.loyalty.repositories.TransactionRepo;

@Controller
@RequestMapping ("/transactions")
public class TransactionController {
	@Autowired
	private TransactionRepo transactionRepo;
	
	@GetMapping ("/all")
	public @ResponseBody Iterable<Transaction> list(){
		return transactionRepo.findAll();
	}
	
	@GetMapping ("/id")
	public Optional<Transaction> getByID (@PathVariable int id) {
		return transactionRepo.findById(id);
	}
	
	@PostMapping
	public @ResponseBody Transaction add (@RequestBody final Transaction transaction) {
		return transactionRepo.save(transaction);
	}

}
