import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StocksComponent } from './stocks/stocks.component';
import { AddStockComponent } from './add-stock/add-stock.component';
import { UpdateStockComponent } from './update-stock/update-stock.component';
import { DeleteStockComponent } from './delete-stock/delete-stock.component';

const routes: Routes = [
  { path: 'stocks', component: StocksComponent },
  { path: 'addStock', component: AddStockComponent },
  { path: 'updateStock', component: UpdateStockComponent },
  { path: 'deleteStock', component: DeleteStockComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
