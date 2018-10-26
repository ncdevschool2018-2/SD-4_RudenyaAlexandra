package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.entity.UserViewModel;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserDataController {

    @Autowired
    private UserDataService usersDataService;

    @RequestMapping
    public ResponseEntity<List<UserViewModel>> getAllUsers() {
        return ResponseEntity.ok(usersDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserViewModel> saveUsers(@RequestBody UserViewModel user /*todo server validation*/) {
        if (user != null) {
            return ResponseEntity.ok(usersDataService.saveUser(user));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUsers(@PathVariable String id) {
        usersDataService.deleteUser(Long.valueOf(id));
    }

}
