package com.aihealthcare.appointment_service.service;

import com.aihealthcare.appointment_service.dto.AppointmentRequestDto;

import com.aihealthcare.appointment_service.entity.Appointment;

import com.aihealthcare.appointment_service.exception.AppointmentNotFoundException;

import com.aihealthcare.appointment_service.kafka.AppointmentKafkaProducer;

import com.aihealthcare.appointment_service.repository.AppointmentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository
            appointmentRepository;

    private final AppointmentKafkaProducer
            kafkaProducer;

    public AppointmentService(

            AppointmentRepository appointmentRepository,

            AppointmentKafkaProducer kafkaProducer) {

        this.appointmentRepository =
                appointmentRepository;

        this.kafkaProducer =
                kafkaProducer;
    }

    public Appointment addAppointment(
            AppointmentRequestDto dto) {

        Appointment appointment =
                new Appointment();

        appointment.setPatientId(
                dto.getPatientId());

        appointment.setDoctorId(
                dto.getDoctorId());

        appointment.setAppointmentDate(
                dto.getAppointmentDate());

        appointment.setReason(
                dto.getReason());

        appointment.setStatus(
                "BOOKED");

        Appointment savedAppointment =
                appointmentRepository.save(
                        appointment);

        kafkaProducer.sendAppointmentEvent(

                "Appointment Created For Patient ID: "

                        + appointment.getPatientId());

        return savedAppointment;
    }

    public List<Appointment> getAllAppointments() {

        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(
            Long id) {

        return appointmentRepository

                .findById(id)

                .orElseThrow(() ->

                        new AppointmentNotFoundException(

                                "Appointment Not Found"));
    }

    public Appointment updateAppointment(

            Long id,

            Appointment updatedAppointment) {

        Appointment appointment =
                getAppointmentById(id);

        appointment.setAppointmentDate(
                updatedAppointment.getAppointmentDate());

        appointment.setReason(
                updatedAppointment.getReason());

        appointment.setStatus(
                updatedAppointment.getStatus());

        return appointmentRepository
                .save(appointment);
    }

    public void deleteAppointment(
            Long id) {

        Appointment appointment =
                getAppointmentById(id);

        appointmentRepository.delete(
                appointment);
    }
}