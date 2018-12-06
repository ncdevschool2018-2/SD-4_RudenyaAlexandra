import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { LoginComponent } from './login-page.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';


@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    ButtonsModule.forRoot(), BrowserModule, FormsModule, AppRoutingModule
  ],
  exports: [
    LoginComponent
  ]
})
export class LoginModule {}
