package com.caito.sarmientolibrary.service.contracts;

import com.caito.sarmientolibrary.model.dto.EditorialRequest;
import com.caito.sarmientolibrary.model.dto.EditorialResponse;
import javassist.NotFoundException;

import java.util.List;

public interface EditorialDAO {

    EditorialResponse save(EditorialRequest request);
    EditorialResponse getById(Long id) throws NotFoundException;
    List<EditorialResponse> getAll();
    void delete(Long id) throws NotFoundException;
}
