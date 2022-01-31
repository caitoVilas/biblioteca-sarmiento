package com.caito.sarmientolibrary.service.impl;

import com.caito.sarmientolibrary.constants.ErrorMessageConstant;
import com.caito.sarmientolibrary.entity.Book;
import com.caito.sarmientolibrary.entity.Loan;
import com.caito.sarmientolibrary.entity.LoanReturn;
import com.caito.sarmientolibrary.entity.Partner;
import com.caito.sarmientolibrary.exception.custom.BadRequestException;
import com.caito.sarmientolibrary.mapper.LoanResponseMapper;
import com.caito.sarmientolibrary.model.dto.LoanRequest;
import com.caito.sarmientolibrary.model.dto.LoanResponse;
import com.caito.sarmientolibrary.repository.BookRepository;
import com.caito.sarmientolibrary.repository.LoanRepository;
import com.caito.sarmientolibrary.repository.LoanReturnRepository;
import com.caito.sarmientolibrary.repository.PartnerRepository;
import com.caito.sarmientolibrary.service.contracts.LoanDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService implements LoanDAO {

    @Autowired
    private LoanRepository repository;
    @Autowired
    private LoanReturnRepository returnRepository;
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
            loan.setDate(LocalDate.now());
            loans.add(loan);
            repository.save(loan);
            book.setAvailable(false);
            bookRepository.save(book);
        });
        return responseMapper.loanListToLoanResponseList(loans);
    }

    @Override
    @Transactional
    public List<LoanResponse> partnerReturnRequest(List<LoanRequest> requests) {
        List<LoanReturn> loans = new ArrayList<>();
        LoanReturn loan = new LoanReturn();

        if (requests.isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_LAN_NO_BOOKS_RETURNS);
        requests.stream().forEach((request -> {
            Book book = null;
            if (request.getBook_id() == null)
                throw new BadRequestException((ErrorMessageConstant.MSG_LAN_BOOK_NO_ID));
            try {
                book = bookRepository.findById(request.getBook_id()).orElseThrow(()->
                        new NotFoundException(ErrorMessageConstant.MSG_BOK_NO_FOUND + request.getBook_id()));
                loan.setBook(book);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            try {
                Partner partner = partnerRepository.findById(request.getPartner_id()).orElseThrow(()->
                        new NotFoundException(ErrorMessageConstant.MSG_PRT_NO_FOUND + request.getPartner_id()));
                loan.setPartner(partner);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            loan.setComment(request.getComment());
            loan.setDate(LocalDate.now());
            loans.add(loan);
            returnRepository.save(loan);
            book.setAvailable(true);
            bookRepository.save(book);
        }));
        return responseMapper.returnLoanToResponse(loans);
    }

    @Override
    public List<LoanResponse> getLoanByPartner(Long id) throws NotFoundException {

        if (id == null)
            throw new BadRequestException(ErrorMessageConstant.MSG_LAN_PARTNER_NO_ID);
        Partner partner = partnerRepository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_PRT_NO_FOUND));
        List<Loan> loans = repository.findByPartner(partner);
        return responseMapper.loanListToLoanResponseList(loans);
    }

    @Override
    public List<LoanResponse> getReturnByPartner(Long id) throws NotFoundException {

        if (id == null)
            throw new BadRequestException(ErrorMessageConstant.MSG_LAN_PARTNER_NO_ID);
        Partner partner = partnerRepository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_PRT_NO_FOUND));
        List<LoanReturn> loanReturns = returnRepository.findByPartner(partner);
        return responseMapper.returnLoanToResponse(loanReturns);
    }

    @Override
    public List<LoanResponse> getLoansByDate(LocalDate date) {
        if (date == null)
            date = LocalDate.now();
        List<Loan> loans = repository.findByDate(date);
        return responseMapper.loanListToLoanResponseList(loans);
    }

    @Override
    public List<LoanResponse> getReturnsByDate(LocalDate date) {
        if (date == null)
            date = LocalDate.now();
        List<LoanReturn> loanReturns = returnRepository.findByDate(date);
        return responseMapper.returnLoanToResponse(loanReturns);
    }


}
