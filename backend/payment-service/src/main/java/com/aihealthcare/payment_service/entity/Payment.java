package com.aihealthcare.payment_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)

    private Long id;

    private Long patientId;

    private Long appointmentId;

    private Double amount;

    private String paymentMethod;

    private String paymentStatus;

    private String transactionId;

    private String paymentDate;

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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