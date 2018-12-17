import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable ({
    providedIn: 'root'
})

export class UserService {

    constructor(private http: HttpClient) {}

    getUser(): Observable<User[]> {
        return this.http.get<User[]>('/api/users');
    }

    saveUser(user: User): Observable<User> {
        return this.http.post<User>('/api/users', user);
    }

    deleteUser(userId: string): Observable<void> {
        return this.http.delete<void>('/api/users/' + userId);
    }

    getUserById(userId: number): Observable<User> {
        return this.http.get<User>('/api/users/' + userId);
    }
    getUserByLogin(login: string): Observable<User> {
        return this.http.get<User>('/api/users/get/' + login);
    }
}
