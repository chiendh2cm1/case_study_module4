package com.codegym.casestudymodule4.service.bill;

import com.codegym.casestudymodule4.model.bill.Bill;
import com.codegym.casestudymodule4.repository.bill.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService implements IBillService {
    @Autowired
    IBillRepository billRepository;

    @Override
    public Iterable<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Iterable<Bill> findByUser(Long id) {
        return billRepository.getBillByUser(id);
    }
}
