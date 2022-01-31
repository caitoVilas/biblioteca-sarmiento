package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ApiModel(description = "model representing the return of a book by a partner")
public class LoanResponse {

    @ApiModelProperty(name = "id", example = "1")
    private Long id;
    @ApiModelProperty(name = "book")
    private BookResponse book;
    @ApiModelProperty(name = "partner")
    private PartnerResponse partner;
    @ApiModelProperty(name = "date", example = "01/01/01")
    private LocalDate date;
    @ApiModelProperty(name = "comment", example = "comment of a loan")
    private String comment;
}
