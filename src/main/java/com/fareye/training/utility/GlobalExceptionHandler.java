package com.fareye.training.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler( value = {IllegalArgumentException.class, UsernameNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(IllegalArgumentException ex)
    {
        return new ResponseEntity<>( ex.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
