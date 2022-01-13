package com.caito.sarmientolibrary.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PartnerResponse {

    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private String homeAdress;
    private String phone;
    private LocalDateTime created;
    private LocalDateTime updated;
}
