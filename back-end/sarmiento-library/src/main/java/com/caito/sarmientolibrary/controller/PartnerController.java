package com.caito.sarmientolibrary.controller;

import com.caito.sarmientolibrary.model.dto.PartnerRequest;
import com.caito.sarmientolibrary.model.dto.PartnerResponse;
import com.caito.sarmientolibrary.service.impl.PartnerService;
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
@RequestMapping("/api/v1/library/partner")
@CrossOrigin
@Api
public class PartnerController {

    @Autowired
    private PartnerService service;

    @PostMapping
    @ApiOperation(value = "method to create a partner into the library")
    @ApiResponses({
            @ApiResponse(code = 201, message = "partner created successfully"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<PartnerResponse> save(@RequestBody PartnerRequest request){

        return new ResponseEntity<PartnerResponse>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "method that display a partner by id if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "partner no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<PartnerResponse> getById(@PathVariable Long id) throws NotFoundException {

        return new ResponseEntity<PartnerResponse>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "method that display a list of partners")
    @ApiResponses({
            @ApiResponse(code = 404, message = "partner no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<PartnerResponse>> getAll(){

        return new ResponseEntity<List<PartnerResponse>>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "method to remove a partner by id if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "author no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<?> delete(@PathVariable Long id) throws NotFoundException {

        service.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/dni/{dni}")
    @ApiOperation(value = "method that display a partner by DNI if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "partner no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<PartnerResponse> getByDni(@PathVariable String dni) throws NotFoundException {

        return new ResponseEntity<PartnerResponse>(service.getByDni(dni), HttpStatus.OK);
    }

    @GetMapping("/lastName/{lastName}")
    @ApiOperation(value = "method that display a list of partners by last name if it exists")
    @ApiResponses({
            @ApiResponse(code = 404, message = "partner no found"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "internal server error")
    })
    public ResponseEntity<List<PartnerResponse>> getByLastName(@PathVariable String lastName){

        return new ResponseEntity<List<PartnerResponse>>(service.getByLastName(lastName), HttpStatus.OK);
    }
}