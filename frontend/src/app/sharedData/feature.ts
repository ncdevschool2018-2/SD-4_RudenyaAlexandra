import { OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Feature } from '../model/feature';
import { FeatureService } from '../service/feature.service';
export class SubscribeData implements OnInit, OnDestroy {

    public editFeature: Feature = new Feature();
    public subscribe: Feature[];
    private subscriptions: Subscription[] = [];

    constructor(private featureService: FeatureService) {}
    ngOnInit() {
        this.loadFeature();
      }

      public addFeature(): void {
          this.subscriptions.push(this.featureService.saveFeature
            (this.editFeature).subscribe(() => {
                this.updateFeature();
                this.refreshFeature();
            }));
      }

      public updateFeature(): void {
          this.loadFeature();
      }

      private refreshFeature(): void {
          this.editFeature = new Feature();
      }

      public deleteFeature(featureId: number): void {
        this.subscriptions.push(this.featureService.deleteFeature(featureId).subscribe(() => {
          this.updateFeature();
          this.refreshFeature();
        }));
      }

      public loadFeature(): void {
        // Get data from BillingAccountService
        this.subscriptions.push(this.featureService.getFeature().subscribe(accounts => {
          // Parse json response into local array
          this.subscribe = accounts as Feature[];
          // Check data in console
          console.log(this.subscribe); // don't use console.log in angular :)
        }));
      }

      ngOnDestroy(): void {
        this.subscriptions.forEach(subscription =>
          subscription.unsubscribe());
      }
}
