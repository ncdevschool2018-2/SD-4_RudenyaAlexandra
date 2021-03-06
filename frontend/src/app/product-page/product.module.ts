import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { CommentComponent } from './comment/comment.component';
import { ProductComponent } from './product.component';
import { FormsModule } from '@angular/forms';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';

@NgModule({
  declarations: [
    ProductComponent, CommentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, ButtonsModule.forRoot(), HttpClientModule, FormsModule, PaginationModule.forRoot(),
    Ng4LoadingSpinnerModule.forRoot()
  ],
  providers: [],
  bootstrap: [],
  exports: [ ProductComponent, CommentComponent ]
})
export class ProductModule { }
