package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "model that represents the view of a member to the library")
public class PartnerResponse {

    @ApiModelProperty(name = "id", example = "1")
    private Long id;
    @ApiModelProperty(name = "name", example = "name")
    private String name;
    @ApiModelProperty(name = "lastName", example = "last name")
    private String lastName;
    @ApiModelProperty(name = "dni", example = "11.111.111")
    private String dni;
    @ApiModelProperty(name = "email", example = "name@email.com")
    private String email;
    @ApiModelProperty(name = "homeAdress", example = "home adress 111 Location")
    private String homeAdress;
    @ApiModelProperty(name = "phone", example = "111111111")
    private String phone;
    @ApiModelProperty(name = "created", example = "01/01/01-01:01:01")
    private LocalDateTime created;
    @ApiModelProperty(name = "updated", example = "01/01/01-01:01:01")
    private LocalDateTime updated;
}
