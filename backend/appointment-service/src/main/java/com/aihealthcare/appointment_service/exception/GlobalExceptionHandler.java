package com.aihealthcare.appointment_service.exception;

import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            AppointmentNotFoundException.class)

    public ResponseEntity<String>
    handleAppointmentNotFound(
            AppointmentNotFoundException ex) {

        return new ResponseEntity<>(

                ex.getMessage(),

                HttpStatus.NOT_FOUND);
    }
}