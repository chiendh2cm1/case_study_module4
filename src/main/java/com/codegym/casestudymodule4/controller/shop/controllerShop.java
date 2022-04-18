package com.codegym.casestudymodule4.controller.shop;

import com.codegym.casestudymodule4.model.category.Category;
import com.codegym.casestudymodule4.model.product.Product;
import com.codegym.casestudymodule4.model.shop.Shop;
import com.codegym.casestudymodule4.service.shop.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/shops")
public class controllerShop {
    @Autowired
    private IShopService shopService;

//	@Value("${file-upload}")
//	private String uploadPath;


    @GetMapping
    public ResponseEntity<Iterable<Shop>> findAll(@RequestParam(name = "q") Optional<String> q) {
        Iterable<Shop> shops = shopService.findAll();
        if (q.isPresent()) {
            shops = shopService.findShopByNameContaining(q.get());
        }
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> findById(@PathVariable Long id) {
        Optional<Shop> shopOptional = shopService.findById(id);
        if (!shopOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shopOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/findShopByUser/{id}")
    public ResponseEntity<Shop> findShopByUser(@PathVariable Long id) {
        Shop shop = shopService.findByUser(id);
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(shop, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Shop> save(@RequestBody Shop shop) {
        return new ResponseEntity<>(shopService.save(shop), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Long id, @RequestBody Shop newShop) {
        Optional<Shop> shopOptional = shopService.findById(id);
        if (!shopOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        newShop.setId(id);
        return new ResponseEntity<>(shopService.save(newShop), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> deleteShop(@PathVariable Long id) {
        Optional<Shop> shopOptional = shopService.findById(id);
        if (!shopOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shopService.removeById(id);
        return new ResponseEntity<>(shopOptional.get(), HttpStatus.OK);
    }

    @GetMapping("view/{id}")
    public ResponseEntity<Page<Category>> viewDetailCategory(@PathVariable Long id, @PageableDefault(size = 8) Pageable pageable) {
        Page<Category> categories = shopService.getCategoryByShop(id, pageable);
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("viewByIdUser/{id}")
    public ResponseEntity<Iterable<Category>> viewDetailCategoryByUser(@PathVariable Long id, @PageableDefault(size = 8) Pageable pageable) {
        Iterable<Category> categories = shopService.getCategoryByUser(id);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}