import { Wallet } from './wallet';
import { Subscribe } from './subscribe';
export class Account {
    accountId: number;
    // tslint:disable-next-line:no-inferrable-types
    lastName: string;
    // tslint:disable-next-line:no-inferrable-types
    firstName: string;
    registrationDate: string;
    imageProfile: string;
    wallet: Wallet[];
    subscription: Subscribe[];
}
