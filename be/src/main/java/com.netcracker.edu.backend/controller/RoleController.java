package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Role;
import com.netcracker.edu.backend.service.RoleService;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    public RoleService roleService;

    @Autowired
    public RoleController(RoleService service){
        this.roleService = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Role> getAll() {
        return roleService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleService.getRoleById(id);
        if(role.isPresent()){
            return ResponseEntity.ok(role.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
