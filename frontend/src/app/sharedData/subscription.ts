import { OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import {Subscribe} from '../model/subscribe';
import { SubscribeService } from '../service/subscribe.service';
export class SubscribeData implements OnInit, OnDestroy {

    public editSubscribe: Subscribe = new Subscribe();
    public subscribe: Subscribe[];
    private subscriptions: Subscription[] = [];

    constructor(private subscribeService: SubscribeService) {}
    ngOnInit() {
        this.loadSubscribe();
      }

      public _addSubscribe(): void {
          this.subscriptions.push(this.subscribeService.saveSubscribe
            (this.editSubscribe).subscribe(() => {
                this._updateSubscribe();
                this.refreshSubscribe();
            }));
      }

      public _updateSubscribe(): void {
          this.loadSubscribe();
      }

      private refreshSubscribe(): void {
          this.editSubscribe = new Subscribe();
      }

      public _deleteSubscribe(subscribe_id: number): void {
        this.subscriptions.push(this.subscribeService.deleteSubscribe(subscribe_id).subscribe(() => {
          this._updateSubscribe();
          this.refreshSubscribe();
        }));
      }

      private loadSubscribe(): void {
        // Get data from BillingAccountService
        this.subscriptions.push(this.subscribeService.getSubscribe().subscribe(accounts => {
          // Parse json response into local array
          this.subscribe = accounts as Subscribe[];
          // Check data in console
          console.log(this.subscribe); // don't use console.log in angular :)
        }));
      }

      ngOnDestroy(): void {
        this.subscriptions.forEach(subscription =>
          subscription.unsubscribe());
      }
}
