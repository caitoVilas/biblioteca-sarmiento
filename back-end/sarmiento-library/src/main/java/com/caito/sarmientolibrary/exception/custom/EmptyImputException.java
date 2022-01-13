package com.caito.sarmientolibrary.exception.custom;

public class EmptyImputException extends RuntimeException{
    public EmptyImputException(String error){
        super(error);
    }
}
