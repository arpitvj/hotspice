import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { CategoryComponent }  from './components/category.component';
import { DishComponent }  from './components/dish.component';
import { OrderComponent }  from './components/order.component';
import {routing} from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    CategoryComponent,
    DishComponent,
    OrderComponent 
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
