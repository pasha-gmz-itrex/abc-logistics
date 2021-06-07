package com.abc.logistics.exceptions;

import lombok.Getter;

public class ItemNotFoundException extends RuntimeException {

    @Getter
    private final String itemId;

    public ItemNotFoundException(String itemId, String message) {
        super(message);
        this.itemId = itemId;
    }
}
