package com.aihealthcare.medical_record_service.repository;

import com.aihealthcare.medical_record_service.entity.MedicalRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository
        extends JpaRepository<MedicalRecord, Long> {
}