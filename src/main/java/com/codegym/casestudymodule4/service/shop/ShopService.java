package com.codegym.casestudymodule4.service.shop;

import com.codegym.casestudymodule4.model.shop.Shop;
import com.codegym.casestudymodule4.repository.shop.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopService implements IShopService{
    @Autowired
    private IShopRepository shopRepository;
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
}