package Exceptions;

public class RecipeRequestException extends RuntimeException {
    public RecipeRequestException(String message){
        super(message);
    }

    public RecipeRequestException(String message, Throwable cause){
        super(message, cause);
    }

}
