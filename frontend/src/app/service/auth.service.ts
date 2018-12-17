import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/';
import { TokenStorage } from '../core/token.srorage';
import { LoginUser } from '../model/loginUser';
import { JwtDecode } from '../model/jwtDecode';
import { Token } from '../model/token';
import { Router } from '@angular/router';
import { Location } from '@angular/common';


const TOKEN_KEY = 'AuthToken';

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    decodedJwt: any;
    decodeObj: JwtDecode;

    constructor(private http: HttpClient, private token: TokenStorage, private router: Router, private location: Location) {}

    attempAuth(loginUser: LoginUser): Observable<any> {
        console.log('attempAuth ::');
        return this.http.post<Token>('/token/generate-token', loginUser);
    }

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
        window.location.reload();
        this.signOut();
        localStorage.clear();
    }

    public signOut() {
        window.sessionStorage.removeItem(TOKEN_KEY);
        window.sessionStorage.clear();
    }
}
