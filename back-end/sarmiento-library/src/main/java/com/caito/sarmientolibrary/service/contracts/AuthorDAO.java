package com.caito.sarmientolibrary.service.contracts;

import com.caito.sarmientolibrary.model.dto.AuthorRequest;
import com.caito.sarmientolibrary.model.dto.AuthorResponse;
import javassist.NotFoundException;

import java.util.List;

public interface AuthorDAO {

    AuthorResponse save(AuthorRequest request);
    AuthorResponse getById(Long id) throws NotFoundException;
    List<AuthorResponse> getAll();
    void delete(Long id) throws NotFoundException;
}
