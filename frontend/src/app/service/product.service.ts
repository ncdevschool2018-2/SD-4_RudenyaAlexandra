import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable ({
    providedIn: 'root'
})

export class ProductService {

    constructor(private http: HttpClient) {}

    getProduct(): Observable<Product[]> {
        return this.http.get<Product[]>('/api/product');
    }

    saveProduct(product: Product): Observable<Product> {
        return this.http.post<Product>('/api/product', product);
    }

    deleteProduct(product_id: number): Observable<void> {
        return this.http.delete<void>('/api/product/' + product_id);
    }
}
