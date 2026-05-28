package com.aihealthcare.lab_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lab_reports")
public class LabReport {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)

    private Long id;

    private Long patientId;

    private Long doctorId;

    private String testName;

    private String testResult;

    private String reportUrl;

    private String status;

    private String testDate;

    public LabReport() {
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

    public String getTestName() {
        return testName;
    }

    public void setTestName(
            String testName) {

        this.testName =
                testName;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(
            String testResult) {

        this.testResult =
                testResult;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(
            String reportUrl) {

        this.reportUrl =
                reportUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status) {

        this.status =
                status;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(
            String testDate) {

        this.testDate =
                testDate;
    }
}