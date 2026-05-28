package com.aihealthcare.lab_service.service;

import com.aihealthcare.lab_service.dto.LabReportRequestDto;

import com.aihealthcare.lab_service.entity.LabReport;

import com.aihealthcare.lab_service.kafka.LabKafkaProducer;

import com.aihealthcare.lab_service.repository.LabReportRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabReportService {

    private final LabReportRepository
            repository;

    private final LabKafkaProducer
            kafkaProducer;

    public LabReportService(

            LabReportRepository repository,

            LabKafkaProducer kafkaProducer) {

        this.repository =
                repository;

        this.kafkaProducer =
                kafkaProducer;
    }

    public LabReport addReport(
            LabReportRequestDto dto) {

        LabReport report =
                new LabReport();

        report.setPatientId(
                dto.getPatientId());

        report.setDoctorId(
                dto.getDoctorId());

        report.setTestName(
                dto.getTestName());

        report.setTestResult(
                dto.getTestResult());

        report.setReportUrl(
                dto.getReportUrl());

        report.setStatus(
                dto.getStatus());

        report.setTestDate(
                dto.getTestDate());

        LabReport saved =
                repository.save(report);

        kafkaProducer.sendLabEvent(

                "Lab Report Added For Patient ID: "

                        + report.getPatientId());

        return saved;
    }

    public List<LabReport> getAllReports() {

        return repository.findAll();
    }
}