package com.caito.sarmientolibrary.exception.custom;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String error){
        super(error);
    }
}
