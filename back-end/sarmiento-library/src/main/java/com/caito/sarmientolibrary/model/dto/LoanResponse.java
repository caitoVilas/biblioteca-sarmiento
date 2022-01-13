package com.caito.sarmientolibrary.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoanResponse {

    private Long id;
    private BookResponse book;
    private PartnerResponse partner;
    private LocalDateTime dateTime;
    private String comment;
}
