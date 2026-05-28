package com.aihealthcare.patient_service.controller;

import com.aihealthcare.patient_service.dto.PatientRequestDto;

import com.aihealthcare.patient_service.entity.Patient;

import com.aihealthcare.patient_service.service.PatientService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/patients")

@CrossOrigin(origins =
        "http://localhost:4200")

public class PatientController {

    private final PatientService
            patientService;

    public PatientController(
            PatientService patientService) {

        this.patientService =
                patientService;
    }

    @PostMapping
    public Patient addPatient(

            @Valid

            @RequestBody
            PatientRequestDto dto) {

        return patientService
                .addPatient(dto);
    }

    @GetMapping
    public List<Patient> getAllPatients() {

        return patientService
                .getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(

            @PathVariable Long id) {

        return patientService
                .getPatientById(id);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(

            @PathVariable Long id,

            @RequestBody
            Patient patient) {

        return patientService
                .updatePatient(
                        id,
                        patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(

            @PathVariable Long id) {

        patientService
                .deletePatient(id);

        return
                "Patient Deleted Successfully";
    }
}