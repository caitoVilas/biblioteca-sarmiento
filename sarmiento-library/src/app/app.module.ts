import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SociosComponent } from './pages/socios/socios.component';
import { BooksComponent } from './pages/books/books.component';
import { LoansComponent } from './pages/loans/loans.component';
import { ReturnsComponent } from './pages/returns/returns.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SociosComponent,
    BooksComponent,
    LoansComponent,
    ReturnsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
