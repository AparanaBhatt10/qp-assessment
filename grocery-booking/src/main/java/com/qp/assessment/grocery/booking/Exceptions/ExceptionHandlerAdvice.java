package com.qp.assessment.grocery.booking.Exceptions;


import com.qp.assessment.grocery.booking.dtos.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice

public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
    public static final String EXCEPTION_THROWN = "Exception thrown";


    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(Exception e) {
        LOGGER.error(EXCEPTION_THROWN, e);
        return getResponseForException(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<Object> handlegenericException(Exception e) {
        LOGGER.error(EXCEPTION_THROWN, e);
        return getResponseForException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> getResponseForException(String message, HttpStatus httpStatus) {
        Response<String> exceptionResponse = new Response(new Date(), httpStatus.value(), message);
        return new ResponseEntity(exceptionResponse, httpStatus);
    }

}
