package com.caito.sarmientolibrary.repository;

import com.caito.sarmientolibrary.entity.Author;
import com.caito.sarmientolibrary.entity.Book;
import com.caito.sarmientolibrary.entity.Category;
import com.caito.sarmientolibrary.entity.Editorial;
import com.caito.sarmientolibrary.model.dto.BookResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByCategory(Category category);
    List<Book> findByAuthor(Author author);
    List<Book> findByEditorial(Editorial editorial);
}
