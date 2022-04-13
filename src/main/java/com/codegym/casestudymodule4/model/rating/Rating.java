package com.codegym.casestudymodule4.model.rating;
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
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating_lever;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
}
