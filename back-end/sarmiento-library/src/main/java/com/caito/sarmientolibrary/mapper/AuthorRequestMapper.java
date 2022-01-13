package com.caito.sarmientolibrary.mapper;

import com.caito.sarmientolibrary.entity.Author;
import com.caito.sarmientolibrary.model.dto.AuthorRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorRequestMapper {

    Author authorRequestToAuthor(AuthorRequest request);
    List<Author> authorRequestListToAuthorList(List<AuthorRequest> requests);
}
