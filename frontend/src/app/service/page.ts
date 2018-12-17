import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from '../model/page';

@Injectable ({
    providedIn: 'root'
})

export class PageService {

    constructor(private http: HttpClient) {}

    getPage<T>(entityName: string, page: number, size: number): Observable<Page<T>> {
        return this.http.get<Page<T>>('/api/'.concat(entityName).concat('?')
        .concat('page=' + page)
        // tslint:disable-next-line:triple-equals
        .concat(size != 0 ? ('&size=' + size) : ''));
    }
}


