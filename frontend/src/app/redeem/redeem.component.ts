import { Component, OnInit } from '@angular/core';
import { UserHomeService } from '../user-home.service';
import { User } from '../user';
import { Reward } from '../reward'

@Component({
  selector: 'app-redeem',
  templateUrl: './redeem.component.html',
  styleUrls: ['./redeem.component.css']
})
export class RedeemComponent implements OnInit {


  user: User = {
    accountID: 0,
    email: '',
    pointsBalance: 0,
    ytdPoints: 0,
    lifetimePoints: 0,
    tierStrat: ""
  };

  constructor(private UserHomeService: UserHomeService) { }

  ngOnInit(): void {
    this.user = this.UserHomeService.get();
  }

  cart: Rewards = [];


  cartCount: number = 0;
  totalCost: number = 0;

  rewards: Rewards = [
    {
      name: "Free gallon of gas",
	    pointsCost: 20,
	    description: "A free gallon of gas!"
    },
        {
          name: "Free car",
          pointsCost: 2000,
          description: "A free car in the color red!"
    },
        {
          name: "Free cruise",
          pointsCost: 20000000000,
          description: "A free cruise through the caribbean!"
    }
  ];

  productButtonOnClick(reward: Reward){
    this.cart.push(reward);
    this.cartCount = this.cart.length;
    this.totalCost = this.totalCost + reward.pointsCost;
    console.log(this.cartCount);
  }

  checkoutButtonOnClick(cartCount: number, totalCost: number) {
    this.cartCount = 0;
    this.user.pointsBalance -= this.totalCost;
    this.user.ytdPoints -= this.totalCost;
    this.user.lifetimePoints -= this.totalCost;
    this.UserHomeService.update(this.user);
    this.totalCost = 0;
  }
}

type Rewards = Reward[];

type cart = Rewards[];

type cartValues = {
  numOfItems: number;
  totalCost: number;
  totalPoints: number;
}