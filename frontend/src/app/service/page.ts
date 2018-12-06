import { HttpClient } from 'selenium-webdriver/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable ({
    providedIn: 'root'
})

export class UserService {

    constructor(private http: HttpClient) {}

    /*getUser(): Observable<User[]> {
        return this.http.get<User[]>('/api/users');
    }*/
}