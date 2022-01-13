package com.caito.sarmientolibrary.exception;

import com.caito.sarmientolibrary.exception.custom.BadRequestException;
import com.caito.sarmientolibrary.exception.custom.EmptyImputException;
import com.caito.sarmientolibrary.exception.custom.Forbidden;
import com.caito.sarmientolibrary.model.dto.ErrorResponse;
import javassist.NotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class RestResponseHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<?> notFoundException(Exception e, HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(404, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            BadRequestException.class,
            DuplicateKeyException.class,
            MethodArgumentTypeMismatchException.class,
            EmptyImputException.class
    })
    protected ResponseEntity<?> badRequestException(Exception e, HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(400, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Forbidden.class)
    protected ResponseEntity<?> forbidden(Exception e, HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(403, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    protected ResponseEntity<?> conflictException(Exception e, HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(409, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }
}
