package com.caito.sarmientolibrary.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookResponse {

    private Long id;
    private String title;
    private AuthorResponse author;
    private CategoryResponse category;
    private Integer pages;
    private LocalDateTime created;
    private LocalDateTime updated;
}
