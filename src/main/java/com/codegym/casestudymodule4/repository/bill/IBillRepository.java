package com.codegym.casestudymodule4.repository.bill;

import com.codegym.casestudymodule4.model.bill.Bill;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBillRepository extends PagingAndSortingRepository<Bill, Long> {
    @Transactional
    @Modifying
//    @Query(value = "call delete_bill(?1)", nativeQuery = true)
//    void deleteBill(Long id);
    @Query(value = "select * from bill where user_id = ?1", nativeQuery = true)
    Iterable<Bill> getBillByUser(Long id);
}
