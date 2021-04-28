import { Injectable } from '@angular/core';
import { Transaction } from './transaction';

import { HttpClient, HttpHeaders } from '@angular/common/http'; 
import { throwError as observableThrowError, Observable } from 'rxjs'; 
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  _transactionUrl: string = 'http://localhost:8080/transaction';

  httpOptionsJson = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  httpOptionsPlainText = {
    headers: new HttpHeaders({ 'Content-Type': 'text/plain' })
  };

  constructor(private _http: HttpClient) { }

  getTransactions(): Observable<Transaction[]> {
    return this._http.get<Transaction[]>(`${this._transactionUrl}/all`)
        .pipe(catchError(this.handleError));
  }

  getSpecificTransaction(id: string): Observable<Transaction> {
    return this._http.get<Transaction>(`${this._transactionUrl}/id/` + id)
    .pipe(catchError(this.handleError));
  }

  createLoyaltyAccount(transaction: Transaction): Observable<any> {
    return this._http.post<String>(`${this._transactionUrl}/add`, transaction, this.httpOptionsJson)
    .pipe(catchError(this.handleError));
  }

  private handleError(error: any) { 
    let errMsg = (error.message) ? error.message : error.status ? 
    `${error.status} - ${error.statusText}` : 'Server error'; 

    console.error(errMsg); 

    return observableThrowError(errMsg); 
  }
}
