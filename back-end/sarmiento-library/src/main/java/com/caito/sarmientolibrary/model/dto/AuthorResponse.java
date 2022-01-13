package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ApiModel(description = "model representing an author for a response")
public class AuthorResponse {

    @ApiModelProperty(name = "id", example = "1")
    private Long id;
    @ApiModelProperty(name = "name", example = "nombre autor")
    private String name;
    @ApiModelProperty(name = "lastName", example = "apellido autor")
    private String lastName;
    @ApiModelProperty(name = "created", example = "01/01/01-01:01:01")
    private LocalDateTime created;
    @ApiModelProperty(name = "updated", example = "01/01/01-01:01:01")
    private LocalDateTime updated;
}
