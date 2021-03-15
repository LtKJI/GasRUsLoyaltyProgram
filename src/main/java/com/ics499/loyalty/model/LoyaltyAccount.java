package com.ics499.loyalty.model;

public class LoyaltyAccount {

	int accountID;
	String email;
	int pointsBalance;
	int ytdPoints;
	int lifetimePoints;
	String tierStrat;
	
	public LoyaltyAccount(int aID, String e, int pB, int ytdP, int lP, String tS) {
		accountID = aID;
		email = e;
		pointsBalance = pB;
		ytdPoints = ytdP;
		lifetimePoints = lP;
		tierStrat = tS;		
	}
	
	//Getters and Setters
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPointsBalance() {
		return pointsBalance;
	}
	public void setPointsBalance(int pointsBalance) {
		this.pointsBalance = pointsBalance;
	}
	public int getYtdPoints() {
		return ytdPoints;
	}
	public void setYtdPoints(int ytdPoints) {
		this.ytdPoints = ytdPoints;
	}
	public int getLifetimePoints() {
		return lifetimePoints;
	}
	public void setLifetimePoints(int lifetimePoints) {
		this.lifetimePoints = lifetimePoints;
	}
	public String getTierStrat() {
		return tierStrat;
	}
	public void setTierStrat(String tierStrat) {
		this.tierStrat = tierStrat;
    }
    
    // added this to make my life easier for a demo, may not be required in the future
    public String getJSON() {
        return "{\"account_id\": " + String.valueOf(this.accountID) + ", \"email\": \"" + this.email + "\", " + 
        "\"points_balance\": " + String.valueOf(this.pointsBalance) + ", " + "\"ytd_points\": " 
        + String.valueOf(this.ytdPoints) + ", " +  "\"lifetime_points\": " 
        + String.valueOf(this.lifetimePoints) + ", " +  "\"tier\": \"" 
        + this.tierStrat + "\"}";
    }
}

