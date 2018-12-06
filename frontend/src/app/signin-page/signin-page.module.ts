import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { BrowserModule } from '@angular/platform-browser';
import { SigninComponent } from './signin-page.component';
import { FormsModule } from '@angular/forms';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    SigninComponent,
  ],
  imports: [
    ButtonsModule.forRoot(), BrowserModule, FormsModule, ReactiveFormsModule
  ],
  exports: [
    SigninComponent
  ]
})
export class SigninModule {}
