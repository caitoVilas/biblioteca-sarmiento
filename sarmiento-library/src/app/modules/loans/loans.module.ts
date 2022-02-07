import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoansRoutingModule } from './loans-routing.module';
import { LoansHomeComponent } from './pages/loans-home/loans-home.component';


@NgModule({
  declarations: [
    LoansHomeComponent
  ],
  imports: [
    CommonModule,
    LoansRoutingModule
  ]
})
export class LoansModule { }
