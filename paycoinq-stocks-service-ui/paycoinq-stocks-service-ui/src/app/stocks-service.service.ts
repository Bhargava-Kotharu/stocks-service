import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StocksService {

  constructor(private http: HttpClient) { }

  getStocks() {
    return this.http.get('http://localhost:8080/api/v1/stocks?page=0&pageSize=20');
  }
}
