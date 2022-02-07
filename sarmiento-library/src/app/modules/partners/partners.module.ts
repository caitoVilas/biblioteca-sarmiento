import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PartnersRoutingModule } from './partners-routing.module';
import { PartnersHomeComponent } from './pages/partners-home/partners-home.component';




@NgModule({
  declarations: [
  PartnersHomeComponent,
  ],
  imports: [
    CommonModule,
    PartnersRoutingModule
  ]
})
export class PartnersModule { }
