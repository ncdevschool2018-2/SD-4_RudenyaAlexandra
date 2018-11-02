import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Feature } from '../model/feature';

@Injectable ({
    providedIn: 'root'
})

export class FeatureService {

    constructor(private http: HttpClient) {}

    getUser(): Observable<Feature[]> {
        return this.http.get<Feature[]>('/api/feature');
    }

    saveUser(feature: Feature): Observable<Feature> {
        return this.http.post<Feature>('/api/feature', feature);
    }

    deleteUser(feature_id: string): Observable<void> {
        return this.http.delete<void>('/api/feature/' + feature_id);
    }
}
