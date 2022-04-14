package com.codegym.casestudymodule4.repository.user;

import com.codegym.casestudymodule4.model.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}
