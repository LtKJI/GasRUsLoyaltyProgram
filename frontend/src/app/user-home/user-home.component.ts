import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
  user: User = {
    accountID: 3452,
    email: 'alayna@gmail.com',
    pointsBalance: 100,
    ytdPoints: 1000,
    lifetimePoints: 10000000,
    tierStrat: "Gold"
  };

  constructor() { }

  ngOnInit(): void {
  }

}
