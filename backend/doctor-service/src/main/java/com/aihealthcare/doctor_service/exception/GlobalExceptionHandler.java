package com.aihealthcare.doctor_service.exception;

import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            DoctorNotFoundException.class)

    public ResponseEntity<String>
    handleDoctorNotFound(
            DoctorNotFoundException ex) {

        return new ResponseEntity<>(

                ex.getMessage(),

                HttpStatus.NOT_FOUND);
    }
}