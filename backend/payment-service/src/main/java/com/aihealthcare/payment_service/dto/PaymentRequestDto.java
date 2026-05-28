package com.aihealthcare.payment_service.dto;

import jakarta.validation.constraints.*;

public class PaymentRequestDto {

    @NotNull
    private Long patientId;

    @NotNull
    private Long appointmentId;

    @NotNull
    private Double amount;

    @NotBlank
    private String paymentMethod;

    @NotBlank
    private String paymentStatus;

    @NotBlank
    private String transactionId;

    @NotBlank
    private String paymentDate;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(
            Long patientId) {

        this.patientId =
                patientId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(
            Long appointmentId) {

        this.appointmentId =
                appointmentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(
            Double amount) {

        this.amount =
                amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(
            String paymentMethod) {

        this.paymentMethod =
                paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(
            String paymentStatus) {

        this.paymentStatus =
                paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(
            String transactionId) {

        this.transactionId =
                transactionId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(
            String paymentDate) {

        this.paymentDate =
                paymentDate;
    }
}