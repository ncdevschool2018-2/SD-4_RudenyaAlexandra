export class Wallet {
    walletId: number;
    cardNumber: number;
    cvv: number;
    cardValidityPeriod: String;
    currency: number;
    balance: number;
    accountId: number;

    static cloneBase(wallet: Wallet): Wallet {
        const clonedWallet: Wallet = new Wallet();
        clonedWallet.walletId = wallet.walletId;
        clonedWallet.cardNumber = wallet.cardNumber;
        clonedWallet.cvv = wallet.cvv;
        clonedWallet.cardValidityPeriod = wallet.cardValidityPeriod;
        clonedWallet.currency = wallet.currency;
        clonedWallet.balance = wallet.balance;
        clonedWallet.accountId = wallet.accountId;
        return clonedWallet;
    }
}
