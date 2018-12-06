package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.entity.UserViewModel;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserDataController {

    @Autowired
    private UserDataService usersDataService;

    private BCryptPasswordEncoder encoder;

    @RequestMapping
    public ResponseEntity<List<UserViewModel>> getAllUser() {

        return ResponseEntity.ok(usersDataService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserViewModel> getUserById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(usersDataService.getUserById(id));
    }

    @RequestMapping(value = "/get/{login}", method = RequestMethod.GET)
    public ResponseEntity<UserViewModel> getUserByLogin(@PathVariable(name = "login") String login) {
        return ResponseEntity.ok(usersDataService.findByLogin(login));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserViewModel> saveUser(@RequestBody UserViewModel user /*todo server validation*/) {
        if (user != null){
            return ResponseEntity.ok(usersDataService.saveUser(user));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        usersDataService.deleteUser(Long.valueOf(id));
    }

}
