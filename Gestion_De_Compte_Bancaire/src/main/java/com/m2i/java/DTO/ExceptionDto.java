package com.m2i.java.DTO;

public class ExceptionDto {

    private String message;
    private String exception;
    private ExceptionDto cause;

    public ExceptionDto(Throwable exception) {
        this(exception, true);
    }

    public ExceptionDto(Throwable exception, boolean computeCause) {
        this.message = exception.getMessage();
        this.exception = exception.getClass().getSimpleName();
        if (computeCause && exception.getCause() != null) {
            // Un seul niveau de cause
            this.cause = new ExceptionDto(exception.getCause(), false);
        }
    }

    public String getMessage() {
        return message;
    }

    public String getException() {
        return exception;
    }

    public ExceptionDto getCause() {
        return cause;
    }

}
