import { OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import {Subscribe} from '../model/subscribe';
import { SubscribeService } from '../service/subscribe.service';
import { Account } from '../model/account';
import { Product } from '../model/product';
import { Comment } from '../model/comment';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

export class SubscribeData implements OnInit, OnDestroy {

    editSubscribe: Subscribe = new Subscribe();
    subscribe: Subscribe[];
    private subscriptions: Subscription[] = [];
    subscribeByAccountId: Subscribe[];
    isLoad = false;

    constructor(private subscribeService: SubscribeService, private loading: Ng4LoadingSpinnerService) {
      this.editSubscribe.account = new Account();
      this.editSubscribe.product = new Product();
    }

    ngOnInit() {
        this.loadSubscribe();
      }

      _addSubscribe(): void {
        this.loading.show();
          this.subscriptions.push(this.subscribeService.saveSubscribe
            (this.editSubscribe).subscribe(() => {
                this._updateSubscribe();
                this.refreshSubscribe();
                this.loading.hide();
            }));
      }

      _updateSubscribe(): void {
          this.loadSubscribe();
      }

     refreshSubscribe(): void {
          this.editSubscribe = new Subscribe();
      }

      _deleteSubscribe(subscribe_id: number): void {
        this.subscriptions.push(this.subscribeService.deleteSubscribe(subscribe_id).subscribe(() => {
          this._updateSubscribe();
          this.refreshSubscribe();
        }));
      }

      loadSubscribe(): void {
        this.loading.show();
        // Get data from BillingAccountService
        this.subscriptions.push(this.subscribeService.getSubscribe().subscribe(accounts => {
          this.subscribe = accounts;
          this.isLoad = true;
          this.loading.hide();
        }));
      }

      ngOnDestroy(): void {
        this.subscriptions.forEach(subscription =>
          subscription.unsubscribe());
      }
}
