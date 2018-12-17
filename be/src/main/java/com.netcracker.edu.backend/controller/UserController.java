package com.netcracker.edu.backend.controller;
import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired//имеет ли значение?
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping(method = RequestMethod.POST)//сопоставление запросов
    public User saveUser(@RequestBody User user){
       return this.userService.saveUser(user);
    }//ответ

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//сопоставление запросов
    public ResponseEntity deleteUserById(@PathVariable(name = "id") Long id){
       this.userService.deleteUser(id);
       return ResponseEntity.noContent().build();
    }//ответ

    @RequestMapping(value = "/get/{login}" , method = RequestMethod.GET)//сопоставление запросов
    public ResponseEntity<User> getUserByLogin(@PathVariable String login){
        Optional<User> user = userService.findByLogin(login);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/page" , method = RequestMethod.GET)
    public Page<User> getPage(@PageableDefault( sort = {"userId"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return this.userService.getUserPage(pageable);
    }

}
