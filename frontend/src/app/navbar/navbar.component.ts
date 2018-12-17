import { Component, OnInit } from '@angular/core';
import {CategoryService } from '../service/category.service';
import { CategoryData } from '../sharedData/category';

import { HttpClient } from '@angular/common/http';
import { TokenStorage } from '../core/token.srorage';
import { AuthService } from '../service/auth.service';

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

    isUser = false;
    isAdmin = false;
    isNull = false;

    categories = new CategoryData(this.categoryService);
    ngOnInit(): void {
        this.getRoleUser();
        this.categories.ngOnInit();
    }
    constructor(private categoryService: CategoryService,  private token: TokenStorage, public authService: AuthService) {
    }

    getRoleUser(): any {
        if (this.token.getToken() !== null) {
            // tslint:disable-next-line:prefer-const
            let user: string = this.authService.decodeJwt(this.token.getToken());
            const userRole: string = this.authService.getRole();
            // tslint:disable-next-line:triple-equals
            if (userRole === 'USER') {
                this.isUser = true;
            }
            // tslint:disable-next-line:triple-equals
            if (userRole === 'ADMIN') {
                this.isAdmin = true;
            }
        }
        // tslint:disable-next-line:one-line
        else {
            this.isNull = true;
        }
    }
}

