package com.caito.sarmientolibrary.controller;

import com.caito.sarmientolibrary.model.dto.CategoryRequest;
import com.caito.sarmientolibrary.model.dto.CategoryResponse;
import com.caito.sarmientolibrary.service.impl.CategoryService;
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
@RequestMapping("/api/v1/library/category")
@CrossOrigin
@Api
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    @ApiOperation(value = "method to create category into the library")
    @ApiResponses({
            @ApiResponse(code = 201, message = "category created successfully"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<CategoryResponse> save(@RequestBody CategoryRequest request){

        return new ResponseEntity<CategoryResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "method that display a category by id if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "author no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<CategoryResponse>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "method that display a list of category")
    @ApiResponses({
            @ApiResponse(code = 404, message = "author no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<CategoryResponse>> getAll(){

        return new ResponseEntity<List<CategoryResponse>>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "method to remove a category by id if it exists")
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
