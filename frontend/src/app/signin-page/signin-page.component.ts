import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserData } from '../sharedData/user';
import { UserService } from '../service/user.service';
import { AccountService } from '../service/account.service';
import { AccountData } from '../sharedData/account';
import { Account } from '../model/account';
import { User } from '../model/user';
import { Subscription } from 'rxjs';

@Component({
    selector: 'app-signin-page',
    templateUrl: './signin-page.component.html',
    styleUrls: ['./signin-page.component.css']
})

export class SigninComponent implements OnInit, OnDestroy {

  passwordRepeat: string;
  public user = new UserData(this.userService);
  public accounts = new AccountData(this.accountService);
  public editTableUser: User = new User();
  public userAccount: User[];
  public editAccount: Account = new Account();
  public account1: Account[];
  public subscription: Subscription[] = [];


  constructor(private userService: UserService, private accountService: AccountService) {}

  ngOnInit() {
    this.user.ngOnInit();
    this.accounts.ngOnInit();
   /* this.user.editTableUser.userId = this.user.userAccount[this.user.userAccount.length].userId + 1;
    this.accounts.editAccount.accountId = this.accounts.userAccount[this.accounts.userAccount.length].accountId + 1;*/
  }

  ngOnDestroy(): void {
  }

  public _addUser(): void {
      this.editTableUser.role = 'user';
      this.subscription.push(this.userService.saveUser
        (this.editTableUser).subscribe(() => {
            this.user._updateUser();
            this.user.refreshUser();
        }));
  }

  public _addAccount():  void {
    this.subscription.push(this.accountService.saveAccount(this.editAccount).subscribe( () => {
        this.accounts._loadAccount();
        this.accounts._refreshAccount();
    }));
    
}
}//указать все поля для 2 сущносте1, отправляю модельку user и account saveUser , filter java, spring ses, val - fapi, 
//констуроктор объявить на бэке и тянуть только определенные
