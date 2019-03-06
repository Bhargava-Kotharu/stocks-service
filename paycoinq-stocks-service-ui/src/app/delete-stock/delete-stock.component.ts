import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router} from '@angular/router';
import {Stock} from '../stock.model';

import { StocksService } from '../stocks-service.service';

@Component({
  selector: 'app-delete-stock',
  templateUrl: './delete-stock.component.html',
  styleUrls: ['./delete-stock.component.scss']
})
export class DeleteStockComponent implements OnInit {

  messageForm: FormGroup;
  submitted = false;
  success = false;
  errorMessage = '';
  stock: Stock;

  constructor(private formBuilder: FormBuilder, private router: Router, private stocksService: StocksService) { }

  ngOnInit() {

  }
}
