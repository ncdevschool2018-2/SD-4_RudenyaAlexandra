import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login-page/login-page.model';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { SigninModule} from './signin-page/signin-page.module';
import { MainPageModule } from './main-page/main-page.module';
import {AccountPageModule} from './account-page/account-page.module';
import { CategoryProductModule } from './category-product/category-product.module';
import { ProductModule } from './product-page/product.module';
import { NavbarComponent } from './navbar/navbar.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { Interceptor } from './core/app.interceptor';
import { TokenStorage } from './core/token.srorage';
import {  NotFoundedComponent } from './notFounded/page.component';
import { LoginActivate } from './loginActivate';
import { AccountActivate } from './activateAccount';

@NgModule({
  declarations: [
    AppComponent, NavbarComponent, NotFoundedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, ButtonsModule.forRoot(), HttpClientModule,
    LoginModule, MainPageModule, AccountPageModule,
    SigninModule, ProductModule,  BsDropdownModule.forRoot(),
    CategoryProductModule,
  ],
  providers: [
    LoginActivate, AccountActivate,
    TokenStorage,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
