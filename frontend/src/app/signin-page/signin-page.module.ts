import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { BrowserModule } from '@angular/platform-browser';
import { SigninComponent } from './signin-page.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    SigninComponent,
  ],
  imports: [
    ButtonsModule.forRoot(), BrowserModule, FormsModule
  ],
  exports: [
    SigninComponent
  ]
})
export class SigninModule {}
