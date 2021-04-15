package com.ics499.loyalty.controllers;

// need to import LoyaltyAccount model to use the basic functions
import com.ics499.loyalty.model.LoyaltyAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Optional;

// need to import all of these annotations to make routing easy
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;  

import com.ics499.loyalty.repositories.LoyaltyAccountRepo;

@Controller
@RequestMapping("/loyalty_account") // all routes here will be /loyalty_account/<path var in mapping>
public class LoyaltyAccountController {
    @Autowired
	private LoyaltyAccountRepo loyaltyAccountRepo;

    /*
        GET FUNCTIONS
    */

    /*
        full path: /loyalty_account/create_demo
        What does it do?
            * creates two base loyalty accounts and puts them into the accounts hashmap
            * updates account increment to 3 (because we now have 2 accounts)
            * sends back JSON response letting the user know that the accounts have been created
        
        NOTE: This will be removed once we have the database working. This is for demos ONLY.
    */
    @GetMapping(path = "/create_demo")
    public @ResponseBody String createAccounts() {
        loyaltyAccountRepo.save(new LoyaltyAccount(1, "bob@gmail.com", 100, 500, 600, "Gold"));
        loyaltyAccountRepo.save(new LoyaltyAccount(2, "jenny@gmail.com", 100, 300, 1000, "Platinum"));
        return "{\"message\": \"Bob and Jenny created.\"}";
    }

    /*
        full path: /loyalty_account/display
        What does it do?
            * sends back json containing a list of all members in the accounts hashmap

        In future, the database should simplify this a bit for us but will be about the same.

    */
    @GetMapping(path = "/display")
	public @ResponseBody Iterable<LoyaltyAccount> displayAllMembers() {
		return loyaltyAccountRepo.findAll();
    }
    
    /*
        full path: /loyalty_account/find/<email>
        What does it do?
            * returns the loyalty account associated with the email
        
        Same as /display, this will stay about the same but will change a tiny bit
        with the addition of the database.
    */
    @GetMapping(path = "/find/{id}")
	public @ResponseBody Optional<LoyaltyAccount> findMember(@PathVariable("id") int id) {
		return loyaltyAccountRepo.findById(id);
	}

    /*
        POST FUNCTIONS
    */

    /*
        full path: /loyalty_account/add
        What does this do?
            * takes an email address and creates a new account
            * returns a message saying the account has been added

        Changes that will need to be made:
            * actually put account info into the database
            * instead of a string it should take JSON. This can be fixed easily once we
              get a front end that can send us full account info.
            * account increment won't be required

        NOTE: you will need curl or postman to do this request
    */
    @PostMapping(path = "/add")
	public @ResponseBody LoyaltyAccount addMember(@RequestBody String email) {
        return loyaltyAccountRepo.save(new LoyaltyAccount(email, 0, 0, 0, "Silver"));
	}

    /*
        PUT FUNCTIONS
    */

    /*
        full path: /loyalty_account/redeem
        What does this do?
            * removes specified amount of points from loyalty account

        Changes that will need to be made:
            * actually put info into database
            * assumes frontend will do the quick math for us - if not, this will have to change
    */
    @PutMapping(path = "/redeem")
	public @ResponseBody String RedeemRewards(@RequestBody LoyaltyAccount la) {
        if(loyaltyAccountRepo.existsById(la.getAccountID())){
            loyaltyAccountRepo.save(la);
            return "{\"message\": \"Rewards redeemed\"}";
        }
        else {
            return "{\"message\": \"Error redeeming rewards. Account does not exist.\"}";
        }
	}
}
