import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
    selector: 'app-menu-account',
    templateUrl: './menu-account.component.html',
    styleUrls: ['./menu-account.component.css'],
})

export class MenuAccountComponent implements OnInit {

    role = 'admin';
    @Output()
    linkComponent =  new EventEmitter<string>();
    buttonEvent: string;
    isCollapsed = false;
    constructor() {}
    ngOnInit() {
    }

    clickButton(event: string) {
        console.log(event);
        this.linkComponent.emit(event);
    }
}
