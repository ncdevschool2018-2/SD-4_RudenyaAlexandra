package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.entity.UserViewModel;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("userDataService")
public class UserDataServiceImpl implements UserDataService, UserDetailsService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Bean
    private PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

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
                if (userViewModel.getUserId() == id)
                    return userViewModel;
            }
        }
        return null;
    }


    @Override
    public UserViewModel saveUser(UserViewModel user) {
        RestTemplate restTemplate = new RestTemplate();
        user.setPassword(encoder().encode(user.getPassword()));
        return restTemplate.postForEntity(backendServerUrl + "/api/users", user, UserViewModel.class).getBody();
    }

    @Override
    public UserViewModel findByLogin(String name) {
        RestTemplate template = new RestTemplate();
        UserViewModel user = template.getForObject(backendServerUrl +
                "/api/users/get/" + name, UserViewModel.class);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/users/" + id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserViewModel user = findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(), getAuthority(user));
    }

    private Set getAuthority(UserViewModel user) {
        Set auth = new HashSet();
        auth.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return auth;
    }
}
