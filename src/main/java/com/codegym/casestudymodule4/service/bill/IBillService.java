package com.codegym.casestudymodule4.service.bill;

import com.codegym.casestudymodule4.model.bill.Bill;

import java.util.Optional;

public interface IBillService {
    Iterable<Bill> findAll();
    void remove(Long id);
    Optional<Bill> findById(Long id);
    Bill save(Bill bill);
    Iterable<Bill> findByUser(Long id);
}
