import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import {  AccountPageComponent } from '../account-page/account-page.component';
import { MenuAccountComponent } from '../menu-account/menu-account.component';
import { SubscribeComponent} from '../subscribe/sibscribe.component';

@NgModule({
  declarations: [
    AccountPageComponent, MenuAccountComponent, SubscribeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, ButtonsModule.forRoot(), HttpClientModule
  ],
  exports: [
    AccountPageComponent, MenuAccountComponent, SubscribeComponent
  ],
  providers: [],
  bootstrap: []
})
export class AccountPageModule { }
