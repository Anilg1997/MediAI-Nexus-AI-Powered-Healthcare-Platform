package com.aihealthcare.payment_service.service;

import com.aihealthcare.payment_service.dto.PaymentRequestDto;

import com.aihealthcare.payment_service.entity.Payment;

import com.aihealthcare.payment_service.kafka.PaymentKafkaProducer;

import com.aihealthcare.payment_service.repository.PaymentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository
            repository;

    private final PaymentKafkaProducer
            kafkaProducer;

    public PaymentService(

            PaymentRepository repository,

            PaymentKafkaProducer kafkaProducer) {

        this.repository =
                repository;

        this.kafkaProducer =
                kafkaProducer;
    }

    public Payment addPayment(
            PaymentRequestDto dto) {

        Payment payment =
                new Payment();

        payment.setPatientId(
                dto.getPatientId());

        payment.setAppointmentId(
                dto.getAppointmentId());

        payment.setAmount(
                dto.getAmount());

        payment.setPaymentMethod(
                dto.getPaymentMethod());

        payment.setPaymentStatus(
                dto.getPaymentStatus());

        payment.setTransactionId(
                dto.getTransactionId());

        payment.setPaymentDate(
                dto.getPaymentDate());

        Payment saved =
                repository.save(payment);

        kafkaProducer.sendPaymentEvent(

                "Payment Completed For Patient ID: "

                        + payment.getPatientId());

        return saved;
    }

    public List<Payment> getAllPayments() {

        return repository.findAll();
    }
}