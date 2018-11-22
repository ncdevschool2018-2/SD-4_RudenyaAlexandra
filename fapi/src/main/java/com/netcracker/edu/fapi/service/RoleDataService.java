package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.entity.RoleModel;

import java.util.List;

public interface RoleDataService {
    List<RoleModel> getAll();
    RoleModel getRoleById(Long id);
}
