package com.caito.sarmientolibrary.service.impl;

import com.caito.sarmientolibrary.constants.ErrorMessageConstant;
import com.caito.sarmientolibrary.entity.Editorial;
import com.caito.sarmientolibrary.exception.custom.BadRequestException;
import com.caito.sarmientolibrary.mapper.EditorialRequestMapper;
import com.caito.sarmientolibrary.mapper.EditorialResponseMapper;
import com.caito.sarmientolibrary.model.dto.EditorialRequest;
import com.caito.sarmientolibrary.model.dto.EditorialResponse;
import com.caito.sarmientolibrary.repository.EditorialRepository;
import com.caito.sarmientolibrary.service.contracts.EditorialDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EditorialService implements EditorialDAO {

    @Autowired
    private EditorialRepository repository;
    @Autowired
    private EditorialRequestMapper requestMapper;
    @Autowired
    private EditorialResponseMapper responseMapper;


    @Override
    @Transactional
    public EditorialResponse save(EditorialRequest request) {

        if (request.getName() == null || request.getName().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_CTG_NO_NAME);
        if (repository.existsByName(request.getName()))
            throw new BadRequestException(ErrorMessageConstant.MSG_EDT_NAME_EXISTS);

        Editorial editorial = repository.save(requestMapper.requetTOEditorial(request));
        return responseMapper.editorialToResponse(editorial);
    }

    @Override
    @Transactional(readOnly = true)
    public EditorialResponse getById(Long id) throws NotFoundException {

        Editorial editorial = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_EDT_NO_FOUND + id));
        return responseMapper.editorialToResponse(editorial);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EditorialResponse> getAll() {

        List<Editorial> editorials = repository.findAll();
        return responseMapper.editorialListToResponseList(editorials);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {

        Editorial editorial = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_EDT_NO_FOUND + id));
        repository.deleteById(editorial.getId());
    }
}
