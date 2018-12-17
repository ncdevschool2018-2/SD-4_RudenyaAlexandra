import { Account } from './account';
import { Role } from './role';
export class User {
    userId: number;
    login: string;
    password: string;
    role: Role;
    account: Account;
}
