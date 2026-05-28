package com.aihealthcare.lab_service.repository;

import com.aihealthcare.lab_service.entity.LabReport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LabReportRepository
        extends JpaRepository<LabReport, Long> {
}