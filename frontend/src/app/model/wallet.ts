export class Wallet {
    wallet_id: number;
    card_number: number;
    CVV: number;
    card_validity_period: Date;
    currency: number;
    balance: number;
    account_id: number;

    static cloneBase(wallet: Wallet): Wallet {
      const clonedWallet: Wallet = new Wallet();
      clonedWallet.wallet_id = wallet.wallet_id;
      clonedWallet.card_number = wallet.card_number;
      clonedWallet.CVV = wallet.CVV;
      clonedWallet.card_validity_period = wallet.card_validity_period;
      clonedWallet.currency = wallet.currency;
      clonedWallet.balance = wallet.balance;
      clonedWallet.account_id = wallet.account_id;
      return clonedWallet;
    }
}
