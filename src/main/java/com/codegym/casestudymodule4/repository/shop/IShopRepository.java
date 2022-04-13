package com.codegym.casestudymodule4.repository.shop;

import com.codegym.casestudymodule4.model.shop.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopRepository extends PagingAndSortingRepository <Shop, Long> {
}
