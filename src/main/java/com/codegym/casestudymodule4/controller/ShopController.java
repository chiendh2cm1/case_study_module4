package com.codegym.casestudymodule4.controller;

import com.codegym.casestudymodule4.model.shop.Shop;
import com.codegym.casestudymodule4.service.shop.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private IShopService shopService;

//	@Value("${file-upload}")
//	private String uploadPath;


    @GetMapping
    public ResponseEntity<Iterable<Shop>> findAll(@RequestParam(name = "q") Optional<String> q) {
        Iterable<Shop> products = shopService.findAll();
        if (q.isPresent()) {
            products = shopService.findShopByNameContaining(q.get());
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> findById(@PathVariable Long id) {
        Optional<Shop> productOptional = shopService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Shop> save(@RequestBody Shop shop) {
        return new ResponseEntity<>(shopService.save(shop), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateProduct(@PathVariable Long id, @RequestBody Shop newShop) {
        Optional<Shop> productOptional = shopService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        newShop.setId(id);
        return new ResponseEntity<>(shopService.save(newShop), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> deleteProduct(@PathVariable Long id) {
        Optional<Shop> productOptional = shopService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shopService.removeById(id);
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }
}