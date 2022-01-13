package com.caito.sarmientolibrary.mapper;

import com.caito.sarmientolibrary.entity.Partner;
import com.caito.sarmientolibrary.model.dto.PartnerRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PartnerRequestMapper {

    Partner partnerRequestToPartner(PartnerRequest request);
    List<Partner> partnerRequestListToPartnerList(List<PartnerRequest> partnerRequests);
}
