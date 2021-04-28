import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  cart: Products = [];


  cartCount: number = 0;
  totalCost: number = 0;
  totalPoints: number = 0;

  products: Products = [
    {
      name: 'Item 1', price: 20.00, pointValue: 15
    },
        {
      name: 'Item 2', price: 5.00, pointValue: 3
    },
        {
      name: 'Item 3', price: 7.50, pointValue: 5
    }
  ];

  productButtonOnClick(product: Product){
    this.cart.push(product);
    this.cartCount = this.cart.length;
    this.totalCost = this.totalCost + product.price;
    this.totalPoints = this.totalPoints + product.pointValue;
    console.log(this.cartCount);
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