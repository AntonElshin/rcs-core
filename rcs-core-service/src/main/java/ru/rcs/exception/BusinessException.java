package ru.rcs.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private int code;
    private String[] parameters;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Errors error, Object... args) {
        super(String.format(error.getMessage(), args));
        this.code = error.getCode();
    }

    public BusinessException(Errors error, String message, String... parameters) {
        super(String.format(error.getMessage(), message));
        this.parameters = parameters;
        this.code = error.getCode();
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
