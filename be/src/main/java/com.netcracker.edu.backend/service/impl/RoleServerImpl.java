package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Role;
import com.netcracker.edu.backend.repository.RoleRepository;
import com.netcracker.edu.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServerImpl implements RoleService {

    private RoleRepository repository;

    @Autowired
    public RoleServerImpl(RoleRepository repository) {
        this.repository = repository;
    }
    @Override
    public Iterable<Role> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return this.repository.findById(id);
    }
}
