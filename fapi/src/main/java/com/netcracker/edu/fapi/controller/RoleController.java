package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.entity.RoleModel;
import com.netcracker.edu.fapi.service.RoleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController  {

    @Autowired
    private RoleDataService roleDataService;

    @RequestMapping
    public ResponseEntity<List<RoleModel>> getAllUser() {
        return ResponseEntity.ok(roleDataService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoleModel> getUserById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(roleDataService.getRoleById(id));
    }
}
