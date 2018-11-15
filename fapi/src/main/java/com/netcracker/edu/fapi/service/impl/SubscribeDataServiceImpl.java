package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.SubscribeViewModel;
import com.netcracker.edu.fapi.service.SubscribeDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscribeDataServiceImpl implements SubscribeDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<SubscribeViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        SubscribeViewModel[] subscribeModelResponse = restTemplate.getForObject(backendServerUrl + "/api/subscribe/", SubscribeViewModel[].class);
        return subscribeModelResponse == null ? Collections.emptyList() : Arrays.asList(subscribeModelResponse);
    }

    @Override
    public SubscribeViewModel getSubscribeById(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        SubscribeViewModel[] subscribeViewModels = restTemplate.getForObject(backendServerUrl + "/api/subscribe/", SubscribeViewModel[].class);

        if (subscribeViewModels != null) {
            for (SubscribeViewModel subscribeViewModel : subscribeViewModels) {
                if (subscribeViewModel.getSubscribeId() == id)
                    return subscribeViewModel;
            }
        }
        return null;
    }

    @Override
    public SubscribeViewModel saveSubscribe(SubscribeViewModel subscribe) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subscribe", subscribe, SubscribeViewModel.class).getBody();
    }

    @Override
    public void deleteSubscribe(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subscribe/" + id);
    }
}
