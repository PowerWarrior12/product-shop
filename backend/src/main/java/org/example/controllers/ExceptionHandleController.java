package org.example.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import org.example.exceptions.AlreadyExistException;
import org.example.exceptions.ApiRequestException;
import org.example.exceptions.LoginAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.NameNotFoundException;

@RestControllerAdvice
public class ExceptionHandleController {
    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<String> handleApiRequestException(ApiRequestException exception) {
        return ResponseEntity.status(exception.getStatus()).body(exception.getMessage());
    }

    @ExceptionHandler(value = LoginAlreadyExistException.class)
    public ResponseEntity<String> handleLoginAlreadyExistException(LoginAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
    }

    @ExceptionHandler(value = {NameNotFoundException.class, AlreadyExistException.class, JsonParseException.class})
    public ResponseEntity<String> handlePasswordNotMatchException(Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
