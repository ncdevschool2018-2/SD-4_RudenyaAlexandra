import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Subscribe } from '../model/subscribe';

@Injectable ({
    providedIn: 'root'
})

export class SubscribeService {

    constructor(private http: HttpClient) {}

    getSubscribe(): Observable<Subscribe[]> {
        return this.http.get<Subscribe[]>('/api/subscribe');
    }

    saveSubscribe(subscribe: Subscribe): Observable<Subscribe> {
        return this.http.post<Subscribe>('/api/subscribe', subscribe);
    }

    deleteSubscribe(subscribe_id: number): Observable<void> {
        return this.http.delete<void>('/api/subscribe/' + subscribe_id);
    }
    getSubscribeById(subscribeId: number): Observable<Subscribe> {
        return this.http.get<Subscribe>('api/subscribe/' + subscribeId);
    }
    getSubscribeByAccountId(accountId: number): Observable<Subscribe[]> {
        return this.http.get<Subscribe[]>('api/subscribe/getByAccount/' + accountId);
    }
}
