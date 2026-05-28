package com.aihealthcare.prescription_service.dto;

import jakarta.validation.constraints.*;

public class PrescriptionRequestDto {

    @NotNull
    private Long appointmentId;

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotBlank
    private String medicines;

    @NotBlank
    private String dosage;

    @NotBlank
    private String instructions;

    @NotBlank
    private String createdDate;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(
            Long appointmentId) {

        this.appointmentId =
                appointmentId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(
            Long patientId) {

        this.patientId =
                patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(
            Long doctorId) {

        this.doctorId =
                doctorId;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(
            String medicines) {

        this.medicines =
                medicines;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(
            String dosage) {

        this.dosage =
                dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(
            String instructions) {

        this.instructions =
                instructions;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(
            String createdDate) {

        this.createdDate =
                createdDate;
    }
}