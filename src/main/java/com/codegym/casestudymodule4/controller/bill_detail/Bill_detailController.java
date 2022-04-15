//package com.codegym.casestudymodule4.controller.bill_detail;
//
//import com.codegym.casestudymodule4.model.bill.Bill;
//import com.codegym.casestudymodule4.model.bill_detail.Bill_detail;
//import com.codegym.casestudymodule4.service.Bill_detail.Bill_detailService;
//import com.codegym.casestudymodule4.service.Bill_detail.IBill_detailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("bill_details")
//public class Bill_detailController {
//    @Autowired
//    IBill_detailService bill_detailService;
//
//    @PostMapping
//    public ResponseEntity<Bill_detail> createBill_detail(@RequestBody Bill_detail bill_detail) {
//        return new ResponseEntity<>(bill_detailService.save(bill_detail), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Iterable<Bill_detail>> showList(@PathVariable Long id) {
//        Iterable<Bill_detail> bill_details = bill_detailService.findByBill(id);
//        return new ResponseEntity<>(bill_details, HttpStatus.OK);
//    }
//
//}
