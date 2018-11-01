package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Feature;
import com.netcracker.edu.backend.repository.AccountRepository;
import com.netcracker.edu.backend.repository.FeatureRepository;
import com.netcracker.edu.backend.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeatureServiceImpl implements FeatureService {

    private FeatureRepository repository;

    @Autowired
    public FeatureServiceImpl(FeatureRepository repository) {

        this.repository = repository;
    }

    @Override
    public Feature saveFeature(Feature feature) {
        return this.repository.save(feature);
    }

    @Override
    public Optional<Feature> getFeatureById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Iterable<Feature> getAllFeature() {

        return this.repository.findAll();
    }

    @Override
    public void deleteFeature(Long id) {
        this.repository.deleteById(id);
    }
}
