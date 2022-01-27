package com.caito.sarmientolibrary.mapper;

import com.caito.sarmientolibrary.entity.Editorial;
import com.caito.sarmientolibrary.model.dto.EditorialRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorialRequestMapper {

    Editorial requetTOEditorial(EditorialRequest request);
    List<Editorial> requestListToEditorialList(List<EditorialRequest> editorials);
}
