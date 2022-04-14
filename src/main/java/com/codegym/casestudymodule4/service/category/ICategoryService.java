package com.codegym.casestudymodule4.service.category;

import com.codegym.casestudymodule4.model.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();
    Page<Category> findAllByNameContaining(String name, Pageable pageable);
    void deleteCategory(Long id);
    Optional<Category> findById(Long id);
    Category save(Category category);

}
