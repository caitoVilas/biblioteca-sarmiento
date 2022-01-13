package com.caito.sarmientolibrary.controller;

import com.caito.sarmientolibrary.model.dto.AuthorRequest;
import com.caito.sarmientolibrary.model.dto.AuthorResponse;
import com.caito.sarmientolibrary.service.impl.AuthorService;
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
@RequestMapping("/api/v1/library/author")
@CrossOrigin
@Api
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping
    @ApiOperation(value = "method to create authors into the library")
    @ApiResponses({
            @ApiResponse(code = 201, message = "author created successfully"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<AuthorResponse> save(@RequestBody AuthorRequest request){

        return new ResponseEntity<AuthorResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "method that display an author by id if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "author no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<AuthorResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<AuthorResponse>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "method that display a list of authors")
    @ApiResponses({
            @ApiResponse(code = 404, message = "author no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<AuthorResponse>> getAll(){

        return new ResponseEntity<List<AuthorResponse>>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "method to remove an author by id if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "author no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {

        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
