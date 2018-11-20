package com.netcracker.edu.backend.service;

public interface  SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}

