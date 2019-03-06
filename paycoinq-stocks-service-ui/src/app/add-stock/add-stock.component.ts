import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router} from '@angular/router';

import { StocksService } from '../stocks-service.service';
import { Stock } from '../stock.model';
import {error} from 'util';
import {catchError} from 'rxjs/operators';

@Component({
  selector: 'app-add-stock',
  templateUrl: './add-stock.component.html',
  styleUrls: ['./add-stock.component.scss']
})
export class AddStockComponent implements OnInit {

  addStockForm: FormGroup;
  submitted = false;
  success = false;
  errorMessage = '';

  constructor(private stocksService: StocksService, private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
    this.addStockForm = this.formBuilder.group({
      name: ['', Validators.required],
      code: ['', Validators.required],
      currentPrice: ['', Validators.required],
      currencyCode: ['', Validators.required]
    });
  }

  /**
   * Add Stock
   */
  addStock() {
    this.submitted = true;

    if (this.addStockForm.invalid) {
      return;
    }
    this.stocksService.addStock(this.addStockForm.value)
      .subscribe( data => {
        this.router.navigate(['stocks']);
        this.success = true;
      }, error => {
        this.errorMessage = 'Error creating stock, Please enter valid input';
        this.success = false;
      });


  }

}
