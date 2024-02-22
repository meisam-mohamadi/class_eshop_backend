package com.api.eshop.exceptions;

public class ApiRequestException extends RuntimeException
{
    public ApiRequestException(String message) {
        super(message);
    }
}
