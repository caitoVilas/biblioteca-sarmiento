package com.caito.sarmientolibrary.service.contracts;

import com.caito.sarmientolibrary.entity.Category;
import com.caito.sarmientolibrary.model.dto.BookRequest;
import com.caito.sarmientolibrary.model.dto.BookResponse;
import javassist.NotFoundException;

import java.util.List;

public interface BookDAO {

    BookResponse save(BookRequest request) throws NotFoundException;
    BookResponse getById(Long id) throws NotFoundException;
    List<BookResponse> getAll();
    void delete(Long id) throws NotFoundException;
    BookResponse update(Long id, BookRequest request) throws NotFoundException;
    List<BookResponse> getBy(String criterion, Long id) throws NotFoundException;

}
