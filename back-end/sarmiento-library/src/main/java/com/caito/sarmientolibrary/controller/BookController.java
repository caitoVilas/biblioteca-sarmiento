package com.caito.sarmientolibrary.controller;

import com.caito.sarmientolibrary.model.dto.BookRequest;
import com.caito.sarmientolibrary.model.dto.BookResponse;
import com.caito.sarmientolibrary.service.impl.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
}
