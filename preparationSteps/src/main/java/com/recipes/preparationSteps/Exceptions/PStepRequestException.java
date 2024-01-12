package com.recipes.preparationSteps.Exceptions;

public class PStepRequestException extends RuntimeException {
    public PStepRequestException(String message){
        super(message);
    }

    public PStepRequestException(String message, Throwable cause){
        super(message, cause);
    }

}
