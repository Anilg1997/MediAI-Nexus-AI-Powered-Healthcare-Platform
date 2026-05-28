package com.aihealthcare.medical_record_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)

    private Long id;

    private Long patientId;

    private Long doctorId;

    private String diagnosis;

    private String testResults;

    private String doctorNotes;

    private String visitDate;

    public MedicalRecord() {
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