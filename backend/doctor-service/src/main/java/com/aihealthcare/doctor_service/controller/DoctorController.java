package com.aihealthcare.doctor_service.controller;

import com.aihealthcare.doctor_service.dto.DoctorRequestDto;

import com.aihealthcare.doctor_service.entity.Doctor;

import com.aihealthcare.doctor_service.service.DoctorService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/doctors")

@CrossOrigin(origins =
        "http://localhost:4200")

public class DoctorController {

    private final DoctorService
            doctorService;

    public DoctorController(
            DoctorService doctorService) {

        this.doctorService =
                doctorService;
    }

    @PostMapping
    public Doctor addDoctor(

            @Valid

            @RequestBody
            DoctorRequestDto dto) {

        return doctorService
                .addDoctor(dto);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {

        return doctorService
                .getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(

            @PathVariable Long id) {

        return doctorService
                .getDoctorById(id);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(

            @PathVariable Long id,

            @RequestBody
            Doctor doctor) {

        return doctorService
                .updateDoctor(
                        id,
                        doctor);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(

            @PathVariable Long id) {

        doctorService
                .deleteDoctor(id);

        return
                "Doctor Deleted Successfully";
    }
}