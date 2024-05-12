package com.learnboot.CustomHandlers.PaymentHandlerApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(PaymentResourceNotFoundException.class)
    public ResponseEntity<?> PaymentResourceNotFoundException(PaymentResourceNotFoundException ex, WebRequest request) {
        Error errorDetails = new Error(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> RestResponseEntityExceptionHandler(Exception ex, WebRequest request) {
        Error errorDetails = new Error(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
