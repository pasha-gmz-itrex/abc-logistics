package com.abc.logistics.exceptions;

import java.util.List;
import lombok.Getter;

public class InvalidRequestException extends RuntimeException {

    @Getter
    private final List<InvalidRequestExceptionDetails> details;

    public InvalidRequestException(List<InvalidRequestExceptionDetails> details) {
        super("Invalid request exception.");
        this.details = details;
    }
}
