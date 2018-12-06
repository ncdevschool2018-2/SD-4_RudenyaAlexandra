import { Feature } from './feature';
import { Product } from './product';

export class Subscribe {
    subscribeId: number;
    startDate: Date;
    endDate: Date;
    product: Product;
    account: Account;
    feature: Feature[];
    status: number;
}
