package com.api.eshop.service.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ErrorsMaps {
    public ResponseEntity getMap(BindingResult bindingResult)
    {
        Map<String, String> errors = new HashMap<>();
        for (FieldError item : bindingResult.getFieldErrors()) {
            errors.put(item.getField(), item.getDefaultMessage());
        }
        return new ResponseEntity(errors, HttpStatus.NOT_ACCEPTABLE);
    }
}
