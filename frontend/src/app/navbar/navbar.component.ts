import { Component, OnInit } from '@angular/core';
import {CategoryService } from '../service/category.service';
import { CategoryData } from '../sharedData/category';

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

    //role = 'user';
    links: Link[] = [
        {name: 'Главная', url: '/home'},
    ];
    
    public categories = new CategoryData(this.categoryService);
    ngOnInit(): void {
    }

    constructor(private categoryService: CategoryService) {
    }
}
