import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Subscribe } from '../model/subscribe';

@Injectable ({
    providedIn: 'root'
})

export class SubscribeService {

    constructor(private http: HttpClient) {}

    getUser(): Observable<Subscribe[]> {
        return this.http.get<Subscribe[]>('/api/subscribe');
    }

    saveUser(subscribe: Subscribe): Observable<Subscribe> {
        return this.http.post<Subscribe>('/api/subscribe', subscribe);
    }

    deleteUser(subscribe_id: string): Observable<void> {
        return this.http.delete<void>('/api/subscribe/' + subscribe_id);
    }
}
