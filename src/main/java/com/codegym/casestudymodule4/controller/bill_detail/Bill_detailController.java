package com.codegym.casestudymodule4.controller.bill_detail;

import com.codegym.casestudymodule4.model.bill_detail.Bill_detail;
import com.codegym.casestudymodule4.service.Bill_detail.IBill_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("bill_details")
public class Bill_detailController {
    @Autowired
    IBill_detailService bill_detailService;


    @PostMapping
    public ResponseEntity<Bill_detail> createBill_detail(@RequestBody Bill_detail bill_detail) {
        return new ResponseEntity<>(bill_detailService.save(bill_detail), HttpStatus.CREATED);
    }

    @GetMapping("/detail/{code}")
    public ResponseEntity<Iterable<Bill_detail>> showList(@PathVariable String code) {
        Iterable<Bill_detail> bill_details = bill_detailService.findByBill(code);
        return new ResponseEntity<>(bill_details, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Bill_detail>> getAll() {
        Iterable<Bill_detail> bill_details = bill_detailService.findAll();
        return new ResponseEntity<>(bill_details, HttpStatus.OK);
    }

    @DeleteMapping("{code}")
    public ResponseEntity<Iterable<Bill_detail>> deleteBill_detail(@PathVariable String code) {
        bill_detailService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
