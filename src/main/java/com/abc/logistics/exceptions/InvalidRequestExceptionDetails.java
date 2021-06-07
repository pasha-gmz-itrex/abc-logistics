package com.abc.logistics.exceptions;

import lombok.Getter;

public class InvalidRequestExceptionDetails {

    @Getter
    private final String field;

    @Getter
    private final String message;

    public InvalidRequestExceptionDetails(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
