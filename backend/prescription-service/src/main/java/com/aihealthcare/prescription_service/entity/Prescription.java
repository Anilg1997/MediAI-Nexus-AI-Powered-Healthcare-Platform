package com.aihealthcare.prescription_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)

    private Long id;

    private Long appointmentId;

    private Long patientId;

    private Long doctorId;

    private String medicines;

    private String dosage;

    private String instructions;

    private String createdDate;

    public Prescription() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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