package com.codegym.casestudymodule4.repository.role;

import com.codegym.casestudymodule4.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}