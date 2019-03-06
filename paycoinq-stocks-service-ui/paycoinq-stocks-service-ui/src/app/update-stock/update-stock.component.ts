import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router} from '@angular/router';
import {Stock} from '../stock.model';

import { StocksService } from '../stocks-service.service';

@Component({
  selector: 'app-update-stock',
  templateUrl: './update-stock.component.html',
  styleUrls: ['./update-stock.component.scss']
})
export class UpdateStockComponent implements OnInit {

  updateStockForm: FormGroup;
  submitted = false;
  success = false;
  errorMessage = '';
  stock: Stock;

  constructor(private formBuilder: FormBuilder, private router: Router, private stocksService: StocksService) { }

  ngOnInit() {

    this.updateStockForm = this.formBuilder.group({
      name: ['', Validators.required],
      code: ['', Validators.required],
      currentPrice: ['', Validators.required],
      currencyCode: ['', Validators.required]
    });

    const stockId = window.localStorage.getItem('editStockId');

    this.stocksService.getStock(stockId).subscribe(data => {
        // @ts-ignore
        this.stock = data;
        this.updateStockForm.setValue({
          name: this.stock.name,
          code: this.stock.code,
          currentPrice: this.stock.currentPrice,
          currencyCode: this.stock.currencyCode,
        });
      }
    );
  }

  /**
   * Update Stock
   */
  updateStock(stockId: number) {
    this.submitted = true;

    if (this.updateStockForm.invalid) {
      return;
    }
    this.stocksService.updateStock(this.updateStockForm.value, stockId)
      .subscribe( data => {
        this.router.navigate(['stocks']);
        this.success = true;
        window.localStorage.removeItem('editStockId');
      }, error => {
        this.errorMessage = 'Error updating stock.';
        this.success = false;
      });


  }

}
