package com.codegym.casestudymodule4.repository.category;

import com.codegym.casestudymodule4.model.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Page<Category> findByNameContaining(String name, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "call delete_category(?1)", nativeQuery = true)
    void deleteCategory(Long id);
}
