import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../model/category';

@Injectable ({
    providedIn: 'root'
})

export class CategoryService {

    constructor(private http: HttpClient) {}

    getCategory(): Observable<Category[]> {
        return this.http.get<Category[]>('/api/category');
    }

    saveCategory(category: Category): Observable<Category> {
        return this.http.post<Category>('/api/category', category);
    }

    deleteCategory(category_id: number): Observable<void> {
        return this.http.delete<void>('/api/category/' + category_id);
    }
    getCategoryById(categoryId: number): Observable<Category> {
        return this.http.get<Category>('api/category/' + categoryId);
    }
}
