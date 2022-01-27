package com.caito.sarmientolibrary.controller;

import com.caito.sarmientolibrary.model.dto.EditorialRequest;
import com.caito.sarmientolibrary.model.dto.EditorialResponse;
import com.caito.sarmientolibrary.service.impl.EditorialService;
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
@RequestMapping("/api/v1/library/editorial")
@CrossOrigin
@Api
public class EditorialController {

    @Autowired
    private EditorialService service;

    @PostMapping
    @ApiOperation(value = "method to create editorials into the library")
    @ApiResponses({
            @ApiResponse(code = 201, message = "editorial created successfully"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<EditorialResponse> save(@RequestBody EditorialRequest request){

        return new ResponseEntity<EditorialResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "method that display a editorial by id if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "editorial no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<EditorialResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<EditorialResponse>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "method that display a list of editorials")
    @ApiResponses({
            @ApiResponse(code = 404, message = "editorial no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<EditorialResponse>> getAll(){

        return new ResponseEntity<List<EditorialResponse>>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "method to remove a editorial by id if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "editorial no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {

        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
