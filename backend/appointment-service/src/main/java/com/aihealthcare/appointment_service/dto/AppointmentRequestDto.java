package com.aihealthcare.appointment_service.dto;

import jakarta.validation.constraints.*;

public class AppointmentRequestDto {

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotBlank
    private String appointmentDate;

    @NotBlank
    private String reason;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(
            Long patientId) {

        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(
            Long doctorId) {

        this.doctorId = doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(
            String appointmentDate) {

        this.appointmentDate =
                appointmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(
            String reason) {

        this.reason = reason;
    }
}