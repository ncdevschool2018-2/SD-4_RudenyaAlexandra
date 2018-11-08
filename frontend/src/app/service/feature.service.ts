import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Feature } from '../model/feature';

@Injectable ({
    providedIn: 'root'
})

export class FeatureService {

    constructor(private http: HttpClient) {}

    getFeature(): Observable<Feature[]> {
        return this.http.get<Feature[]>('/api/feature');
    }

    saveFeature(feature: Feature): Observable<Feature> {
        return this.http.post<Feature>('/api/feature', feature);
    }

    deleteFeature(feature_id: string): Observable<void> {
        return this.http.delete<void>('/api/feature/' + feature_id);
    }
}
