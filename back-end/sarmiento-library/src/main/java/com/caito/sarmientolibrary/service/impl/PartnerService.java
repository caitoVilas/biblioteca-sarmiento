package com.caito.sarmientolibrary.service.impl;

import com.caito.sarmientolibrary.constants.ErrorMessageConstant;
import com.caito.sarmientolibrary.entity.Partner;
import com.caito.sarmientolibrary.exception.custom.BadRequestException;
import com.caito.sarmientolibrary.mapper.PartnerRequestMapper;
import com.caito.sarmientolibrary.mapper.PartnerResponseMapper;
import com.caito.sarmientolibrary.model.dto.PartnerRequest;
import com.caito.sarmientolibrary.model.dto.PartnerResponse;
import com.caito.sarmientolibrary.repository.PartnerRepository;
import com.caito.sarmientolibrary.service.contracts.PartnerDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartnerService implements PartnerDAO {

    @Autowired
    private PartnerRepository repository;
    @Autowired
    private PartnerRequestMapper requestMapper;
    @Autowired
    private PartnerResponseMapper responseMapper;


    @Override
    @Transactional
    public PartnerResponse save(PartnerRequest request) {
        if (repository.existsByDni(request.getDni()))
            throw new BadRequestException(ErrorMessageConstant.MSG_PRT_DNI_EXIST);
        if (repository.existsByEmail(request.getEmail()))
            throw new BadRequestException(ErrorMessageConstant.MSG_PRT_EMAIL_EXIST);
        if (request.getName() == null || request.getName().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_AUT_NO_NAME);
        if (request.getLastName() == null || request.getLastName().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_AUT_NO_LASTNAME);
        if (request.getDni() == null || request.getDni().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_PRT_NO_DNI);
        if (request.getEmail() == null || request.getEmail().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_PRT_NO_EMAIL);
        if (request.getHomeAdress() == null || request.getHomeAdress().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_PRT_NO_ADDRESS);
        if (request.getPhone() == null || request.getPhone().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_PRT_NO_PHONE);
        Partner partner = repository.save(requestMapper.partnerRequestToPartner(request));
        return responseMapper.partnerToPartnerResponse(partner);
    }

    @Override
    @Transactional(readOnly = true)
    public PartnerResponse getById(Long id) throws NotFoundException {

        Partner partner = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_PRT_NO_FOUND + id));
        return responseMapper.partnerToPartnerResponse(partner);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PartnerResponse> getAll() {

        List<Partner> partners = repository.findAll();
        return responseMapper.partnerListToPartnerResponseList(partners);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        Partner partner = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_PRT_NO_FOUND));
        repository.deleteById(partner.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public PartnerResponse getByDni(String dni) throws NotFoundException {

        Partner partner = repository.findByDni(dni).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_PRT_NO_FOUND_DNI + dni));
        return responseMapper.partnerToPartnerResponse(partner);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PartnerResponse> getByLastName(String lastName) {

        List<Partner> partners = repository.findByLastName(lastName);
        return responseMapper.partnerListToPartnerResponseList(partners);
    }

    @Override
    @Transactional
    public PartnerResponse update(Long id, PartnerRequest request) throws NotFoundException {

        Partner partner = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_PRT_NO_FOUND));
        if (request.getName() != null || !request.getName().isEmpty())
            partner.setName(request.getName());
        if (request.getLastName() != null || !request.getLastName().isEmpty())
            partner.setLastName(request.getLastName());
        if (request.getDni() != null || !request.getDni().isEmpty())
            partner.setDni(request.getDni());
        if (request.getEmail() != null || !request.getEmail().isEmpty())
            partner.setEmail(request.getEmail());
        if (request.getHomeAdress() != null || !request.getHomeAdress().isEmpty())
            partner.setHomeAdress(request.getHomeAdress());
        if (request.getPhone() != null || !request.getPhone().isEmpty())
            partner.setPhone(request.getPhone());
        repository.save(partner);
        return responseMapper.partnerToPartnerResponse(partner);
    }
}
