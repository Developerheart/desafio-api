package io.heart.developer.gastomicroservice.controller;

import io.heart.developer.gastomicroservice.dto.response.ExceptionResponse;
import io.heart.developer.gastomicroservice.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request){
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ExceptionResponse> notFound(NoSuchElementException exception,  HttpServletRequest request){
	    return new ResponseEntity<>(new ExceptionResponse("ID NÃO CORRESPONDE A NENHUMA REGISTRO", "REGISTRO NÃO ENCONTRADO"), HttpStatus.NOT_FOUND);
    }

}
