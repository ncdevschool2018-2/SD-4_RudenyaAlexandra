import { Component, OnInit,  OnDestroy } from '@angular/core';
import { WalletService } from '../service/wallet.service';
import { Wallet } from '../model/wallet';
import { Subscription } from 'rxjs/internal/Subscription';

@Component ({
    selector: 'app-wallet',
    templateUrl: './wallet.component.html',
    styleUrls: ['./wallet.component.css']
})

export class WalletComponent implements OnInit, OnDestroy {


    public editWallet: Wallet = new Wallet();
    public walletMas: Wallet[];
    private subscriptions: Subscription[] = [];
    ngOnInit(): void {
        this._loadWallet();
    }

    constructor( private walletService: WalletService) {}

    public _addWallet(): void {
        this.subscriptions.push(this.walletService.saveUser(this.editWallet).subscribe(() => {
            this._updateWallet();
            this.refreshWallet();
        }));
    }

    private refreshWallet(): void {
        this.editWallet = new Wallet();
    }

    public _updateWallet(): void {
        this._loadWallet();
    }

    public _deleteWallet(wallet_id: string): void {
        this.subscriptions.push(this.walletService.deleteUser(wallet_id).subscribe( () => {
            this._updateWallet();
            this.refreshWallet();
        }));

    }
    public _loadWallet(): void {
        this.subscriptions.push(this.walletService.getUser().subscribe( wallets => {
            this.walletMas = wallets as Wallet[];
            console.log(wallets);
        }));
    }

    ngOnDestroy(): void {
        this.subscriptions.forEach( subscription =>  subscription.unsubscribe());
    }

}
