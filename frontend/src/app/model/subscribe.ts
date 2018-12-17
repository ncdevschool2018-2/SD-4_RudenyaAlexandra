import { Feature } from './feature';
import { Product } from './product';
import { Account } from './account';

export class Subscribe {
    subscribeId: number;
    startDate: string;
    endDate: string;
    product: Product;
    account: Account;
    feature: Feature[];
    status: boolean;
}
