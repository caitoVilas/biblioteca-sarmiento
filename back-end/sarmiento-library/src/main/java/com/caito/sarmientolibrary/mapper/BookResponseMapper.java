package com.caito.sarmientolibrary.mapper;

import com.caito.sarmientolibrary.entity.Book;
import com.caito.sarmientolibrary.model.dto.BookResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookResponseMapper {

    BookResponse bookToBookResponse(Book request);
    List<BookResponse> bookListToBookResponseList(List<Book> books);
}
