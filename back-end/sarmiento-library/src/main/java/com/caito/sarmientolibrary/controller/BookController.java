package com.caito.sarmientolibrary.controller;

import com.caito.sarmientolibrary.model.dto.BookRequest;
import com.caito.sarmientolibrary.model.dto.BookResponse;
import com.caito.sarmientolibrary.service.impl.BookService;
import com.caito.sarmientolibrary.entity.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/library/book")
@CrossOrigin
@Api
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    @ApiOperation(value = "method to create books into the library")
    @ApiResponses({
            @ApiResponse(code = 201, message = "book created successfully"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<BookResponse> save(@RequestBody BookRequest request) throws NotFoundException {

        return new ResponseEntity<BookResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "method that display a book by id if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "book no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<BookResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<BookResponse>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "method that display a list of books")
    @ApiResponses({
            @ApiResponse(code = 404, message = "book no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<BookResponse>> getAll(){

        return new ResponseEntity<List<BookResponse>>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "method to remove a book by id if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "book no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {

        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "method to update a book by id if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "book no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<BookResponse> update(@PathVariable Long id, @RequestBody BookRequest request)
            throws NotFoundException {

        return new ResponseEntity<BookResponse>(service.update(id, request), HttpStatus.OK);
    }

    @GetMapping("/{criterion}/{id}")
    @ApiOperation(value = "method that returns a list of books by category  or author or editorial" +
            " if they exist")
    @ApiResponses({
            @ApiResponse(code = 404, message = "book no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<BookResponse>> getBy(@PathVariable String criterion,
                                                    @PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<List<BookResponse>>(service.getBy(criterion, id), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<BookResponse>> getPageable(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String order,
            @RequestParam(defaultValue = "false") boolean asc
    ){
        Page<BookResponse> books = service.getPageable(PageRequest.of(
                page,
                size,
                Sort.by(order)));
        if (!asc){
            books = service.getPageable(PageRequest.of(
                    page,
                    size,
                    Sort.by(order).descending()
            ));
        }
        return new ResponseEntity<Page<BookResponse>>(books, HttpStatus.OK);
    }
}
