import { Component, OnInit} from '@angular/core';
import { WalletService } from '../../service/wallet.service';
import { WalletData } from '../../sharedData/wallet';


@Component ({
    selector: 'app-wallet',
    templateUrl: './wallet.component.html',
    styleUrls: ['./wallet.component.css']
})

export class WalletComponent implements OnInit {


    public wallets = new WalletData(this.walletService);

    ngOnInit(): void {
        this.wallets.ngOnInit();
    }
    constructor( private walletService: WalletService) {}

}
