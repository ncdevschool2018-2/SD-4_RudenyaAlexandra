import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { LoginComponent } from './login-page.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';


@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    ButtonsModule.forRoot(), BrowserModule, FormsModule, AppRoutingModule, Ng4LoadingSpinnerModule.forRoot()
  ],
  exports: [
    LoginComponent
  ]
})
export class LoginModule {}
