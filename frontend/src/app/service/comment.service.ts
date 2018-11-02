import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Comment } from '../model/comment';

@Injectable ({
    providedIn: 'root'
})

export class CommentService {

    constructor(private http: HttpClient) {}

    getUser(): Observable<Comment[]> {
        return this.http.get<Comment[]>('/api/comment');
    }

    saveUser(comment: Comment): Observable<Comment> {
        return this.http.post<Comment>('/api/comment', comment);
    }

    deleteUser(comment_id: string): Observable<void> {
        return this.http.delete<void>('/api/comment/' + comment_id);
    }
}
