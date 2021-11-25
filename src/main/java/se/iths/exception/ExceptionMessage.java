package se.iths.exception;

import javax.json.bind.annotation.JsonbProperty;

public class ExceptionMessage {

    private final String message;

    public ExceptionMessage(String message) {
        this.message = message;
    }

    @JsonbProperty("message")
    public String getMessage() {
        return message;
    }
}