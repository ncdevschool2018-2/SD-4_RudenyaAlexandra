import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Comment } from '../model/comment';

@Injectable ({
    providedIn: 'root'
})

export class CommentService {

    constructor(private http: HttpClient) {}

    getComment(): Observable<Comment[]> {
        return this.http.get<Comment[]>('/api/comment');
    }

    saveComment(comment: Comment): Observable<Comment> {
        return this.http.post<Comment>('/api/comment', comment);
    }

    deleteComment(comment_id: string): Observable<void> {
        return this.http.delete<void>('/api/comment/' + comment_id);
    }

    getCommentById(commentId: number): Observable<Comment> {
        return this.http.get<Comment>('/api/comment/' + commentId);
    }
}
