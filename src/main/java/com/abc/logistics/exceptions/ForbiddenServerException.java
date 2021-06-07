package com.abc.logistics.exceptions;

public class ForbiddenServerException extends RuntimeException {

    public ForbiddenServerException(String message) {
        super(message);
    }
}
