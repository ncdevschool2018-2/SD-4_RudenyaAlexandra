export class Account {
    account_id: number;
    last_name: string;
    first_name: string;
    registration_date: Date;
    image_profile: string;
    user_id: number;

    static cloneBase(account: Account): Account {
        const clonedAccount: Account = new Account();
        clonedAccount.account_id = account.account_id;
        clonedAccount.first_name = account.first_name;
        clonedAccount.last_name = account.last_name;
        clonedAccount.registration_date = account.registration_date;
        clonedAccount.image_profile = account.image_profile;
        clonedAccount.user_id = account.user_id;
        return clonedAccount;
    }
}
