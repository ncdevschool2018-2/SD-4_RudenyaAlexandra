import { Product } from './product';
import { Account } from './account';

export class Subscribe {
    subscribe_id: number;
    start_date: Date;
    end_date: Date;
    product_id: Product;
    account_id: Account;
}
