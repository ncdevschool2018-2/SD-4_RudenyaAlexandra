import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import {CategoryProductComponent} from './category-product.component';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
@NgModule({
  declarations: [
    CategoryProductComponent
  ],
  imports: [
    ButtonsModule.forRoot(), BrowserModule, FormsModule, AppRoutingModule, PaginationModule.forRoot(),
    Ng4LoadingSpinnerModule.forRoot()
  ],
  exports: [
    CategoryProductComponent
  ]
})
export class CategoryProductModule {}
