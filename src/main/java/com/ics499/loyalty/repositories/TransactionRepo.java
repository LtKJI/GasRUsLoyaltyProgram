package com.ics499.loyalty.repositories;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ics499.loyalty.model.Transaction;

@Repository
public interface TransactionRepo extends CrudRepository <Transaction , Integer> {
	
}
