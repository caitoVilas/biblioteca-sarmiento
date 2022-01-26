package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "model that represents the entry of a member to the library")
public class PartnerRequest {

    @ApiModelProperty(name = "name", required = true, example = "name")
    private String name;
    @ApiModelProperty(name = "lastName", required = true, example = "last name")
    private String lastName;
    @ApiModelProperty(name = "dni", required = true, example = "11.111.111")
    private String dni;
    @ApiModelProperty(name = "email", required = true,example = "name@mail.com")
    private String email;
    @ApiModelProperty(name = "homeAdress", required = true, example = "home adress 111 Location")
    private String homeAdress;
    @ApiModelProperty(name = "phone", required = true, example = "1111111111")
    private String phone;

}
