package com.codegym.casestudymodule4.controller;

import com.codegym.casestudymodule4.model.order.Bill;
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

    @DeleteMapping
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

    @GetMapping
    public ResponseEntity<Iterable<Bill>> showList() {
        Iterable<Bill> bills = billService.findAll();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Bill> findById(@PathVariable Long id) {
        Optional<Bill> billOptional = billService.findById(id);
        if (!billOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billOptional.get(), HttpStatus.OK);
    }
}