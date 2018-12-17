import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Wallet } from '../model/wallet';
import { UpdateBalance } from '../model/updateWalletBalance';

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

    getWalletById(walletId: number): Observable<Wallet> {
        return this.http.get<Wallet>('/api/wallet/' +  walletId);
    }

    getWalletByAccountId(accountId: number): Observable<Wallet> {
        return this.http.get<Wallet>('/api/wallet/get/' + accountId);
    }

    updateWalletBalance(update: UpdateBalance): Observable<UpdateBalance> {
        return this.http.post<UpdateBalance>('/api/wallet/updateBalance/', update);
    }
}
