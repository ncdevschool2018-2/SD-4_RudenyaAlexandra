import { Subscribe } from './subscribe';

export class Feature {
    feature_id: number;
    title: string;
    cost: number;
    days: Date;
    subscribe_id: Subscribe;

    static cloneBase(feature: Feature): Feature {
        const cloneFeature: Feature = new Feature();
        cloneFeature.feature_id = feature.feature_id;
        cloneFeature.title = feature.title;
        cloneFeature.cost = feature.cost;
        cloneFeature.days = feature.days;
        cloneFeature.subscribe_id = feature.subscribe_id;
        return cloneFeature;
    }

}
