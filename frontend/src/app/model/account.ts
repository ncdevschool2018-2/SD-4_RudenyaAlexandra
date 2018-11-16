import { Wallet } from './wallet';
import { Subscribe } from './subscribe';
export class Account {
    accountId: number;
    lastName: string;
    firstName: string;
    registrationDate: string;
    imageProfile: string;
    wallet: Wallet[];
    subscription: Subscribe[];
}
