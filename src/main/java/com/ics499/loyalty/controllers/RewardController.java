package com.ics499.loyalty.controllers;

//need to import LoyaltyAccount model to use the basic functions
import com.ics499.loyalty.model.Reward;

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
    // for demo purposes
    private HashMap<String, Reward> rewards = new HashMap<String, Reward>();
    
    //GET REQUESTS
    @GetMapping("/create_demo")
    public String createDemo(){
        rewards.put("car", new Reward(1, "car", 100, "A brand new car!!!!"));
        rewards.put("coal", new Reward(2, "coal", 5, "Piece of coal."));
        return "{\"message\": \"Demo rewards created created.\"}";
    }

	@GetMapping("/display")
	public String displayAllRewards() {
		String allRewards = "{\"rewards\": [";
        for(String i : rewards.keySet()) {
            allRewards = allRewards + rewards.get(i).getJSON() + ",";
        }
        allRewards = allRewards + "]}";
		return allRewards;
	}
    
	@GetMapping("/find/{name}")    
	public String findRewards(@PathVariable("name") String name) {
		return rewards.get(name).getJSON();
    }
    
    //POST REQUESTS
    @PostMapping("/add")
    public String addRewards(@RequestBody Reward newReward) {
        rewards.put(newReward.getName(), newReward);
        return "{\"message\": \"New reward " + newReward.getName() + " added.\"}";
    }

    //PUT REQUESTS
    @PutMapping("/set_points")
    public String setPointCost(@RequestBody Reward updatedReward) {
        if(rewards.containsKey(updatedReward.getName())){
            rewards.remove(updatedReward.getName());
            rewards.put(updatedReward.getName(),updatedReward);
            return "{\"message\": \"Reward's point cost update\"}";
        }
        else {
            return "{\"message\": \"Error updating reward. Reward does not exist.\"}";
        }
	}

}
