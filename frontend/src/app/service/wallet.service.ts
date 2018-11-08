import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Wallet } from '../model/wallet';

@Injectable ({
    providedIn: 'root'
})

export class WalletService {

    constructor(private http: HttpClient) {}

    getWallet(): Observable<Wallet[]> {
        return this.http.get<Wallet[]>('/api/wallet');
    }

    saveWallet(wallet: Wallet): Observable<Wallet> {
        return this.http.post<Wallet>('/api/wallet', wallet);
    }

    deleteWallet(wallet_id: string): Observable<void> {
        return this.http.delete<void>('/api/wallet/' + wallet_id);
    }
}
