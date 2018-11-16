import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Comment } from '../../model/comment';
import { CommentService } from '../../service/comment.service';
import { CommentData } from 'src/app/sharedData/comment';

@Component ({
    selector: 'app-comment',
    templateUrl: './comment.component.html',
    styleUrls: ['./comment.component.css']
})

export class CommentComponent implements OnInit, OnDestroy {

    public comment = new CommentData(this.commentService);
    constructor(private commentService: CommentService) {}
    ngOnInit() {
        this.comment.ngOnInit();
    }
    ngOnDestroy() {}
}

