package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.WalletViewModel;
import com.netcracker.edu.fapi.service.WalletDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class WalletDataServiceImpl implements WalletDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<WalletViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        WalletViewModel[] walletModelResponse = restTemplate.getForObject(backendServerUrl + "/api/wallet/", WalletViewModel[].class);
        return walletModelResponse == null ? Collections.emptyList() : Arrays.asList(walletModelResponse);
    }

    @Override
    public WalletViewModel getWalletById(Long id) {

        return null;
    }

    @Override
    public WalletViewModel saveWallet(WalletViewModel wallet) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/wallet", wallet, WalletViewModel.class).getBody();
    }

    @Override
    public void deleteWallet(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/wallet/" + id);
    }
}
