package com.codegym.casestudymodule4.service.Bill_detail;
import com.codegym.casestudymodule4.model.bill_detail.Bill_detail;

import java.util.Optional;

public interface IBill_detailService {
    Iterable<Bill_detail> findAll();
    void remove(Long id);
    Optional<Bill_detail> findById(Long id);
    Bill_detail save(Bill_detail bill_detail);
    Iterable<Bill_detail> findByBill(String code);
    void delete(String code);
}
