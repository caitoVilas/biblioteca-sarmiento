package com.caito.sarmientolibrary.controller;

import com.caito.sarmientolibrary.model.dto.LoanRequest;
import com.caito.sarmientolibrary.model.dto.LoanResponse;
import com.caito.sarmientolibrary.service.impl.LoanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/library/loan")
@CrossOrigin
@Api
public class LoanController {

    @Autowired
    private LoanService service;

    @PostMapping("/loans")
    @ApiOperation(value = "method to register the loan of books to partners")
    @ApiResponses({
            @ApiResponse(code = 404, message = "no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<LoanResponse>> partenrLoanRequest(@RequestBody List<LoanRequest> requests){

        return new ResponseEntity<List<LoanResponse>>(service.partnerLoanRequest(requests), HttpStatus.OK);
    }

    @PostMapping("/return")
    @ApiOperation(value = "method to register the return of books to partners")
    @ApiResponses({
            @ApiResponse(code = 404, message = "no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<LoanResponse>> partnerReturnRequest(@RequestBody List<LoanRequest> requests){

        return new ResponseEntity<List<LoanResponse>>(service.partnerReturnRequest(requests), HttpStatus.OK);
    }

    @GetMapping("/list-loans-partner/{id}")
    @ApiOperation(value = "method that returns a list of loans by member")
    @ApiResponses({
            @ApiResponse(code = 404, message = "no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<LoanResponse>> getLoansByPartner(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<List<LoanResponse>>(service.getLoanByPartner(id), HttpStatus.OK);
    }

    @GetMapping("/list-returns-partner/{id}")
    @ApiOperation(value = "method that returns a list of returns by member")
    @ApiResponses({
            @ApiResponse(code = 404, message = "no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<LoanResponse>> getReturnBuPartner(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<List<LoanResponse>>(service.getReturnByPartner(id), HttpStatus.OK);
    }

    @GetMapping("/list-loans-date/{date}")
    @ApiOperation(value = "method that returns a list of loans by date")
    @ApiResponses({
            @ApiResponse(code = 404, message = "no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<LoanResponse>> getLoansByDate(@PathVariable LocalDate date){

        return new ResponseEntity<List<LoanResponse>>(service.getLoansByDate(date), HttpStatus.OK);
    }

    @GetMapping("/list-returns-date/{date}")
    @ApiOperation(value = "method that returns a list of returns by date")
    @ApiResponses({
            @ApiResponse(code = 404, message = "no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<LoanResponse>> getReturnsByDate(@PathVariable LocalDate date){

        return new ResponseEntity<List<LoanResponse>>(service.getReturnsByDate(date), HttpStatus.OK);
    }
}
