package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.entity.UserViewModel;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDataService {
    List<UserViewModel> getAll();
    UserViewModel getUserById(Long id);
    UserViewModel saveUser(UserViewModel account);
    UserViewModel findByLogin(String name);
    void deleteUser(Long id);
}
