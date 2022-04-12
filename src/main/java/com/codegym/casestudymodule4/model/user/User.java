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
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String username;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String fullName;
    @Column(columnDefinition = "text", nullable = false)
    @Size(min = 6, max = 8, message = "Tên sản phẩm phải từ 6 -> 8 ký tự")
    private String password;
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String email;
    @Column(columnDefinition = "varchar(12)", nullable = false, unique = true)
    private String phoneNumber;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
