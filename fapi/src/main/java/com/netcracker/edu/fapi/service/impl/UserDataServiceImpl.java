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
        UserViewModel[] userModelResponse = restTemplate.getForObject(backendServerUrl + "/api/users/", UserViewModel[].class);
        return userModelResponse == null ? Collections.emptyList() : Arrays.asList(userModelResponse);
    }

    @Override
    public UserViewModel getUserById(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] userViewModels = restTemplate.getForObject(backendServerUrl + "/api/users/", UserViewModel[].class);

        if (userViewModels != null) {
            for (UserViewModel userViewModel : userViewModels) {
                if (userViewModel.getUser_id() == id)
                    return userViewModel;
            }
        }
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
