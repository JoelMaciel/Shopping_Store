package com.msvalidator.service.exception;

public class LimitUnavailableException extends RuntimeException{

    public LimitUnavailableException(String message) {
        super(message);
    }
}
