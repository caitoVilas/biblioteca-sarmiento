package com.caito.sarmientolibrary.mapper;

import com.caito.sarmientolibrary.entity.Editorial;
import com.caito.sarmientolibrary.model.dto.EditorialResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorialResponseMapper {

    EditorialResponse editorialToResponse(Editorial editorial);
    List<EditorialResponse> editorialListToResponseList(List<Editorial> editorials);
}
