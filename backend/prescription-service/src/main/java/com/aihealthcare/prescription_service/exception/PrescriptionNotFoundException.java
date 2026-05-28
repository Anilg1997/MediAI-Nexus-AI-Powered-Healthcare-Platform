package com.aihealthcare.prescription_service.exception;

public class PrescriptionNotFoundException
        extends RuntimeException {

    public PrescriptionNotFoundException(
            String message) {

        super(message);
    }
}