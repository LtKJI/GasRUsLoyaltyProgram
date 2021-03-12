package com.ics499.loyalty.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/loyalty_account")
public class LoyaltyAccountController {

    // @RequestMapping(value ="/redeem", method = RequestMethod.PUT)
	// public void RedeemRewards(Reward rewards) {
		
	// }
    
    @RequestMapping("/display")
	public String displayAllMembers() {
		return "{\"users\": [{\"name\": \"Bob\", \"account_tier\": \"Gold\"}, {\"name\": \"Jenny\", \"account_tier\": \"Gold\"}]}";
	}
    
    // @RequestMapping(value = "/add", method = RequestMethod.POST)
	// public void addMember(Customer customer) {
		
	// }
    
    // @RequestMapping(value = "/find", method = RequestMethod.GET)
	// public LoyaltyAccount findMember(LoyaltyAccount loyaltyacc) {
		
	// }
}
