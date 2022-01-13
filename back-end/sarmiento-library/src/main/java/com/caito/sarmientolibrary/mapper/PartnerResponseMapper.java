package com.caito.sarmientolibrary.mapper;

import com.caito.sarmientolibrary.entity.Partner;
import com.caito.sarmientolibrary.model.dto.PartnerResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PartnerResponseMapper {

    PartnerResponse partnerToPartnerResponse(Partner partner);
    List<PartnerResponse> partnerListToPartnerResponseList(List<Partner> partners);
}
