import { Component, OnInit } from '@angular/core';
import { UserHomeService } from '../user-home.service';
import { User } from '../user';



@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

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

  cart: Products = [];


  cartCount: number = 0;
  totalCost: number = 0;
  totalPoints: number = 0;

  products: Products = [
    {
      name: '10 Gallons of Gas', price: 20.00, pointValue: 20
    },
        {
      name: 'Chips', price: 2.00, pointValue: 2
    },
        {
      name: 'Drink', price: 1.00, pointValue: 1
    }
  ];

  productButtonOnClick(product: Product){
    this.cart.push(product);
    this.cartCount = this.cart.length;
    this.totalCost = this.totalCost + product.price;
    this.totalPoints = this.totalPoints + product.pointValue;
    console.log(this.cartCount);
  }

  checkoutButtonOnClick(cartCount: number, totalCost: number, totalPoints: number) {
    this.cartCount = 0;
    this.totalCost = 0;
    this.user.pointsBalance += this.totalPoints;
    this.user.ytdPoints += this.totalPoints;
    this.user.lifetimePoints += this.totalPoints;
    console.log(this.user);
    this.UserHomeService.update(this.user);
    this.totalPoints = 0;
  }
}




type Product = {
  name: string;
  price: number;
  pointValue: number;
};

type Products = Product[];

type cart = Products[];

type cartValues = {
  numOfItems: number;
  totalCost: number;
  totalPoints: number;
}