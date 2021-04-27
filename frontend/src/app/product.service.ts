import { Injectable } from '@angular/core';
import { Product } from './product';

import { HttpClient, HttpHeaders } from '@angular/common/http'; 
import { throwError as observableThrowError, Observable } from 'rxjs'; 
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  _productUrl: string = 'http://localhost:8080/product';

  httpOptionsJson = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  httpOptionsPlainText = {
    headers: new HttpHeaders({ 'Content-Type': 'text/plain' })
  };

  constructor(private _http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this._http.get<Product[]>(`${this._productUrl}/all`)
        .pipe(catchError(this.handleError));
  }

  getSpecificProduct(id: string): Observable<Product> {
    return this._http.get<Product>(`${this._productUrl}/find/` + id)
    .pipe(catchError(this.handleError));
  }

  private handleError(error: any) { 
    let errMsg = (error.message) ? error.message : error.status ? 
    `${error.status} - ${error.statusText}` : 'Server error'; 

    console.error(errMsg); 

    return observableThrowError(errMsg); 
  }
}
