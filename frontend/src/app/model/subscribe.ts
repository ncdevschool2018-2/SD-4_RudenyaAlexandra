export class Subscribe {
    subscribe_id: number;
    start_date: Date;
    end_date: Date;
    product_id: number;
    account_id: number;

    static cloneBase(subscribe: Subscribe): Subscribe {
        const cloneSubscribe: Subscribe = new Subscribe();
        cloneSubscribe.subscribe_id = subscribe.subscribe_id;
        cloneSubscribe.start_date = subscribe.start_date;
        cloneSubscribe.end_date = subscribe.end_date;
        cloneSubscribe.product_id = subscribe.product_id;
        cloneSubscribe.account_id = subscribe.account_id;
        return cloneSubscribe;
    }
}
