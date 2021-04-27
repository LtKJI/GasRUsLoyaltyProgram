import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserHomeService } from '../user-home.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
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
    this.UserHomeService.getSpecificLoyaltyAccount("1")
    .subscribe(user => this.user = user);
  }

}
