import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Stock } from './stock.model';

@Injectable({
  providedIn: 'root'
})
export class StocksService {

  constructor(private http: HttpClient) { }

  baseUrl = 'api/v1/stocks';

  getStocks() {
    return this.http.get(this.baseUrl + '?page=0&pageSize=30');
  }

  getStock(stockId: string) {
    return this.http.get(this.baseUrl + '/' + stockId);
  }

  addStock(stock: Stock) {
    return this.http.post(this.baseUrl, stock);
  }

  updateStock(stock: Stock, stockId: number) {
    return this.http.put(this.baseUrl + '/' + stockId, stock);
  }

  deleteStock(stockId: string) {
    return this.http.delete(this.baseUrl + '/' + stockId);
  }
}
