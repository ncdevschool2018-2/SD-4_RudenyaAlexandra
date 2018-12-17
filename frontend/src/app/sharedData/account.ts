import { OnInit, OnDestroy} from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Account } from '../model/account';
import { AccountService } from '../service/account.service';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';

export class AccountData implements OnInit, OnDestroy {

    public editAccount: Account = new Account();
    public userAccount: Account[];
    public subscription: Subscription[] = [];
    isLoad = false;

    constructor(private accountService: AccountService, private loading: Ng4LoadingSpinnerService) {}
    ngOnInit() {
        this._loadAccount();
    }

    public _loadAccount(): void {
        this.loading.show();
        this.subscription.push(this.accountService.getAccount().subscribe ( account => {
            this.userAccount = account;
            this.isLoad = true;
            this.loading.hide();
        }));
    }

    public _refreshAccount(): void {
            this.editAccount = new Account();
    }
    public _addAccount():  void {
        this.loading.show();
        this.subscription.push(this.accountService.saveAccount(this.editAccount).subscribe( () => {
            this._loadAccount();
            this._refreshAccount();
            this.loading.hide();
        }));
    }

    public _deleteAccount(account_id: string):  void {
        this.subscription.push(this.accountService.deleteAccount(account_id).subscribe( () => {
            this._loadAccount();
            this._refreshAccount();
            this.loading.hide();
        }));
    }
    ngOnDestroy(): void {
        this.subscription.forEach(subscription =>
          subscription.unsubscribe());
    }
}
