package br.com.zup.people_manager.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Error> handleValidationExecution(MethodArgumentNotValidException exception){
       List<Error> errors = new ArrayList<>();

       exception.getBindingResult().getFieldErrors().forEach(error -> {
           String fieldName = error.getField();
           String errorMessage = error.getDefaultMessage();

           errors.add(new Error(fieldName, errorMessage));
       });

        return errors;
    }
}
