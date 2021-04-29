import { Injectable } from '@angular/core';
import { User} from './user';

import { HttpClient, HttpHeaders } from '@angular/common/http'; 
import { throwError as observableThrowError, Observable } from 'rxjs'; 
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserHomeService {

  _loyaltyAccountUrl: string = 'http://localhost:8080/loyalty_account';

  httpOptionsJson = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  httpOptionsPlainText = {
    headers: new HttpHeaders({ 'Content-Type': 'text/plain' })
  };

  constructor(private _http: HttpClient) { }

  user: User = {
    accountID: 1,
    email: 'bob@gmail.com',
    pointsBalance: 100,
    ytdPoints: 10000,
    lifetimePoints: 10000000,
    tierStrat: "Platinum"
  };

  getAllLoyaltyAccounts(): Observable<User[]> {
    return this._http.get<User[]>(`${this._loyaltyAccountUrl}/display`)
        .pipe(catchError(this.handleError));
  }

  getSpecificLoyaltyAccount(id: string): Observable<User> {
    return this._http.get<User>(`${this._loyaltyAccountUrl}/find/` + id)
    .pipe(catchError(this.handleError));
  }

  createLoyaltyAccount(email: string): Observable<any> {
    return this._http.post<String>(`${this._loyaltyAccountUrl}/add`, email, this.httpOptionsPlainText)
    .pipe(catchError(this.handleError));
  }

  redeemRewards(user: User): Observable<any> {
    console.log("redeeming rewards");
    return this._http.put<User>(`${this._loyaltyAccountUrl}/redeem`, user, this.httpOptionsJson)
    .pipe(catchError(this.handleError));
  }

  private handleError(error: any) { 
    let errMsg = (error.message) ? error.message : error.status ? 
    `${error.status} - ${error.statusText}` : 'Server error'; 

    console.error(errMsg); 

    return observableThrowError(errMsg); 
  }

  get(): User {
    return this.user;
  }

  update(user: User): void {
    this.user = user;
  }
}
