import { Component, OnInit } from '@angular/core';
import { StocksService } from '../stocks-service.service';
import {Stock} from '../stock.model';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.scss']
})
export class StocksComponent implements OnInit {

  stocks: object;

  constructor(private stocksService: StocksService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.loadStocks();
  }

  loadStocks() {
    this.stocksService.getStocks().subscribe(data => {
        this.stocks = data;
      }
    );
  }

  updateStock(stock: Stock): void {
    window.localStorage.setItem('editStockId', stock.id.toString());
    this.router.navigate(['updateStock']);
  }

  deleteStock(stockId: string) {
    this.stocksService.deleteStock(stockId).subscribe(data => {
      this.loadStocks();
    });
  }


}
