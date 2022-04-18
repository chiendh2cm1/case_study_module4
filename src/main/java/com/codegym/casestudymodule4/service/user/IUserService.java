package com.codegym.casestudymodule4.service.user;

import com.codegym.casestudymodule4.model.user.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends UserDetailsService {
    Iterable<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

    User save(User user);

    void remove(Long id);
    User findByUsername(String username);
    User saveAdmin(User user);
    User saveSeller(User user);
    Page<User> findAllUser(Pageable pageable);
    User saveBlock(User user);
}
