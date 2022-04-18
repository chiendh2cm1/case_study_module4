package com.codegym.casestudymodule4.service.Bill_detail;

import com.codegym.casestudymodule4.model.bill_detail.Bill_detail;
import com.codegym.casestudymodule4.repository.Bill_detail.IBill_detailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Bill_detailService implements IBill_detailService {

    @Autowired
    IBill_detailRepository bill_detailRepository;

    @Override
    public Iterable<Bill_detail> findAll() {
        return bill_detailRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        bill_detailRepository.deleteById(id);
    }

    @Override
    public Optional<Bill_detail> findById(Long id) {
        return bill_detailRepository.findById(id);
    }

    @Override
    public Bill_detail save(Bill_detail bill_detail) {
        return bill_detailRepository.save(bill_detail);
    }

    @Override
    public Iterable<Bill_detail> findByBill(String code) {
        return bill_detailRepository.getBill_detail(code);
    }

    @Override
    public void delete(String code) {
        bill_detailRepository.deleteBill_detailByCode(code);
    }
}
