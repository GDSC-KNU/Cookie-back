package com.gdsc.cookieparking.cookieparking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.management.openmbean.KeyAlreadyExistsException;

@RestController
@ControllerAdvice
public class ExceptionHandlers {


    @ExceptionHandler(value= {UsernameNotFoundException.class})
    public ResponseEntity handleUsernameNotFoundExceptions() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .code(HttpStatus.NOT_FOUND.name())
                        .message("There is no such User")
                        .build()
                );
    }

    @ExceptionHandler(value= {IllegalArgumentException.class})
    public ResponseEntity IllegalArgumentException() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .code(HttpStatus.BAD_REQUEST.name())
                        .message("Confirm Passwords do not match")
                        .build()
                );
    }

    @ExceptionHandler(value= {KeyAlreadyExistsException.class})
    public ResponseEntity KeyAlreadyExistsException() {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ErrorResponse.builder()
                        .code(HttpStatus.CONFLICT.name())
                        .message("This ID is already used")
                        .build()
                );
    }
}