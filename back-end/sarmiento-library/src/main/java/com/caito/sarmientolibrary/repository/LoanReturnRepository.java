package com.caito.sarmientolibrary.repository;

import com.caito.sarmientolibrary.entity.Loan;
import com.caito.sarmientolibrary.entity.LoanReturn;
import com.caito.sarmientolibrary.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoanReturnRepository extends JpaRepository<LoanReturn, Long> {

    List<LoanReturn> findByPartner(Partner partner);
    List<LoanReturn> findByDate(LocalDate date);
}
