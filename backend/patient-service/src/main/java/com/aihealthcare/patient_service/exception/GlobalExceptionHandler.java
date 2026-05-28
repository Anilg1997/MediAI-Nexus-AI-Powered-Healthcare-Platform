package com.aihealthcare.patient_service.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            PatientNotFoundException.class)

    public ResponseEntity<String>
    handlePatientNotFound(
            PatientNotFoundException ex) {

        return new ResponseEntity<>(

                ex.getMessage(),

                HttpStatus.NOT_FOUND);
    }
}