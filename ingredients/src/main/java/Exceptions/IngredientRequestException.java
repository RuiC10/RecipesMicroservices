package Exceptions;

public class IngredientRequestException extends RuntimeException {
    public IngredientRequestException(String message){
        super(message);
    }

    public IngredientRequestException(String message, Throwable cause){
        super(message, cause);
    }

}
