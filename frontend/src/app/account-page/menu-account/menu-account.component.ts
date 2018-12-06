import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Auth } from 'src/app/sharedData/share';
import { AuthService } from 'src/app/service/auth.service';

@Component({
    selector: 'app-menu-account',
    templateUrl: './menu-account.component.html',
    styleUrls: ['./menu-account.component.css'],
})

export class MenuAccountComponent implements OnInit {

    isAdmin = false;
    @Output()
    linkComponent =  new EventEmitter<string>();
    buttonEvent: string;
    isCollapsed = false;
    constructor(private auth: AuthService) {}

    ngOnInit() {
        this.getRoleUser();
    }

    clickButton(event: string) {
        this.linkComponent.emit(event);
    }

    getRoleUser(): any {
            // tslint:disable-next-line:prefer-const
            const userRole: string = this.auth.getRole();
            if (userRole === 'ADMIN') {
                this.isAdmin = true;
            }
    }
}

