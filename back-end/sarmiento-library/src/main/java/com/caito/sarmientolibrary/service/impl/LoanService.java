package com.caito.sarmientolibrary.service.impl;

import com.caito.sarmientolibrary.constants.ErrorMessageConstant;
import com.caito.sarmientolibrary.entity.Book;
import com.caito.sarmientolibrary.entity.Loan;
import com.caito.sarmientolibrary.entity.Partner;
import com.caito.sarmientolibrary.exception.custom.BadRequestException;
import com.caito.sarmientolibrary.mapper.LoanResponseMapper;
import com.caito.sarmientolibrary.model.dto.LoanRequest;
import com.caito.sarmientolibrary.model.dto.LoanResponse;
import com.caito.sarmientolibrary.repository.BookRepository;
import com.caito.sarmientolibrary.repository.LoanRepository;
import com.caito.sarmientolibrary.repository.PartnerRepository;
import com.caito.sarmientolibrary.service.contracts.LoanDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService implements LoanDAO {

    @Autowired
    private LoanRepository repository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private LoanResponseMapper responseMapper;


    @Override
    @Transactional
    public List<LoanResponse> partnerLoanRequest(List<LoanRequest> requests) {

        Loan loan = new Loan();
        List<Loan> loans = new ArrayList<>();

        if (requests.isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_LAN_NO_CONTENT);
        requests.stream().forEach((request)->{
            Book book = null;
            if (request.getBook_id() == null)
                throw new BadRequestException(ErrorMessageConstant.MSG_LAN_BOOK_NO_ID);
            try {
                 book = bookRepository.findById(request.getBook_id()).orElseThrow(()->
                        new NotFoundException(ErrorMessageConstant.MSG_BOK_NO_FOUND + request.getBook_id()));
                 if (!book.isAvailable())
                     throw new BadRequestException(ErrorMessageConstant.MSG_LAN_BOOK_NO_AVAILABLE);
                loan.setBook(book);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            if (request.getPartner_id() == null)
                throw new BadRequestException(ErrorMessageConstant.MSG_LAN_PARTNER_NO_ID);
            try {
                Partner partner = partnerRepository.findById(request.getPartner_id()).orElseThrow(()->
                        new NotFoundException(ErrorMessageConstant.MSG_PRT_NO_FOUND + request.getPartner_id()));
                loan.setPartner(partner);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            loan.setComment(request.getComment());
            loan.setDateTime(LocalDateTime.now());
            loans.add(loan);
            repository.save(loan);
            book.setAvailable(false);
            bookRepository.save(book);
        });
        return responseMapper.loanListToLoanResponseList(loans);
    }
}
