package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.RoleModel;
import com.netcracker.edu.fapi.service.RoleDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class RoleDataServiceImpl implements RoleDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;
    // RestTemplate для доступа к HTTP GET api-запросы
    @Override
    public List<RoleModel> getAll() {
        RestTemplate template = new RestTemplate();
        RoleModel roleResponse[] = template.getForObject(backendServerUrl + "api/role/", RoleModel[].class );
        return roleResponse == null ? Collections.emptyList(): Arrays.asList(roleResponse);
    }

    @Override
    public RoleModel getRoleById(Long id) {
       RestTemplate template = new RestTemplate();
       RoleModel roleResponse = template.getForObject(backendServerUrl + "api/role/" + id, RoleModel.class);
       return roleResponse;
    }
}
