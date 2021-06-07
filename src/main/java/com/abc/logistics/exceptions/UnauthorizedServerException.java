package com.abc.logistics.exceptions;

public class UnauthorizedServerException extends RuntimeException {

    public UnauthorizedServerException(String message) {
        super(message);
    }
}
