package com.caito.sarmientolibrary.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "Model representing a editorial to response")
public class EditorialResponse {

    @ApiModelProperty(name = "id", example = "1")
    private Long id;
    @ApiModelProperty(name = "name", example = "name of Editorial")
    private String name;
    @ApiModelProperty(name = "created", example = "01/01/01-01:01:01")
    private LocalDateTime created;
    @ApiModelProperty(name = "updated", example = "01/01/01-01:01:01")
    private LocalDateTime updated;
}
