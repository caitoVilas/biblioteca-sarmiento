package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "model that represents the request for a loan from a partner")
public class LoanRequest {

    @ApiModelProperty(name = "book_id", required = true, example = "1")
    private Long book_id;
    @ApiModelProperty(name = "partner_id", required = true, example = "1")
    private Long partner_id;
    @ApiModelProperty(name = "comment", required = false, example = "comment on a loan")
    private String comment;

}
