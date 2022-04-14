package com.codegym.casestudymodule4.model.bill_detail;
import com.codegym.casestudymodule4.model.bill.Bill;
import com.codegym.casestudymodule4.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bill_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private double price;
    @ManyToOne
    private Bill bill;
    @OneToOne
    private Product product;
}
