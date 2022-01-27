package com.caito.sarmientolibrary.service.impl;

import com.caito.sarmientolibrary.constants.ErrorMessageConstant;
import com.caito.sarmientolibrary.entity.Author;
import com.caito.sarmientolibrary.entity.Book;
import com.caito.sarmientolibrary.entity.Category;
import com.caito.sarmientolibrary.entity.Editorial;
import com.caito.sarmientolibrary.exception.custom.BadRequestException;
import com.caito.sarmientolibrary.mapper.BookResponseMapper;
import com.caito.sarmientolibrary.model.dto.BookRequest;
import com.caito.sarmientolibrary.model.dto.BookResponse;
import com.caito.sarmientolibrary.repository.AuthorRepository;
import com.caito.sarmientolibrary.repository.BookRepository;
import com.caito.sarmientolibrary.repository.CategoryRepository;
import com.caito.sarmientolibrary.repository.EditorialRepository;
import com.caito.sarmientolibrary.service.contracts.BookDAO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService implements BookDAO {

    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private BookResponseMapper responseMapper;


    @Override
    @Transactional
    public BookResponse save(BookRequest request) throws NotFoundException {
        if (request.getTitle() == null || request.getTitle().isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_BOK_NO_TITLE);
        if (request.getAuthor_id() == null)
            throw new BadRequestException((ErrorMessageConstant.MSG_BOK_NO_AUT_ID));
        Author author = authorRepository.findById(request.getAuthor_id()).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_AUT_NO_FOUND + request.getAuthor_id()));
        if (request.getCategory_id() == null)
            throw new BadRequestException(ErrorMessageConstant.MSG_BOK_NO_CTG_ID);
        Category category = categoryRepository.findById(request.getCategory_id()).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_CTG_NO_FOUND + request.getCategory_id()));
        if (request.getCategory_id() == null)
            throw new BadRequestException(ErrorMessageConstant.MSG_BOX_NO_EDT_ID);
        Editorial editorial = editorialRepository.findById(request.getEditorial_id()).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_EDT_NO_FOUND + request.getEditorial_id()));
        if (request.getPages() == null)
            throw new BadRequestException(ErrorMessageConstant.MSG_BOK_NO_PAGES);
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(author);
        book.setCategory(category);
        book.setEditorial(editorial);
        book.setPages(request.getPages());
        repository.save(book);
        return responseMapper.bookToBookResponse(book);
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse getById(Long id) throws NotFoundException {

        Book book = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_BOK_NO_FOUND + id));
        return responseMapper.bookToBookResponse(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponse> getAll() {

        List<Book> books = repository.findAll();
        return responseMapper.bookListToBookResponseList(books);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {

        Book book = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_BOK_NO_FOUND + id));
        repository.deleteById(book.getId());
    }

    @Override
    @Transactional
    public BookResponse update(Long id, BookRequest request) throws NotFoundException {
        Book book = repository.findById(id).orElseThrow(()->
                new NotFoundException(ErrorMessageConstant.MSG_BOK_NO_FOUND + id));
        if (request.getTitle() != null || !request.getTitle().isEmpty())
            book.setTitle(request.getTitle());
        if (request.getAuthor_id() != null){
            Author author = authorRepository.findById(request.getAuthor_id()).orElseThrow(()->
                    new NotFoundException(ErrorMessageConstant.MSG_AUT_NO_FOUND + request.getAuthor_id()));
            book.setAuthor(author);
        }
        if (request.getCategory_id() != null){
            Category category = categoryRepository.findById(request.getCategory_id()).orElseThrow(()->
                    new NotFoundException(ErrorMessageConstant.MSG_CTG_NO_FOUND +
                            request.getCategory_id()));
            book.setCategory(category);
        }
        if (request.getEditorial_id() != null){
            Editorial editorial = editorialRepository.findById(request.getEditorial_id()).orElseThrow(()->
                    new NotFoundException(ErrorMessageConstant.MSG_EDT_NO_FOUND + request.getEditorial_id()));
            book.setEditorial(editorial);
        }
        if (request.getPages() != null)
            book.setPages(request.getPages());
        repository.save(book);
        return responseMapper.bookToBookResponse(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponse> getBy(String criterion, Long id) throws NotFoundException {

        List<Book> books;

        if (criterion == null || criterion.isEmpty())
            throw new BadRequestException(ErrorMessageConstant.MSG_BOX_NO_CRITERION);

        if (criterion.toLowerCase().contentEquals("category")){

            Category category = categoryRepository.findById(id).orElseThrow(()->
                    new NotFoundException(ErrorMessageConstant.MSG_CTG_NO_FOUND + id));
            books = repository.findByCategory(category);

        }else if (criterion.toLowerCase().contentEquals("author")){

            Author author = authorRepository.findById(id).orElseThrow(()->
                    new NotFoundException(ErrorMessageConstant.MSG_AUT_NO_FOUND + id));
            books = repository.findByAuthor(author);

        }else if (criterion.toLowerCase().contentEquals("editorial")) {

            Editorial editorial = editorialRepository.findById(id).orElseThrow(()->
                    new NotFoundException(ErrorMessageConstant.MSG_EDT_NO_FOUND + id));
            books = repository.findByEditorial(editorial);

        }else {
            throw new BadRequestException(ErrorMessageConstant.MSG_BOX_CRITERION_ERROR);
        }
        return responseMapper.bookListToBookResponseList(books);
    }
}
