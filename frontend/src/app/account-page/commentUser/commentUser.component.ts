import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Comment } from '../../model/comment';
import { CommentService } from '../../service/comment.service';
import { Product } from '../../model/product';
import { CommentData } from '../../sharedData/comment';
import { SubscribeData } from 'src/app/sharedData/subscription';
import { SubscribeService } from 'src/app/service/subscribe.service';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
@Component({
    selector: 'app-comment-user',
    templateUrl: 'commentUser.component.html',
    styleUrls: ['commentUser.component.css']
})

export class CommentUserComponent implements OnInit, OnDestroy {

    comments = new CommentData(this.commentService);
    subscribe = new SubscribeData(this.subscribeService, this.loading);
    editProduct: Product = new Product();
    constructor(private commentService: CommentService, private subscribeService: SubscribeService,
         private loading: Ng4LoadingSpinnerService) {}

    ngOnDestroy(): void {
    }
    ngOnInit() {
        this.comments._loadComment();
    }
}
