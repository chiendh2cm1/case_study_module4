package com.codegym.casestudymodule4.repository.product;

import com.codegym.casestudymodule4.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findByNameContaining(String name, Pageable pageable);

    @Query(value = "select * from product join category on product.category_id = category.id where category_id = ?1", nativeQuery = true)
    Page<Product> getProductWithNameSQL(Long id, Pageable pageable);

    @Query(value = "select * from product join category c on c.id = product.category_id join shop s on s.id = c.shop_id join user u on u.id = s.user_id where u.id =?1", nativeQuery = true)
    Page<Product> getProductByUser(Long id, Pageable pageable);

    @Query(value = "select * from product where price between 100000 and 500000", nativeQuery = true)
    Page<Product> getProductBy1V3(Pageable pageable);

    @Query(value = "select * from product where price between 500000 and 1000000", nativeQuery = true)
    Page<Product> getProductBy3V5(Pageable pageable);

    @Query(value = "select * from product where price between 1000000 and 1500000", nativeQuery = true)
    Page<Product> getProductBy5V7(Pageable pageable);

    @Query(value = "select * from product join category c on c.id = product.category_id join shop s on s.id = c.shop_id where s.id=?1", nativeQuery = true)
    Page<Product> getProductByShop(Long id, Pageable pageable);
}
