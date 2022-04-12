package com.codegym.casestudymodule4.model.comment;
import com.codegym.casestudymodule4.model.product.Product;
import com.codegym.casestudymodule4.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
}
