package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "model representing an author to enter")
public class AuthorRequest {


    @ApiModelProperty(name = "name", required = true, example = "nombre autor")
    private String name;
    @ApiModelProperty(name = "lastName", required = true, example = "apellido del autor")
    private String lastName;
}
