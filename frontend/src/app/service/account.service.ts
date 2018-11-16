import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Account } from '../model/account';

@Injectable ({
    providedIn: 'root'
})

export class AccountService {

    constructor(private http: HttpClient) {}

    getAccount(): Observable<Account[]> {
        return this.http.get<Account[]>('/api/account');
    }

    saveAccount(account: Account): Observable<Account> {
        return this.http.post<Account>('/api/account', account);
    }

    deleteAccount(account_id: string): Observable<void> {
        return this.http.delete<void>('/api/account/' + account_id);
    }

    getAccountById(accountId: number): Observable<Account> {
        return this.http.get<Account>('api/account/' + accountId);
    }
}
