package com.codegym.casestudymodule4.model.product;

import com.codegym.casestudymodule4.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private String image;
    @ManyToOne
    private Category category;
}
