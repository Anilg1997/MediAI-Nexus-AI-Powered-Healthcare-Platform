package com.aihealthcare.lab_service.dto;

import jakarta.validation.constraints.*;

public class LabReportRequestDto {

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotBlank
    private String testName;

    @NotBlank
    private String testResult;

    private String reportUrl;

    @NotBlank
    private String status;

    @NotBlank
    private String testDate;

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