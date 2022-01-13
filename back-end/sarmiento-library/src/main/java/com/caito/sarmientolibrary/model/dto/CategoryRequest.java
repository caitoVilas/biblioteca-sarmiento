package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "model representing a category to enter")
public class CategoryRequest {

    @ApiModelProperty(name = "name", required = true, example = "nombre categoria")
    private String name;
}
