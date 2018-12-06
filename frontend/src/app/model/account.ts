import { Wallet } from './wallet';
import { Subscribe } from './subscribe';
export class Account {
    accountId: number;
    // tslint:disable-next-line:no-inferrable-types
    public lastName: string;
    // tslint:disable-next-line:no-inferrable-types
    public firstName: string;
    public registrationDate: string;
    public imageProfile: string;
    public wallet: Wallet[];
    public subscription: Subscribe[];
}
