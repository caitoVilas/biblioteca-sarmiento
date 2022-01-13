package com.caito.sarmientolibrary.mapper;

import com.caito.sarmientolibrary.entity.Author;
import com.caito.sarmientolibrary.model.dto.AuthorResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorResponseMapper {

    AuthorResponse authorToAuthorResponse(Author request);
    List<AuthorResponse> autorListToAuthorResponseList(List<Author> requests);
}
