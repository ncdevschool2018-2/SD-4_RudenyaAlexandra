import { Component, OnInit, TemplateRef, Input} from '@angular/core';
import { WalletService } from '../../service/wallet.service';
import { WalletData } from '../../sharedData/wallet';
import { Wallet } from 'src/app/model/wallet';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';
import { UserData } from 'src/app/sharedData/user';
import { User } from 'src/app/model/user';
import { Account } from 'src/app/model/account';
import { FormGroup, FormBuilder, FormControl, Validators, ValidationErrors } from '@angular/forms';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';
import { UpdateBalance } from 'src/app/model/updateWalletBalance';


@Component ({
    selector: 'app-wallet',
    templateUrl: './wallet.component.html',
    styleUrls: ['./wallet.component.css']
})

export class WalletComponent implements OnInit {

    private modalRef: BsModalRef;
    wallets = new WalletData(this.walletService);
    user = new UserData(this.userService, this.loadingSpinnerService);
    walletForm: FormGroup;
    @Input()
    accountId;

    constructor( private walletService: WalletService, private auth: AuthService,
        private userService: UserService, private modalService: BsModalService,
        private formBuilder: FormBuilder,
        private loadingSpinnerService: Ng4LoadingSpinnerService) {}

    ngOnInit(): void {
        this.loadingSpinnerService.show();
        this.wallets._getWalletByAcountId(this.accountId);
        this.walletForm = this.formBuilder.group({
        cardNumber: new FormControl('', [Validators.required]),
        cardValidityPeriod: new FormControl('', [Validators.required, Validators.minLength(4),
        ]),
        currency: new FormControl('1', [Validators.required]),
        cvv: new FormControl('', [Validators.required]),
        money: new FormControl( 0, [Validators.required]) });
        this.wallets._getWalletByAcountId(this.accountId);
    }
    
    _closeModal(): void {
        this.modalRef.hide();
    }

    _openModal(template: TemplateRef<any>, wallet: Wallet): void {
        if (wallet) {
            this.wallets.editMode = true;
            this.wallets.editWallet = Wallet.cloneBase(wallet);
        }
        else {
            this.wallets.refreshWallet();
            this.wallets.editMode = false;
        }
        this.modalRef = this.modalService.show(template);
    }
    isControlInvalid(controlName: string): boolean {
        const control = this.walletForm.controls[controlName];
        const result = control.invalid && control.touched;
        return result;
    }

    public get f() {
        return this.walletForm.controls;
    }

    onSubmit() {
        const controls = this.f;
        if (this.walletForm.invalid) {
          // tslint:disable-next-line:comment-format
          Object.keys(controls).forEach( controlName => controls[controlName].markAsTouched());
          return;
        }
        console.log(this.walletForm.value);
        /*console.log('email=' + this.f.email.value);
        console.log('username=' + this.f.username.value);
        console.log('password=' + this.f.password.value);*/
      }

      isInvalid(): boolean {
          if (this.walletForm.invalid) {
              return true;
          }
          return false;
      }


    addWallet(): void {
        this.wallets.editWallet.cvv = this.walletForm.controls['cvv'].value;
        this.wallets.editWallet.cardNumber = this.walletForm.controls['cardNumber'].value;
        this.wallets.editWallet.cardValidityPeriod = this.walletForm.controls['cardValidityPeriod'].value;
        this.wallets.editWallet.currency = this.walletForm.controls['currency'].value;
        this.wallets.editWallet.balance = this.walletForm.controls['money'].value;
        this.wallets.editWallet.accountId = this.accountId;
        this.wallets._addWallet();
       this._closeModal();
    }

    topUpMoney() {
        const updateBalance = new UpdateBalance();
        updateBalance.id = this.wallets.walletByAccounId.walletId;
        console.log(this.wallets.walletByAccounId.walletId);
        updateBalance.amount = this.walletForm.controls['money'].value;
        this.wallets._updateBalance(updateBalance);
    }
}
