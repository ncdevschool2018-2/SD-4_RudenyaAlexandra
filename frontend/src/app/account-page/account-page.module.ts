import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AccountPageComponent } from '../account-page/account-page.component';
import { MenuAccountComponent } from './menu-account/menu-account.component';
import { SubscribeComponent} from './subscribe/sibscribe.component';
import { WalletComponent } from './wallet/wallet.component';
import { SettingComponent } from './setting/setting.component';
import { CommentUserComponent } from './commentUser/commentUser.component';
import { AdminUserAccountComponent } from './userAccountForAdmin/userAccountForAdmin.component';
import { UserInfoComponent } from './user-info/user-info.component';
import {AddProductComponent} from './product-add/product-add.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';

@NgModule({
  declarations: [
    AccountPageComponent, MenuAccountComponent, SubscribeComponent, WalletComponent, SettingComponent, CommentUserComponent,
    AdminUserAccountComponent, UserInfoComponent, AddProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, ButtonsModule.forRoot(), HttpClientModule, FormsModule, ReactiveFormsModule,
    Ng4LoadingSpinnerModule.forRoot(), BsDropdownModule.forRoot(), TooltipModule.forRoot(), ModalModule.forRoot()
  ],
  exports: [
    AccountPageComponent, MenuAccountComponent, SubscribeComponent,  WalletComponent, SettingComponent, CommentUserComponent,
    AdminUserAccountComponent, UserInfoComponent, AddProductComponent
  ],
  providers: [],
  bootstrap: []
})
export class AccountPageModule { }
