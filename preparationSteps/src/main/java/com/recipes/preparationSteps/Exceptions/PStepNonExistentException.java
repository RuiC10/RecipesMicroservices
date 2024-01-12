package com.recipes.preparationSteps.Exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class PStepNonExistentException {
    private final String message;
    private final Throwable tr;
    private final HttpStatus status;
    private final ZonedDateTime exceptionTime;

    public PStepNonExistentException(String message, Throwable tr, HttpStatus status, ZonedDateTime exceptionTime) {
        this.message = message;
        this.tr = tr;
        this.status = status;
        this.exceptionTime = exceptionTime;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getTr() {
        return tr;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ZonedDateTime getExceptionTime() {
        return exceptionTime;
    }
}
