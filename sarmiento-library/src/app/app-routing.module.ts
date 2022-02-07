import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksModule } from './modules/books/books.module';
import { HomeModule } from './modules/home/home.module';
import { LoansModule } from './modules/loans/loans.module';
import { PartnersModule } from './modules/partners/partners.module';


const routes: Routes = [
  {path: 'partners', loadChildren:()=> import('./modules/partners/partners.module').then(p=>PartnersModule)},
  {path: 'books', loadChildren:()=> import('./modules/books/books.module').then(b=>BooksModule)},
  {path: 'loans', loadChildren:()=> import('./modules/loans/loans.module').then(l=>LoansModule)},
  {path: '', loadChildren:()=> import('./modules/home/home.module').then(m=>HomeModule)},
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
