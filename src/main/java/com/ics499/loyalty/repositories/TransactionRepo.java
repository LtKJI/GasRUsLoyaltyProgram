package com.ics499.loyalty.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ics499.loyalty.model.Transaction;

public interface TransactionRepo extends CrudRepository <Transaction , Integer> {
	
}
