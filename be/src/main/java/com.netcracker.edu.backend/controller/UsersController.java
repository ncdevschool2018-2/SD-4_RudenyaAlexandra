package com.netcracker.edu.backend.controller;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//сопоставление запросов
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long id){
        Optional<User> user = usersService.getUserById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }//ответ

    @RequestMapping(value = "", method = RequestMethod.GET)//сопоставление запросов
    public Iterable<User> getAllUser(){
        return this.usersService.getAllUser();
    }//ответ

    @RequestMapping(method = RequestMethod.POST)//сопоставление запросов
    public User saveUser(User user){
       return this.usersService.saveUser(user);
    }//ответ

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//сопоставление запросов
    public ResponseEntity deleteUserById(@PathVariable(name = "id") Long id){
       this.usersService.deleteUser(id);
       return ResponseEntity.noContent().build();
    }//ответ

}
