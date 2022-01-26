package com.caito.sarmientolibrary.service.contracts;

import com.caito.sarmientolibrary.model.dto.PartnerRequest;
import com.caito.sarmientolibrary.model.dto.PartnerResponse;
import javassist.NotFoundException;

import java.util.List;

public interface PartnerDAO {

    PartnerResponse save(PartnerRequest request);
    PartnerResponse getById(Long id) throws NotFoundException;
    List<PartnerResponse> getAll();
    void delete(Long id) throws NotFoundException;
    PartnerResponse getByDni(String dni) throws NotFoundException;
    List<PartnerResponse> getByLastName(String lastName);
}
