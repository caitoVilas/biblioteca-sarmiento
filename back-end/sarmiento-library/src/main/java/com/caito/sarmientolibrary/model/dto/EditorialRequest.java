package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Model representing a editorial to request")
public class EditorialRequest {

    @ApiModelProperty(name = "name", required = true, example = "name of Editorial")
    private String name;
}
