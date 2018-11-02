import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login-page/login-page.model';
import { HttpClientModule } from '@angular/common/http';
import { SigninModule} from './signin-page/signin-page.module';
import { MainPageModule } from './main-page/main-page.module';
import {AccountPageModule} from './account-page/account-page.module';
import { WalletComponent } from './wallet/wallet.component';

@NgModule({
  declarations: [
    AppComponent, WalletComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, ButtonsModule.forRoot(), HttpClientModule,
    LoginModule, MainPageModule, AccountPageModule,
    SigninModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
