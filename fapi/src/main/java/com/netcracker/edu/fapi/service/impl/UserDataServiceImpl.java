package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.UserViewModel;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<UserViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] usersModelResponce = restTemplate.getForObject(backendServerUrl + "/api/users/", UserViewModel[].class);
        return usersModelResponce == null ? Collections.emptyList() : Arrays.asList(usersModelResponce);
    }

    @Override
    public UserViewModel getUserById(Long id) {
        return null;
    }

    @Override
    public UserViewModel saveUser(UserViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/users", account, UserViewModel.class).getBody();
    }

    @Override
    public void deleteUser(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/users/" + id);
    }
}
