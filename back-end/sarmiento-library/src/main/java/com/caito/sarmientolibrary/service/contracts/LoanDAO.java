package com.caito.sarmientolibrary.service.contracts;

import com.caito.sarmientolibrary.model.dto.LoanRequest;
import com.caito.sarmientolibrary.model.dto.LoanResponse;

import java.util.List;

public interface LoanDAO {

    List<LoanResponse> partnerLoanRequest(List<LoanRequest> requests);
}
