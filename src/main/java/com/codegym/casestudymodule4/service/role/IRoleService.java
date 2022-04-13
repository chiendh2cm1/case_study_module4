package com.codegym.casestudymodule4.service.role;

import com.codegym.casestudymodule4.model.role.Role;

import java.util.Optional;

public interface IRoleService {
    Iterable<Role> findAll();

    Optional<Role> findById(Long id);

    Iterable<Role> findByName(String name);

    Role save(Role role);

    void remove(Long id);
}
