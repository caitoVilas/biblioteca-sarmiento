package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "model representing a book entity for a response")
public class BookResponse {

    @ApiModelProperty(name = "id", example = "1")
    private Long id;
    @ApiModelProperty(name = "title", example = "title of the book")
    private String title;
    @ApiModelProperty(name = "author")
    private AuthorResponse author;
    @ApiModelProperty(name = "category")
    private CategoryResponse category;
    @ApiModelProperty(name = "editorial")
    private EditorialResponse editorial;
    @ApiModelProperty(name = "pages", example = "100")
    private Integer pages;
    @ApiModelProperty(name = "created", example = "01/01/01-01:01:01")
    private LocalDateTime created;
    @ApiModelProperty(name = "updated", example = "01/01/01-01:01:01")
    private LocalDateTime updated;
}
