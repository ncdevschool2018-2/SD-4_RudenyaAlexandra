import { Feature } from './feature';

export class Subscribe {
    subscribeId: number;
    startDate: Date;
    endDate: Date;
    productId: number;
    accountId: number;
    feature: Feature[];
}
