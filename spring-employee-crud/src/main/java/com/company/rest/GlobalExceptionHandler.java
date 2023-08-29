package com.company.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//This class is ControllerAdvice - It will handle all the exceptions for all the controllers.
@ControllerAdvice
public class GlobalExceptionHandler {


    //Handles any exception
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAnyException(Exception exception){


        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Exception! "+exception.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }



}
