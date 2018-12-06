import { Account } from './account';
import { Role } from './role';
export class User {
    userId: number;
    login: string;
    password: string;
    public role: Role;
    public account: Account;
}
