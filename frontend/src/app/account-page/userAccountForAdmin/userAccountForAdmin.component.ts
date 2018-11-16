import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { AccountService } from '../../service/account.service';
import { AccountData } from '../../sharedData/account';

@Component({
    selector: 'app-user-account-admin',
    templateUrl: 'userAccountForAdmin.component.html',
    styleUrls: ['userAccountForAdmin.component.css']
})

export class AdminUserAccountComponent implements OnInit, OnDestroy {

    public accounts = new AccountData(this.accountService);
    constructor(private accountService: AccountService) {}
    ngOnDestroy(): void {
    }
    ngOnInit(): void {
        this.accounts.ngOnInit();
    }
}
