package com.caito.sarmientolibrary.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoanRequest {

    private Long book_id;
    private Long partner_id;
    private LocalDateTime dateTime;
    private String comment;

}
