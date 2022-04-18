package com.codegym.casestudymodule4.service.shop;

import com.codegym.casestudymodule4.model.category.Category;
import com.codegym.casestudymodule4.model.shop.Shop;
import com.codegym.casestudymodule4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IShopService extends IGeneralService<Shop> {
    Iterable<Shop> findShopByNameContaining(String name);
    Page<Category> getCategoryByShop(Long id, Pageable pageable);
    Iterable<Category> getCategoryByUser(Long id);
    Shop findByUser(Long id);
}