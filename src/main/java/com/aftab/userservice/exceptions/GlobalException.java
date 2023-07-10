package com.aftab.userservice.exceptions;

import com.aftab.userservice.payload.ApiResponse;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {
        String msg = e.getMessage();
        LocalDate date = LocalDate.now();
        ApiResponse apiResponse = new ApiResponse(msg, false, date);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }



}
