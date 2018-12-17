import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { AccountService } from '../../service/account.service';
import { AccountData } from '../../sharedData/account';
import { UserData } from 'src/app/sharedData/user';
import { UserService } from 'src/app/service/user.service';

@Component({
    selector: 'app-user-account-admin',
    templateUrl: 'userAccountForAdmin.component.html',
    styleUrls: ['userAccountForAdmin.component.css']
})

export class AdminUserAccountComponent implements OnInit, OnDestroy {

    @Input()
    users;
    constructor() { }
    ngOnDestroy(): void {
    }
    ngOnInit(): void {
    }
}
