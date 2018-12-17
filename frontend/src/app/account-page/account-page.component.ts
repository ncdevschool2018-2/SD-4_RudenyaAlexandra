import { Component, OnInit, OnDestroy, Output, EventEmitter, Input } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Account } from '../model/account';
import { AccountService } from '../service/account.service';
import { AuthService } from '../service/auth.service';
import { UserData } from '../sharedData/user';
import { UserService } from '../service/user.service';
import { SubscribeService } from '../service/subscribe.service';
import { SubscribeData } from '../sharedData/subscription';
import { Subscribe } from '../model/subscribe';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { TranslationWidth } from '@angular/common';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';

@Component({
    selector: 'app-account-page',
    templateUrl: './account-page.component.html'
})

export class AccountPageComponent implements OnInit, OnDestroy {

    parameter = 'subscription';
    user = new UserData(this.userService, this.loadingSpinnerService);
    accountId: number;
    private subscriptions: Subscription[] = [];

    constructor(private accountService: AccountService, private subscribeService: SubscribeService,
        private userService: UserService, private router: Router, private auth: AuthService,
        private loadingSpinnerService: Ng4LoadingSpinnerService) {
    }

    linkNumber(parameter: string) {
        this.parameter = parameter;
    }

    ngOnDestroy(): void {
    }

    ngOnInit(): void {
        this.loadingSpinnerService.show();
        this.user._loadUser();
        this.user._getUserByLogin(this.auth.getUsername());
    }
}
