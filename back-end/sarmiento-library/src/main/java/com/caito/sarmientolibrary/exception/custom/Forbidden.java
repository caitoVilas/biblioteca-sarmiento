package com.caito.sarmientolibrary.exception.custom;

public class Forbidden extends RuntimeException{
    public Forbidden(String error){
        super(error);
    }
}
