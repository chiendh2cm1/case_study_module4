package com.codegym.casestudymodule4.service.product;

import com.codegym.casestudymodule4.model.product.Product;
import com.codegym.casestudymodule4.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Iterable<Product> findByName(String name) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findByPrice1v3(Pageable pageable) {
        return productRepository.getProductBy1V3(pageable);
    }

    @Override
    public Page<Product> findByPrice3v5(Pageable pageable) {
        return productRepository.getProductBy3V5(pageable);
    }

    @Override
    public Page<Product> findByPrice5v7(Pageable pageable) {
        return productRepository.getProductBy5V7(pageable);
    }

    @Override
    public Page<Product> findByShop(Long id, Pageable pageable) {
        return productRepository.getProductByShop(id, pageable);
    }

    @Override
    public Page<Product> findByUser(Long id, Pageable pageable) {
        return productRepository.getProductByUser(id, pageable);
    }



    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Product> getProductWithName(Long id, Pageable pageable) {
        return productRepository.getProductWithNameSQL(id, pageable);
    }
}
