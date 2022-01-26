package com.caito.sarmientolibrary.service.impl;

import com.caito.sarmientolibrary.constants.ErrorMessageConstant;
import com.caito.sarmientolibrary.entity.Category;
import com.caito.sarmientolibrary.exception.custom.BadRequestException;
import com.caito.sarmientolibrary.mapper.CategoryRequestMapper;
import com.caito.sarmientolibrary.mapper.CategoryResponseMapper;
import com.caito.sarmientolibrary.model.dto.CategoryRequest;
import com.caito.sarmientolibrary.model.dto.CategoryResponse;
import com.caito.sarmientolibrary.repository.CategoryRepository;
import com.caito.sarmientolibrary.service.contracts.CategoryDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryDAO {

    @Autowired
    private CategoryRepository repository;
    @Autowired
    private CategoryRequestMapper requestMapper;
    @Autowired
    private CategoryResponseMapper responseMapper;


    @Override
    public CategoryResponse save(CategoryRequest request) {

        if (request.getName() == null || request.getName().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_CTG_NO_NAME);
        Category category = repository.save(requestMapper.categoryRequestToCathegory(request));
        return responseMapper.categoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse getById(Long id) throws NotFoundException {

        Category category = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_CTG_NO_FOUND + id));
        return responseMapper.categoryToCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> getAll() {

        List<Category> categories = repository.findAll();
        return responseMapper.categoryListToCategoryResponseList(categories);
    }

    @Override
    public void delete(Long id) throws NotFoundException {

        Category category = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_CTG_NO_FOUND + id));
        repository.deleteById(category.getId());
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest request) throws NotFoundException {

        Category category = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_CTG_NO_FOUND + id));
        if (request.getName() == null || request.getName().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_CTG_NO_CHANGES);
        if (request.getName() != null && !request.getName().isEmpty())
            repository.save(category);
        return responseMapper.categoryToCategoryResponse(category);
    }
}
