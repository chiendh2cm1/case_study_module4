package com.codegym.casestudymodule4.model.bill;
import com.codegym.casestudymodule4.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String receiver;
    private String address;
    private String email;
    private String phoneNumber;
    @ManyToOne
    private User user;

    public Bill(Long id, String address, String email, String phoneNumber, User user) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }
}
