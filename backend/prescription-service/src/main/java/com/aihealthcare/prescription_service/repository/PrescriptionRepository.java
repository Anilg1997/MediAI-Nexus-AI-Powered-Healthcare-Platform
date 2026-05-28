package com.aihealthcare.prescription_service.repository;

import com.aihealthcare.prescription_service.entity.Prescription;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository
        extends JpaRepository<Prescription, Long> {
}