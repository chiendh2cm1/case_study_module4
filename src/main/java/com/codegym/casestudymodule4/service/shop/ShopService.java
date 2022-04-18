package com.codegym.casestudymodule4.service.shop;

import com.codegym.casestudymodule4.model.category.Category;
import com.codegym.casestudymodule4.model.product.Product;
import com.codegym.casestudymodule4.model.shop.Shop;
import com.codegym.casestudymodule4.repository.category.ICategoryRepository;
import com.codegym.casestudymodule4.repository.shop.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class ShopService implements IShopService {
    @Autowired
    private IShopRepository shopRepository;
@Autowired
private ICategoryRepository categoryRepository;
    @Override
    public Iterable<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public Optional<Shop> findById(Long id) {
        return shopRepository.findById(id);
    }

    @Override
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public void removeById(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    public Iterable<Shop> findShopByNameContaining(String name) {
        return findShopByNameContaining(name);
    }

    @Override
    public Page<Category> getCategoryByShop(Long id, Pageable pageable) {
        return categoryRepository.getCategoryByShop(id, pageable);
    }

    @Override
    public Iterable<Category> getCategoryByUser(Long id) {
        return categoryRepository.getCategoryByUser(id);
    }

    @Override
    public Shop findByUser(Long id) {
        return shopRepository.findShopByUser(id);
    }
}