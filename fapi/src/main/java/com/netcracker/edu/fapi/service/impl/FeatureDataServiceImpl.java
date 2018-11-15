package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.FeatureViewModel;
import com.netcracker.edu.fapi.service.FeatureDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FeatureDataServiceImpl implements FeatureDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<FeatureViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        FeatureViewModel[] featureModelResponse = restTemplate.getForObject(backendServerUrl + "/api/feature/", FeatureViewModel[].class);
        return featureModelResponse == null ? Collections.emptyList() : Arrays.asList(featureModelResponse);
    }

    @Override
    public FeatureViewModel getFeatureById(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        FeatureViewModel[] featureViewModels = restTemplate.getForObject(backendServerUrl + "/api/feature/", FeatureViewModel[].class);

        if (featureViewModels != null) {
            for (FeatureViewModel featureViewModel : featureViewModels) {
                if (featureViewModel.getFeatureId() == id)
                    return featureViewModel;
            }
        }
        return null;
    }

    @Override
    public FeatureViewModel saveFeature(FeatureViewModel feature) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/feature", feature, FeatureViewModel.class).getBody();
    }

    @Override
    public void deleteFeature(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/feature/" + id);
    }
}
