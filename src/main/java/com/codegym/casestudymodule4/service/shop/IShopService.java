package com.codegym.casestudymodule4.service.shop;

import com.codegym.casestudymodule4.model.shop.Shop;
import com.codegym.casestudymodule4.service.IGeneralService;

public interface IShopService extends IGeneralService<Shop> {
	Iterable<Shop> findShopByNameContaining(String name);
}
