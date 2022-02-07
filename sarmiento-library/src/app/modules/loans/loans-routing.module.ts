import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoansHomeComponent } from './pages/loans-home/loans-home.component';

const routes: Routes = [
  {path: 'loans', component: LoansHomeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoansRoutingModule { }
