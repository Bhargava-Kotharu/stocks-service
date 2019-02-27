import { Component, OnInit } from '@angular/core';
import { StocksService } from '../stocks-service.service';

@Component({
  selector: 'app-add-stock',
  templateUrl: './add-stock.component.html',
  styleUrls: ['./add-stock.component.scss']
})
export class AddStockComponent implements OnInit {

  constructor(private stocksService: StocksService) { }

  ngOnInit() {
  }

  getStocks() {
    this.stocksService.getStocks();
  }

}
