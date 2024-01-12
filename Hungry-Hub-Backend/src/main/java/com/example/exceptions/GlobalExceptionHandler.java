package com.example.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> UserException(UserException ex , WebRequest wr){
        return new ResponseEntity<ExceptionFormat>(ExceptionFormat.builder().timestamp(LocalDateTime.now()).message(ex.getMessage()).uri(wr.getDescription(false)).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionFormat> handlerNotFoundException(NoHandlerFoundException ex , WebRequest wr){
            return  new ResponseEntity<ExceptionFormat>(ExceptionFormat.builder().timestamp(LocalDateTime.now()).message(ex.getMessage()).uri(wr.getDescription(false)).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionFormat> globalException(Exception ex , WebRequest wr){
        return  new ResponseEntity<ExceptionFormat>(ExceptionFormat.builder().timestamp(LocalDateTime.now()).message(ex.getMessage()).uri(wr.getDescription(false)).build(),HttpStatus.BAD_REQUEST);
    }
}
