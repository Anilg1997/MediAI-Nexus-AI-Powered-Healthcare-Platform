package com.aihealthcare.payment_service.controller;

import com.aihealthcare.payment_service.dto.PaymentRequestDto;

import com.aihealthcare.payment_service.entity.Payment;

import com.aihealthcare.payment_service.service.PaymentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/payments")

@CrossOrigin(origins =
        "http://localhost:4200")

public class PaymentController {

    private final PaymentService
            paymentService;

    public PaymentController(
            PaymentService paymentService) {

        this.paymentService =
                paymentService;
    }

    @PostMapping
    public Payment addPayment(

            @Valid

            @RequestBody
            PaymentRequestDto dto) {

        return paymentService
                .addPayment(dto);
    }

    @GetMapping
    public List<Payment> getAllPayments() {

        return paymentService
                .getAllPayments();
    }
}