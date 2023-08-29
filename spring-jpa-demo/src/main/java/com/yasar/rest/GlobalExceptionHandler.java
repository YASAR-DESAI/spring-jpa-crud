package com.yasar.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//This class is ControllerAdvice - It will handle all the exceptions for all the controllers.
@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){


        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.toString());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    //Handles any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAnyException(Exception exception){


        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setMessage("Exception! "+exception.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }



}
