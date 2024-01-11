package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class IngredientExceptionHandler {
    @ExceptionHandler(value = {IngredientRequestException.class})
    public ResponseEntity<Object> handleRecipeRequestException(IngredientRequestException ex){
        IngredientNonExistentException apiException = new IngredientNonExistentException(ex.getMessage(), ex, HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
