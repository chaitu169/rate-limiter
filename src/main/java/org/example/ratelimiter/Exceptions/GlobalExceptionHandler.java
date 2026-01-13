package org.example.ratelimiter.Exceptions;

import org.example.ratelimiter.dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RateLimitException.class)
    public ResponseEntity<ErrorDto> RateLimitException(String message){
        ErrorDto errorDto = new ErrorDto(message);
        return new ResponseEntity<>(errorDto, HttpStatus.TOO_MANY_REQUESTS);
    }
}
