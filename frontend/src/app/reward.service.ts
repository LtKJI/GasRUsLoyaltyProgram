import { Injectable } from '@angular/core';
import { Reward } from './reward';

import { HttpClient, HttpHeaders } from '@angular/common/http'; 
import { throwError as observableThrowError, Observable } from 'rxjs'; 
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RewardService {
  _rewardUrl: string = 'http://localhost:8080/reward';

  httpOptionsJson = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  httpOptionsPlainText = {
    headers: new HttpHeaders({ 'Content-Type': 'text/plain' })
  };

  constructor(private _http: HttpClient) { }

  getRewards(): Observable<Reward[]> {
    return this._http.get<Reward[]>(`${this._rewardUrl}/display`)
        .pipe(catchError(this.handleError));
  }

  getSpecificReward(id: string): Observable<Reward> {
    return this._http.get<Reward>(`${this._rewardUrl}/find/` + id)
    .pipe(catchError(this.handleError));
  }

  private handleError(error: any) { 
    let errMsg = (error.message) ? error.message : error.status ? 
    `${error.status} - ${error.statusText}` : 'Server error'; 

    console.error(errMsg); 

    return observableThrowError(errMsg); 
  }
}
