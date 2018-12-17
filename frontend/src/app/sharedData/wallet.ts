import { OnInit,  OnDestroy } from '@angular/core';
import { WalletService } from '../service/wallet.service';
import { Wallet } from '../model/wallet';
import { Subscription } from 'rxjs/internal/Subscription';
import { UpdateBalance } from '../model/updateWalletBalance';

export class WalletData implements OnInit, OnDestroy {

    editWallet: Wallet = new Wallet();
    walletMas: Wallet[];
    private subscriptions: Subscription[] = [];
    isLoad = false;
    editMode = false;
    walletByAccounId: Wallet;

    ngOnInit(): void {
        this._loadWallet();
    }

    constructor( private walletService: WalletService) {}

    public _addWallet(): void {
        this.subscriptions.push(this.walletService.saveWallet(this.editWallet).subscribe(() => {
            this._updateWallet();
            this.refreshWallet();
        }));
    }

    refreshWallet(): void {
        this.editWallet = new Wallet();
    }

     _updateWallet(): void {
        this._loadWallet();
    }

    _deleteWallet(wallet_id: string): void {
        this.subscriptions.push(this.walletService.deleteWallet(wallet_id).subscribe( () => {
            this._updateWallet();
            this.refreshWallet();
        }));

    }
     _loadWallet(): void {
        this.subscriptions.push(this.walletService.getWallet().subscribe( wallets => {
            this.walletMas = wallets;
            this.isLoad = true;
        }));
    }

    _getWalletById(id: number): Wallet {
        let walletById: Wallet;
        this.subscriptions.push(this.walletService.getWalletById(id).subscribe( wallets => {
            walletById = wallets;
        }));
        return walletById;
    }

    _getWalletByAcountId(accountId: number) {
        this.subscriptions.push(this.walletService.getWalletByAccountId(accountId).subscribe( wallets => {
            this.walletByAccounId = wallets;
            this.isLoad = true;
        }));
    }

    _updateBalance(updateBalance: UpdateBalance) {
        this.subscriptions.push(this.walletService.updateWalletBalance(updateBalance).subscribe(() => {
        }));
    }

    ngOnDestroy(): void {
        this.subscriptions.forEach( subscription =>  subscription.unsubscribe());
    }

}
