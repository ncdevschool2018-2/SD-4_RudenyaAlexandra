import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { SubscribeData } from '../../sharedData/subscription';
import { SubscribeService } from '../../service/subscribe.service';
import { Subscribe } from 'src/app/model/subscribe';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
    selector: 'app-subscribe',
    templateUrl: './subscribe.component.html',
    styleUrls: ['./subscribe.component.css'],
})

export class SubscribeComponent implements OnInit {

    @Input()
    accountId;

    subscribe = new SubscribeData(this.subscribeService, this.loading);
    private subscriptions: Subscription[] = [];
    subscribeByAccountId: Subscribe[];

    constructor(private router: Router, private subscribeService: SubscribeService,
        private loading: Ng4LoadingSpinnerService) {}
    ngOnInit() {
        this.loading.show();
        console.log(this.accountId);
        this.loadSubscribeByAccountId(this.accountId);
    }

    loadSubscribeByAccountId(id: number) {
        // Get data from BillingAccountService
        this.subscriptions.push(this.subscribeService.getSubscribeByAccountId(id).subscribe(sub => {
          this.subscribeByAccountId = sub;
        }));
    }

}
