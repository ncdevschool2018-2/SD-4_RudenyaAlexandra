import { OnInit, OnDestroy} from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Account } from '../model/account';
import { AccountService } from '../service/account.service';

export class AccountData implements OnInit, OnDestroy {

    public editAccount: Account = new Account();
    public userAccount: Account[];
    public subscription: Subscription[] = [];

    constructor(private accountService: AccountService ) {}
    ngOnInit() {
        this._loadAccount();
    }

    public _loadAccount(): void {

        this.subscription.push(this.accountService.getAccount().subscribe ( account => {
            this.userAccount = account as Account[];
            console.log(this.userAccount);
        }));
    }

    public _refreshAccount(): void {
            this.editAccount = new Account();
    }
    public _addAccount():  void {
        this.subscription.push(this.accountService.saveAccount(this.editAccount).subscribe( () => {
            this._loadAccount();
            this._refreshAccount();
        }));
    }

    public _deleteAccount(account_id: string):  void {
        this.subscription.push(this.accountService.deleteAccount(account_id).subscribe( () => {
            this._loadAccount();
            this._refreshAccount();
        }));
    }
    ngOnDestroy(): void {
        this.subscription.forEach(subscription =>
          subscription.unsubscribe());
    }
}
