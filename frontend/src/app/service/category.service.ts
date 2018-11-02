import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../model/category';

@Injectable ({
    providedIn: 'root'
})

export class CategoryService {

    constructor(private http: HttpClient) {}

    getUser(): Observable<Category[]> {
        return this.http.get<Category[]>('/api/category');
    }

    saveUser(category: Category): Observable<Category> {
        return this.http.post<Category>('/api/category', category);
    }

    deleteUser(category_id: string): Observable<void> {
        return this.http.delete<void>('/api/category/' + category_id);
    }
}
