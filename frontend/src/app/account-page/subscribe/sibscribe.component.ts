import { Component, OnInit, OnDestroy } from '@angular/core';
import { SubscribeData } from '../../sharedData/subscription';
import { SubscribeService } from '../../service/subscribe.service';

@Component({
    selector: 'app-subscribe',
    templateUrl: './subscribe.component.html',
    styleUrls: ['./subscribe.component.css'],
})

export class SubscribeComponent implements OnInit {

    public subscribes = new SubscribeData(this.subscribeService);

    constructor(private subscribeService: SubscribeService) {}
    ngOnInit() {
        this.subscribes.ngOnInit();
      }
}
