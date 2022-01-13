package com.caito.sarmientolibrary.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AuthorResponse {

    private Long id;
    private String name;
    private String lastName;
    private LocalDateTime created;
    private LocalDateTime updated;
}
