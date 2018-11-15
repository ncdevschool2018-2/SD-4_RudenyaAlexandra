import { Component, OnInit, OnDestroy, Output, EventEmitter } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Account } from '../model/account';
import { AccountService } from '../service/account.service';

@Component({
    selector: 'app-account-page',
    templateUrl: './account-page.component.html'
})

export class AccountPageComponent implements OnInit, OnDestroy {

    parameter = 'subscription';

    constructor(private accountService: AccountService ) {}

    linkNumber(parameter: string) {
        this.parameter = parameter;
    }

    ngOnDestroy(): void {
    }
    ngOnInit(): void {
    }
}
