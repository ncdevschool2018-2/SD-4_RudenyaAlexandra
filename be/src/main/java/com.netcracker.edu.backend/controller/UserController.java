package com.netcracker.edu.backend.controller;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService usersService){
        this.userService = usersService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//сопоставление запросов
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }//ответ

    @RequestMapping(value = "", method = RequestMethod.GET)//сопоставление запросов
    public Iterable<User> getAllUser(){
        return userService.getAllUser();
    }//ответ

    @RequestMapping(method = RequestMethod.POST)//сопоставление запросов
    public User saveUser(@RequestBody User user){
       return this.userService.saveUser(user);
    }//ответ

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//сопоставление запросов
    public ResponseEntity deleteUserById(@PathVariable(name = "id") Long id){
       this.userService.deleteUser(id);
       return ResponseEntity.noContent().build();
    }//ответ

}
