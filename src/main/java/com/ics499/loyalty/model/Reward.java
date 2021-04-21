package com.ics499.loyalty.model;
import javax.persistence.*;

@Entity
public class Reward {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="REWARD_ID")
	int rewardID;
    String name;
	int pointsCost;
	String description;

	public Reward() {}
	
	public Reward(int rID, String n, int pC, String d) {
		rewardID = rID;
		name = n;
		pointsCost = pC;
		description = d;
	}

	//Getters and setters
	
	public int getRewardID() {
		return rewardID;
	}

	public void setRewardID(int rewardID) {
		this.rewardID = rewardID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPointsCost() {
		return pointsCost;
	}

	public void setPointsCost(int pointsCost) {
		this.pointsCost = pointsCost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// added this to make my life easier for a demo, may not be required in the future
    public String getJSON() {
        return "{\"reward_id\": " + String.valueOf(this.rewardID) + ", \"name\": \"" + this.name + "\", " + 
        "\"point_cost\": " + String.valueOf(this.pointsCost) + ", " + "\"description\": \"" 
        + this.description +  "\"}";
    }
	
}
