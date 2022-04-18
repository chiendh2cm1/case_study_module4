package com.codegym.casestudymodule4.controller.bill;

import com.codegym.casestudymodule4.model.bill.Bill;
import com.codegym.casestudymodule4.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("bills")
public class BillController {
    @Autowired
    IBillService billService;

    @GetMapping
    public ResponseEntity<Iterable<Bill>> getAll() {
        Iterable<Bill> bills = billService.findAll();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bill> deleteBill(@PathVariable Long id) {
        Optional<Bill> billOptional = billService.findById(id);
        if (!billOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        billService.remove(id);
        return new ResponseEntity<>(billOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        return new ResponseEntity<>(billService.save(bill), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill bill) {
        Optional<Bill> billOptional = billService.findById(id);
        if (!billOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bill.setId(billOptional.get().getId());
        return new ResponseEntity<>(billService.save(bill), HttpStatus.OK);
    }

    @GetMapping("viewByUser/{id}")
    public ResponseEntity<Iterable<Bill>> showList(@PathVariable Long id) {
        Iterable<Bill> bills = billService.findByUser(id);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

//    @GetMapping("view/{id}")
//    public ResponseEntity<Page<Product>> viewDetailCategory(@PathVariable Long id, @PageableDefault(size = 5) Pageable pageable) {
//        Page<Product> products = productService.getProductWithName(id, pageable);
//        if (products.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> findById(@PathVariable Long id) {
        Optional<Bill> billOptional = billService.findById(id);
        if (!billOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billOptional.get(), HttpStatus.OK);
    }
}
