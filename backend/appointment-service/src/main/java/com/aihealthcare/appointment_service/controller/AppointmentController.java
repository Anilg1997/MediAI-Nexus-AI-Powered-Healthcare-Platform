package com.aihealthcare.appointment_service.controller;

import com.aihealthcare.appointment_service.dto.AppointmentRequestDto;

import com.aihealthcare.appointment_service.entity.Appointment;

import com.aihealthcare.appointment_service.service.AppointmentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/appointments")

@CrossOrigin(origins =
        "http://localhost:4200")

public class AppointmentController {

    private final AppointmentService
            appointmentService;

    public AppointmentController(
            AppointmentService appointmentService) {

        this.appointmentService =
                appointmentService;
    }

    @PostMapping
    public Appointment addAppointment(

            @Valid

            @RequestBody
            AppointmentRequestDto dto) {

        return appointmentService
                .addAppointment(dto);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {

        return appointmentService
                .getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(

            @PathVariable Long id) {

        return appointmentService
                .getAppointmentById(id);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(

            @PathVariable Long id,

            @RequestBody
            Appointment appointment) {

        return appointmentService
                .updateAppointment(
                        id,
                        appointment);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(

            @PathVariable Long id) {

        appointmentService
                .deleteAppointment(id);

        return
                "Appointment Deleted Successfully";
    }
}