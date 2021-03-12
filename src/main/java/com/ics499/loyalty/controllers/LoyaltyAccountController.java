package com.ics499.loyalty.controllers;

import com.ics499.loyalty.model.LoyaltyAccount;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;  

// only needed for basic backend testing
import java.util.HashMap;

@RestController
@RequestMapping("/loyalty_account")
public class LoyaltyAccountController {
    // for demo purposes only
    private HashMap<String, LoyaltyAccount> accounts = new HashMap<String, LoyaltyAccount>();
    private int accountIncrement = 1;

    @GetMapping(path = "/create_demo")
    public String createAccounts() {
        accounts.put("bob@gmail.com", new LoyaltyAccount(1, "bob@gmail.com", 100, 500, 600, "Gold"));
        accounts.put("jenny@gmail.com", new LoyaltyAccount(2, "jenny@gmail.com", 100, 300, 1000, "Platinum"));
        accountIncrement = 3;
        return "{\"message\": \"Bob and Jenny created.\"}";
    }

    @PutMapping(path = "/redeem")
	public String RedeemRewards() {
        
		return "{\"message\": \"Rewards redeemed\"}";
	}
    
    @GetMapping(path = "/display")
	public String displayAllMembers() {
        String users = "{\"users\": [";
        for(String i : accounts.keySet()) {
            users = users + accounts.get(i).getJSON() + ",";
        }
        users = users + "]}";
		return users;
	}
    
    @PostMapping(path = "/add")
	public String addMember(@RequestBody String email) {
        accounts.put(email, new LoyaltyAccount(accountIncrement, email, 0, 0, 0, "Silver"));
        accountIncrement++;
        return "{\"message\": \"New member " + email + " added.\"}";
	}
    
    @GetMapping(path = "/find/{email}")
	public String findMember(@PathVariable("email") String email) {
		return accounts.get(email).getJSON();
	}
}
