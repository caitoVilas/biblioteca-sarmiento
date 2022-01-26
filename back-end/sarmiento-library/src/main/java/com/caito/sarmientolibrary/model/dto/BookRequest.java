package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "model representing a book entity for a request")
public class BookRequest {

    @ApiModelProperty(name = "title", required = true, example = "title of book")
    private String title;
    @ApiModelProperty(name = "author_id", required = true, example = "1")
    private Long author_id;
    @ApiModelProperty(name = "category_id", required = true, example = "1")
    private Long category_id;
    @ApiModelProperty(name = "pages", required = true, example = "100")
    private Integer pages;
}
