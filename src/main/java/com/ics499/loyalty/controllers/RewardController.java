package com.ics499.loyalty.controllers;

//need to import LoyaltyAccount model to use the basic functions
import com.ics499.loyalty.model.Reward;
import com.ics499.loyalty.repositories.RewardRepo;

//need to import all of these annotations to make routing easy
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;  

import java.util.Optional;

@Controller
@RequestMapping("/reward") // all routes here will be /reward/<path var in mapping>
public class RewardController {
    @Autowired
	private RewardRepo rewardRepo;
    
    //GET REQUESTS
    @GetMapping("/create_demo")
    public @ResponseBody String createDemo(){
        rewardRepo.save(new Reward(1, "car", 100, "A brand new car!!!!"));
        rewardRepo.save(new Reward(2, "coal", 5, "Piece of coal."));
        return "{\"message\": \"Demo rewards created created.\"}";
    }

	@GetMapping("/display")
	public @ResponseBody Iterable<Reward> displayAllRewards() {
		return rewardRepo.findAll();
	}
    
	@GetMapping("/find/{id}")    
	public Optional<Reward> findRewards(@PathVariable("id") int id) {
		return rewardRepo.findById(id);
    }
    
    //POST REQUESTS
    @PostMapping("/add")
    public @ResponseBody Reward addRewards(@RequestBody Reward newReward) {
        return rewardRepo.save(newReward);
    }

    //PUT REQUESTS
    @PutMapping("/set_points")
    public @ResponseBody String setPointCost(@RequestBody Reward updatedReward) {
        if(rewardRepo.existsById(updatedReward.getRewardID())){
            rewardRepo.save(updatedReward);
            return "{\"message\": \"Reward's point cost update\"}";
        }
        else {
            return "{\"message\": \"Error updating reward. Reward does not exist.\"}";
        }
	}

}
