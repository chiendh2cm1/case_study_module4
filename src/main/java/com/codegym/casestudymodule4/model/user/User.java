package com.codegym.casestudymodule4.model.user;

import com.codegym.casestudymodule4.model.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String fullName, String password, String email, String phoneNumber, String role) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
