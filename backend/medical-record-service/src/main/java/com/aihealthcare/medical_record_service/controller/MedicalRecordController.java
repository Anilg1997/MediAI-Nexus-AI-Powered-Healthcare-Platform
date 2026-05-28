package com.aihealthcare.medical_record_service.controller;

import com.aihealthcare.medical_record_service.dto.MedicalRecordRequestDto;

import com.aihealthcare.medical_record_service.entity.MedicalRecord;

import com.aihealthcare.medical_record_service.service.MedicalRecordService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/medical-records")

@CrossOrigin(origins =
        "http://localhost:4200")

public class MedicalRecordController {

    private final MedicalRecordService
            medicalRecordService;

    public MedicalRecordController(

            MedicalRecordService medicalRecordService) {

        this.medicalRecordService =
                medicalRecordService;
    }

    @PostMapping
    public MedicalRecord addRecord(

            @Valid

            @RequestBody
            MedicalRecordRequestDto dto) {

        return medicalRecordService
                .addRecord(dto);
    }

    @GetMapping
    public List<MedicalRecord> getAllRecords() {

        return medicalRecordService
                .getAllRecords();
    }
}