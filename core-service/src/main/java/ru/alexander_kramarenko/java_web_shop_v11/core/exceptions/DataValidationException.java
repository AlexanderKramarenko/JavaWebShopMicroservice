package ru.alexander_kramarenko.java_web_shop_v11.core.exceptions;

import java.util.List;

public class DataValidationException extends RuntimeException {
    private List<String> messages;

    public List<String> getMessages() {
        return messages;
    }

    public DataValidationException(List<String> messages) {
        this.messages = messages;
    }
}
