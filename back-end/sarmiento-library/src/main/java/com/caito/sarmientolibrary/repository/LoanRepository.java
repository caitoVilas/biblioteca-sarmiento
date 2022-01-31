package com.caito.sarmientolibrary.repository;

import com.caito.sarmientolibrary.entity.Loan;
import com.caito.sarmientolibrary.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByPartner(Partner partner);
    List<Loan> findByDate(LocalDate date);
}
