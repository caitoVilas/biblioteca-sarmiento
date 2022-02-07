import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookHomeComponent } from './pages/book-home/book-home.component';

const routes: Routes = [
  {path: 'books', component: BookHomeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BooksRoutingModule { }
