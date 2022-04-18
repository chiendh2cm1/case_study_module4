package com.codegym.casestudymodule4.repository.shop;

import com.codegym.casestudymodule4.model.category.Category;
import com.codegym.casestudymodule4.model.product.Product;
import com.codegym.casestudymodule4.model.shop.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IShopRepository extends PagingAndSortingRepository <Shop, Long> {
    @Transactional
    @Modifying
    @Query(value = "call delete_category(?1)", nativeQuery = true)
    void deleteCategory(Long id);

    @Query(value = "select * from shop where user_id =?1", nativeQuery = true)
    Shop findShopByUser(Long id);

}