package com.codegym.casestudymodule4.repository.bill;

import com.codegym.casestudymodule4.model.bill.Bill;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends PagingAndSortingRepository<Bill, Long> {
}
