package com.api.eshop.exceptions;

import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class ApiException extends Throwable {

    private final String message;
    private final ZonedDateTime timeStamp;

    public ApiException(String message, ZonedDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }


}
