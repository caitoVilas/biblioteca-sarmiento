package com.caito.sarmientolibrary.mapper;

import com.caito.sarmientolibrary.entity.Loan;
import com.caito.sarmientolibrary.entity.LoanReturn;
import com.caito.sarmientolibrary.model.dto.LoanResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanResponseMapper {

    LoanResponse loanToLoanResponse(Loan request);
    List<LoanResponse> returnLoanToResponse(List<LoanReturn> loanReturn);
    List<LoanResponse> loanListToLoanResponseList(List<Loan> loans);
}
