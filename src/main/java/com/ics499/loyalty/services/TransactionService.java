package com.ics499.loyalty.services;

import com.ics499.loyalty.model.Transaction;
import com.ics499.loyalty.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    public List<Transaction> findAll() {
        var it = transactionRepo.findAll();

        var transactions = new ArrayList<Transaction>();
        it.forEach(e -> transactions.add(e));

        return transactions;
    }

    public Optional<Transaction> findById(int id) {
        return transactionRepo.findById(id);
    }

    public void add(Transaction transaction) {
        transactionRepo.save(transaction);
    }

    public Long count() {
        return transactionRepo.count();
    }

    public void deleteById(int rewardID) {
        transactionRepo.deleteById(rewardID);
    }
}
