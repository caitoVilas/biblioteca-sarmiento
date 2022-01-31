package com.caito.sarmientolibrary.service.contracts;

import com.caito.sarmientolibrary.model.dto.LoanRequest;
import com.caito.sarmientolibrary.model.dto.LoanResponse;
import javassist.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface LoanDAO {

    List<LoanResponse> partnerLoanRequest(List<LoanRequest> requests);
    List<LoanResponse> partnerReturnRequest(List<LoanRequest> requests);
    List<LoanResponse> getLoanByPartner(Long id) throws NotFoundException;
    List<LoanResponse> getReturnByPartner(Long id) throws NotFoundException;
    List<LoanResponse> getLoansByDate(LocalDate date);
    List<LoanResponse> getReturnsByDate(LocalDate date);
}
