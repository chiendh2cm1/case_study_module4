package com.codegym.casestudymodule4.controller.product;

import com.codegym.casestudymodule4.model.product.Product;
import com.codegym.casestudymodule4.model.product.ProductForm;
import com.codegym.casestudymodule4.service.product.IProductService;
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

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Value("${file-upload}")
    String uploadPath;
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> fillAllProduct(@RequestParam(name = "q") Optional<String> q, @PageableDefault(size = 8) Pageable pageable) {
        Page<Product> productPage = null;
        if (q.isPresent()) {
            productPage = productService.findAllByNameContaining(q.get(), pageable);
        } else {
            productPage = productService.findAll(pageable);
        }
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/viewProductByUser/{id}")
    public ResponseEntity<Page<Product>> fillAllProductByUser(@RequestParam(name = "q") Optional<String> q, @PathVariable Long id, @PageableDefault(size = 8) Pageable pageable) {
        Page<Product> productPage = null;
        if (q.isPresent()) {
            productPage = productService.findAllByNameContaining(q.get(), pageable);
        } else {
            productPage = productService.findByUser(id, pageable);
        }
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/viewProductByShop/{id}")
    public ResponseEntity<Page<Product>> fillAllProductByShop(@RequestParam(name = "q") Optional<String> q, @PathVariable Long id, @PageableDefault(size = 8) Pageable pageable) {
        Page<Product> productPage = null;
        if (q.isPresent()) {
            productPage = productService.findAllByNameContaining(q.get(), pageable);
        } else {
            productPage = productService.findByShop(id, pageable);
        }
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@ModelAttribute ProductForm productForm) {
        String fileName = productForm.getImage().getOriginalFilename();
        Long currenTime = System.currentTimeMillis();
        fileName = currenTime + fileName;
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(uploadPath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(), productForm.getPrice(), productForm.getQuantity(), productForm.getDescription(), fileName, productForm.getCategory());
        product.setCategory(productForm.getCategory());
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    private ResponseEntity<Product> editProduct(@PathVariable Long id, ProductForm productForm) {
        Optional<Product> productOptional = productService.findById(id);

        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Product product = productOptional.get();
        MultipartFile multipartFile = productForm.getImage();
        if (multipartFile.getSize() != 0) {
            File file = new File(uploadPath + product.getImage());
            if (file.exists()) {
                file.delete();
            }
            String fileName = productForm.getImage().getOriginalFilename();
            Long currenTime = System.currentTimeMillis();
            fileName = currenTime + fileName;
            product.setImage(fileName);
            try {
                FileCopyUtils.copy(multipartFile.getBytes(), new File(uploadPath + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        product.setQuantity(productForm.getQuantity());
        product.setDescription(productForm.getDescription());
        product.setCategory(productForm.getCategory());
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        File file = new File(uploadPath + productOptional.get().getImage());
        if (file.exists()) {
            file.delete();
        }
        productService.remove(id);
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/findByPrice1v5")
    public ResponseEntity<Page<Product>> getByPrice1v5(@PageableDefault(size = 8) Pageable pageable) {
        Page<Product> productPage = productService.findByPrice1v3(pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/findByPrice5v10")
    public ResponseEntity<Page<Product>> getByPrice3v5(@PageableDefault(size = 8) Pageable pageable) {
        Page<Product> productPage = productService.findByPrice3v5(pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/findByPrice10v15")
    public ResponseEntity<Page<Product>> getByPrice5v7(@PageableDefault(size = 8) Pageable pageable) {
        Page<Product> productPage = productService.findByPrice5v7(pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

}
