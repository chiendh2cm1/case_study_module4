package com.codegym.casestudymodule4.repository.Bill_detail;

import com.codegym.casestudymodule4.model.bill_detail.Bill_detail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IBill_detailRepository extends PagingAndSortingRepository<Bill_detail, Long> {

//    @Query(value = "select * from bill_detail where bill_id = ?1", nativeQuery = true)
//    Iterable<Bill_detail> getBill_detail(Long id);

    @Query(value = "select * from bill_detail where code = ?1", nativeQuery = true)
    Iterable<Bill_detail> getBill_detail(String code);

    void deleteBill_detailByCode(String code);

}
