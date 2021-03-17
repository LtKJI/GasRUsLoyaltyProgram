package com.ics499.loyalty.controllers;

//need to import LoyaltyAccount model to use the basic functions
import com.ics499.loyalty.model.LoyaltyAccount;

//need to import all of these annotations to make routing easy
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;  

//only needed for basic backend testing
import java.util.HashMap;

@RestController
@RequestMapping("/reward") // all routes here will be /reward/<path var in mapping>

public class RewardController {

}
