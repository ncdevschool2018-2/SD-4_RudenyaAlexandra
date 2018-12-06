import { HttpClient } from 'selenium-webdriver/http';
import { TokenStorage } from '../core/token.srorage';
import { Router } from '@angular/router';
import { JwtDecode } from '../model/jwtDecode';

const TOKEN_KEY = 'AuthToken';

export class Auth {

    decodedJwt: any;
    decodeObj: JwtDecode;

    constructor(private http: HttpClient, private token: TokenStorage, private router: Router) {}

    public decodeJwt(token: string): any {
        // tslint:disable-next-line:prefer-const
        let encodedJwt = token.split('.')[1];
        // tslint:disable-next-line:prefer-const
        this.decodedJwt = window.atob(encodedJwt);
        return JSON.parse(this.decodedJwt);
    }

    public getUsername(): string {
        this.decodeObj =  this.decodeJwt(this.token.getToken());
        return this.decodeObj.sub;
    }

    public getRole(): string {
        // tslint:disable-next-line:prefer-const
        this.decodeObj = this.decodeJwt(this.token.getToken());
        return this.decodeObj.scopes;
    }

    public logout() {
        this.router.navigateByUrl('/login');
        this.signOut();
        localStorage.clear();
    }

    public signOut() {
        window.sessionStorage.removeItem(TOKEN_KEY);
        window.sessionStorage.clear();
    }
}