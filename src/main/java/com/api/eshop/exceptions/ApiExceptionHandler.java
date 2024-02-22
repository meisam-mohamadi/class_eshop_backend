package com.api.eshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler
{
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity handleApiRequestException(ApiRequestException e)
    {
        //1. create payload containing exception and details
        ApiException apiException =  new ApiException(e.getMessage() , ZonedDateTime.now(ZoneId.of("Z") ));
        //2. return response entity
        return  new ResponseEntity(apiException, HttpStatus.BAD_REQUEST);
    }
}
