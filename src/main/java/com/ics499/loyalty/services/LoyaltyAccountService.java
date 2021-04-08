package com.ics499.loyalty.services;

import com.ics499.loyalty.model.LoyaltyAccount;
import com.ics499.loyalty.repositories.LoyaltyAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoyaltyAccountService {

    @Autowired
    private LoyaltyAccountRepo loyaltyAccountRepo;

    public List<LoyaltyAccount> findAll() {
        var it = loyaltyAccountRepo.findAll();

        var accounts = new ArrayList<LoyaltyAccount>();
        it.forEach(e -> accounts.add(e));

        return accounts;
    }

    public Optional<LoyaltyAccount> findById(int id) {
        return loyaltyAccountRepo.findById(id);
    }

    public void add(LoyaltyAccount la) {
        loyaltyAccountRepo.save(la);
    }

    public Long count() {
        return loyaltyAccountRepo.count();
    }

    public void deleteById(int accountID) {
        loyaltyAccountRepo.deleteById(accountID);
    }
}
