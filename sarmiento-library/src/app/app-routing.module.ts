import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { BooksComponent } from './pages/books/books.component';
import { LoansComponent } from './pages/loans/loans.component';
import { ReturnsComponent } from './pages/returns/returns.component';
import { SociosComponent } from './pages/socios/socios.component';

const routes: Routes = [
 {path: '', component: HeaderComponent},
 {path: 'socios', component: SociosComponent},
 {path: 'books', component: BooksComponent},
 {path: 'loans', component: LoansComponent},
 {path: 'returns', component: ReturnsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
