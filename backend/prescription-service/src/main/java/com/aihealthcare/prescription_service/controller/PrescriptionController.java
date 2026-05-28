package com.aihealthcare.prescription_service.controller;

import com.aihealthcare.prescription_service.dto.PrescriptionRequestDto;

import com.aihealthcare.prescription_service.entity.Prescription;

import com.aihealthcare.prescription_service.service.PrescriptionService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/prescriptions")

@CrossOrigin(origins =
        "http://localhost:4200")

public class PrescriptionController {

    private final PrescriptionService
            prescriptionService;

    public PrescriptionController(
            PrescriptionService prescriptionService) {

        this.prescriptionService =
                prescriptionService;
    }

    @PostMapping
    public Prescription addPrescription(

            @Valid

            @RequestBody
            PrescriptionRequestDto dto) {

        return prescriptionService
                .addPrescription(dto);
    }

    @GetMapping
    public List<Prescription> getAllPrescriptions() {

        return prescriptionService
                .getAllPrescriptions();
    }

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(

            @PathVariable Long id) {

        return prescriptionService
                .getPrescriptionById(id);
    }

    @PutMapping("/{id}")
    public Prescription updatePrescription(

            @PathVariable Long id,

            @RequestBody
            Prescription prescription) {

        return prescriptionService
                .updatePrescription(
                        id,
                        prescription);
    }

    @DeleteMapping("/{id}")
    public String deletePrescription(

            @PathVariable Long id) {

        prescriptionService
                .deletePrescription(id);

        return
                "Prescription Deleted Successfully";
    }
}