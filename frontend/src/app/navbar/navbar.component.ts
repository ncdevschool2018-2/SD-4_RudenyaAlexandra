import { Component, OnInit } from '@angular/core';

interface Link {
    name: string;
    url: string;
}
@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.css'],
})

// спросить про output и input
export class NavbarComponent implements OnInit {

    role = 'user';
    links: Link[] = [
        {name: 'Главная', url: '/home'},
    ];

    items: string[] = [
        'The first choice!',
        'And another choice for you.',
        'but wait! A third!'
      ];
    ngOnInit(): void {
    }

    constructor() {
    }
}
