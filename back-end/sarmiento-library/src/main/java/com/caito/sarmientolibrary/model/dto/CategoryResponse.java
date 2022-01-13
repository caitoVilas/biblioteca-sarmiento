package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "model representing a category to display")
public class CategoryResponse {

    @ApiModelProperty(name = "id", example = "1")
    private Long id;
    @ApiModelProperty(name = "name", example = "nombre categoria")
    private String name;
}
