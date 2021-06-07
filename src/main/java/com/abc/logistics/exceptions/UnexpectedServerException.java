package com.abc.logistics.exceptions;

import lombok.Getter;

public class UnexpectedServerException extends RuntimeException {

    @Getter
    private final String trace;

    public UnexpectedServerException(String message, String trace) {
        super(message);
        this.trace = trace;
    }
}
