package com.caito.sarmientolibrary.model.dto;

import lombok.Data;

@Data
public class BookRequest {

    private String title;
    private Long author_id;
    private Long category_id;
    private Integer pages;
}
