package com.aihealthcare.medical_record_service.dto;

import jakarta.validation.constraints.*;

public class MedicalRecordRequestDto {

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotBlank
    private String diagnosis;

    @NotBlank
    private String testResults;

    @NotBlank
    private String doctorNotes;

    @NotBlank
    private String visitDate;

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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(
            String diagnosis) {

        this.diagnosis =
                diagnosis;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(
            String testResults) {

        this.testResults =
                testResults;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(
            String doctorNotes) {

        this.doctorNotes =
                doctorNotes;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(
            String visitDate) {

        this.visitDate =
                visitDate;
    }
}