package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Iterable<Role> getAll();
    Optional<Role> getRoleById(Long id);
}
