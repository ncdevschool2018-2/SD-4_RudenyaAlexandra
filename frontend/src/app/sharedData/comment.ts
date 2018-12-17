import { OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Comment } from '../model/comment';
import { CommentService } from '../service/comment.service';

export class CommentData implements OnInit, OnDestroy {

    public editComment: Comment = new Comment();
    public comments: Comment[];
    public commentById: Comment;
    public subscription: Subscription[] = [];
    isLoad = false;
    constructor(private commentService: CommentService) {}


    ngOnInit() {
        this._loadComment();
    }
    ngOnDestroy() {}

    public _loadComment() {
        this.subscription.push(this.commentService.getComment().subscribe( comment => {
            this.comments = comment;
            this.isLoad = true;
        }));
    }

    public _updateComment() {
        this._loadComment();
    }

    public _refreshComment() {
        this.editComment = new Comment();
    }

    public _deleteComment(comment_id: string) {
        this.subscription.push(this.commentService.deleteComment(comment_id).subscribe( () => {
            this._updateComment();
            this._refreshComment();
        }));
    }
    public _addComment() {
        this.subscription.push(this.commentService.saveComment(this.editComment).subscribe( () => {
            this._updateComment();
            this._refreshComment();
        }));
    }

    public _getCommentById(id: number) {
        
        this.subscription.push(this.commentService.getCommentById(id).subscribe( comment => {
            this.commentById = comment;
            this.isLoad = true;
        }));
    }
}

