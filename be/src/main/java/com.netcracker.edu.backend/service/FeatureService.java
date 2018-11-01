package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Feature;

import java.util.Optional;

public interface FeatureService {
    Feature saveFeature(Feature feature);
    Optional<Feature> getFeatureById(Long id);
    Iterable<Feature> getAllFeature();
    void deleteFeature(Long id);
}
