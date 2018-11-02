import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { MainTopComponent } from '../main-component-top/main-component-top.component';
import { FooterComponent } from '../footer/footer.component';
import { GameComponent } from '../game-top/game-top.component';
import { CollapseModule } from 'ngx-bootstrap/collapse';
import { MainPageComponent } from './main-page.component';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { NavbarComponent } from '../navbar/navbar.component';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';

@NgModule({
  declarations: [
    MainTopComponent, FooterComponent, GameComponent, MainPageComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, BsDropdownModule.forRoot(), ButtonsModule.forRoot(), HttpClientModule, CollapseModule.forRoot(),
    CarouselModule
  ],
  exports: [ MainTopComponent, FooterComponent, GameComponent, NavbarComponent,
     MainPageComponent
  ],
  providers: [],
  bootstrap: []
})
export class MainPageModule { }
