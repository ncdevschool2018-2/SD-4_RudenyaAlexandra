import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Account } from '../model/account';

@Injectable ({
    providedIn: 'root'
})

export class AccountService {

    constructor(private http: HttpClient) {}

    getUser(): Observable<Account[]> {
        return this.http.get<Account[]>('/api/account');
    }

    saveUser(account: Account): Observable<Account> {
        return this.http.post<Account>('/api/account', account);
    }

    deleteUser(account_id: string): Observable<void> {
        return this.http.delete<void>('/api/account/' + account_id);
    }
}
