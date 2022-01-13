package com.caito.sarmientolibrary.service.contracts;

import com.caito.sarmientolibrary.model.dto.CategoryRequest;
import com.caito.sarmientolibrary.model.dto.CategoryResponse;
import javassist.NotFoundException;

import java.util.List;

public interface CategoryDAO {

    CategoryResponse save(CategoryRequest request);
    CategoryResponse getById(Long id) throws NotFoundException;
    List<CategoryResponse> getAll();
    void delete(Long id) throws NotFoundException;
}
