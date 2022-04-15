package com.codegym.casestudymodule4.service.product;

import com.codegym.casestudymodule4.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> getProductWithName(Long id, Pageable pageable);
    public Iterable<Product> findAll();
    public Optional<Product> findById(Long id);
    public Iterable<Product> findByName(String name);
    public Product save(Product product);
    public void remove(Long id);
    Page<Product> findByPrice1v3(Pageable pageable);
    Page<Product> findByPrice3v5(Pageable pageable);
    Page<Product> findByPrice5v7(Pageable pageable);
    Page<Product> findByShop(Long id, Pageable pageable);
    Page<Product> findByUser(Long id, Pageable pageable);
}
