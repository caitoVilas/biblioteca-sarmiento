package com.caito.sarmientolibrary.service.impl;

import com.caito.sarmientolibrary.constants.ErrorMessageConstant;
import com.caito.sarmientolibrary.entity.Author;
import com.caito.sarmientolibrary.exception.custom.BadRequestException;
import com.caito.sarmientolibrary.mapper.AuthorRequestMapper;
import com.caito.sarmientolibrary.mapper.AuthorResponseMapper;
import com.caito.sarmientolibrary.model.dto.AuthorRequest;
import com.caito.sarmientolibrary.model.dto.AuthorResponse;
import com.caito.sarmientolibrary.repository.AuthorRepository;
import com.caito.sarmientolibrary.service.contracts.AuthorDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService implements AuthorDAO {

    @Autowired
    private AuthorRepository repository;
    @Autowired
    private AuthorRequestMapper requestMapper;
    @Autowired
    private AuthorResponseMapper responseMapper;


    @Override
    @Transactional
    public AuthorResponse save(AuthorRequest request) {
        if (request.getName() == null || request.getName().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_AUT_NO_NAME);
        if (request.getLastName() == null || request.getLastName().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_AUT_NO_LASTNAME);
        Author author = repository.save(requestMapper.authorRequestToAuthor(request));
        return responseMapper.authorToAuthorResponse(author);
    }

    @Override
    @Transactional(readOnly = true)
    public AuthorResponse getById(Long id) throws NotFoundException {
        Author author = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_AUT_NO_FOUND + id));
        return responseMapper.authorToAuthorResponse(author);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuthorResponse> getAll() {
        List<Author> authors = repository.findAll();
        return responseMapper.autorListToAuthorResponseList(authors);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {

        Author author = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_AUT_NO_FOUND + id));
        repository.deleteById(author.getId());
    }

    @Override
    public AuthorResponse update(Long id, AuthorRequest request) throws NotFoundException {

        Author author = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_AUT_NO_FOUND + id));
        if (request.getName() == null && request.getName().isEmpty()
            && request.getLastName() == null && request.getLastName().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_AUT_NO_CHANGES);
        if(request.getName() != null || !request.getName().isEmpty())
            author.setName(request.getName());
        if (request.getLastName() != null || !request.getLastName().isEmpty())
            author.setLastName(request.getLastName());
        repository.save(author);
        return responseMapper.authorToAuthorResponse(author);
    }
}
