package com.aihealthcare.prescription_service.exception;

import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            PrescriptionNotFoundException.class)

    public ResponseEntity<String>
    handlePrescriptionNotFound(
            PrescriptionNotFoundException ex) {

        return new ResponseEntity<>(

                ex.getMessage(),

                HttpStatus.NOT_FOUND);
    }
}