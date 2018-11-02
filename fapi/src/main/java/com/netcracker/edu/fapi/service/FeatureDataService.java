package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.entity.FeatureViewModel;

import java.util.List;

public interface FeatureDataService {
    List<FeatureViewModel> getAll();
    FeatureViewModel getFeatureById(Long id);
    FeatureViewModel saveFeature(FeatureViewModel feature);
    void deleteFeature(Long id);
}
