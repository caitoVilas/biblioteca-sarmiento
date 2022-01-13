package com.caito.sarmientolibrary.mapper;

import com.caito.sarmientolibrary.entity.Category;
import com.caito.sarmientolibrary.model.dto.CategoryRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryRequestMapper {

    Category categoryRequestToCathegory(CategoryRequest request);
    List<Category> categoryRequestListToCategoryList(List<CategoryRequest> requests);
}
