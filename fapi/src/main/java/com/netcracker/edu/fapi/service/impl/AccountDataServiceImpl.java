package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.AccountViewModel;
import com.netcracker.edu.fapi.service.AccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AccountDataServiceImpl implements AccountDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<AccountViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        AccountViewModel[] accountModelResponse = restTemplate.getForObject(backendServerUrl + "/api/account/", AccountViewModel[].class);
        return accountModelResponse == null ? Collections.emptyList() : Arrays.asList(accountModelResponse);
    }

    @Override
    public AccountViewModel getAccountById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        AccountViewModel[] accountViewModels = restTemplate.getForObject(backendServerUrl + "/api/account/", AccountViewModel[].class);

        if (accountViewModels != null) {
            for (AccountViewModel accountsViewModel : accountViewModels) {
                if (accountsViewModel.getAccountId() == id)
                    return accountsViewModel;
            }
        }
        return null;
    }

    @Override
    public AccountViewModel saveAccount(AccountViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/account", account, AccountViewModel.class).getBody();
    }

    @Override
    public void deleteAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/account/" + id);
    }
}
