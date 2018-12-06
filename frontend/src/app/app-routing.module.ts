import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SigninComponent } from './signin-page/signin-page.component';
import { LoginComponent } from './login-page/login-page.component';
import { MainPageComponent } from './main-page/main-page.component';
import { FooterComponent } from './main-page/footer/footer.component';
import { AccountPageComponent } from './account-page/account-page.component';
import { ProductComponent } from './product-page/product.component';
import { CategoryProductComponent } from './category-product/category-product.component';
import {NotFoundedComponent } from './notFounded/page.component';
import { LoginActivate } from './loginActivate';
import { AccountActivate } from './activateAccount';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: MainPageComponent},
  {path: 'signin', component: SigninComponent},
  {path: 'login', component: LoginComponent, canActivate: [ LoginActivate ]},
  {path: 'contact', component: FooterComponent },
  {path: 'account', component: AccountPageComponent, canActivate: [ AccountActivate ]},
  {path: 'product', component: ProductComponent },
  {path: 'products', component: CategoryProductComponent},
  {path: '**', component: NotFoundedComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
