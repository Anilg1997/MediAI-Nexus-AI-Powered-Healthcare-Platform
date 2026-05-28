package com.aihealthcare.doctor_service.repository;

import com.aihealthcare.doctor_service.entity.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository
        extends JpaRepository<Doctor, Long> {
}