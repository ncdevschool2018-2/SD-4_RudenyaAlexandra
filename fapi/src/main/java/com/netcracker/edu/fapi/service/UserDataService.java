package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.entity.UserViewModel;

import java.util.List;

public interface UserDataService {
    List<UserViewModel> getAll();
    UserViewModel getUserById(Long id);
    UserViewModel saveUser(UserViewModel account);
    void deleteUser(Long id);
}
