package com.caito.sarmientolibrary.mapper;

import com.caito.sarmientolibrary.entity.Category;
import com.caito.sarmientolibrary.model.dto.CategoryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryResponseMapper {

    CategoryResponse categoryToCategoryResponse(Category request);
    List<CategoryResponse> categoryListToCategoryResponseList(List<Category> categories);
}
