package com.s0qva.util.message;

public enum FailedMessage {
    FILES_NOT_FOUND("I haven't found anything"),
    FILE_NOT_AVAILABLE("not available");

    private final String message;

    FailedMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
