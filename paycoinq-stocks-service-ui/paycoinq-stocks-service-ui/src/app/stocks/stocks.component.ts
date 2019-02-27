import { Component, OnInit } from '@angular/core';
import { StocksService } from '../stocks-service.service';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.scss']
})
export class StocksComponent implements OnInit {

  stocks: Object;

  constructor(private stocksService: StocksService) { }

  ngOnInit() {
    this.stocksService.getStocks().subscribe(data => {
        this.stocks = data
        console.log(this.stocks);
      }
    );
  }

}
