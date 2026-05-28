package com.aihealthcare.file_service.repository;

import com.aihealthcare.file_service.entity.MedicalFile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalFileRepository
        extends JpaRepository<MedicalFile, Long> {
}