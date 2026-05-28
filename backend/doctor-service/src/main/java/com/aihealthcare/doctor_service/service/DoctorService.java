package com.aihealthcare.doctor_service.service;

import com.aihealthcare.doctor_service.dto.DoctorRequestDto;

import com.aihealthcare.doctor_service.entity.Doctor;

import com.aihealthcare.doctor_service.exception.DoctorNotFoundException;

import com.aihealthcare.doctor_service.kafka.DoctorKafkaProducer;

import com.aihealthcare.doctor_service.repository.DoctorRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository
            doctorRepository;

    private final DoctorKafkaProducer
            kafkaProducer;

    public DoctorService(

            DoctorRepository doctorRepository,

            DoctorKafkaProducer kafkaProducer) {

        this.doctorRepository =
                doctorRepository;

        this.kafkaProducer =
                kafkaProducer;
    }

    public Doctor addDoctor(
            DoctorRequestDto dto) {

        Doctor doctor =
                new Doctor();

        doctor.setName(
                dto.getName());

        doctor.setSpecialization(
                dto.getSpecialization());

        doctor.setExperience(
                dto.getExperience());

        doctor.setEmail(
                dto.getEmail());

        doctor.setAvailable(
                dto.getAvailable());

        Doctor savedDoctor =
                doctorRepository.save(
                        doctor);

        kafkaProducer.sendDoctorEvent(

                "New Doctor Added: "

                        + doctor.getEmail());

        return savedDoctor;
    }

    public List<Doctor> getAllDoctors() {

        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(
            Long id) {

        return doctorRepository

                .findById(id)

                .orElseThrow(() ->

                        new DoctorNotFoundException(

                                "Doctor Not Found"));
    }

    public Doctor updateDoctor(

            Long id,

            Doctor updatedDoctor) {

        Doctor doctor =
                getDoctorById(id);

        doctor.setName(
                updatedDoctor.getName());

        doctor.setSpecialization(
                updatedDoctor.getSpecialization());

        doctor.setExperience(
                updatedDoctor.getExperience());

        doctor.setEmail(
                updatedDoctor.getEmail());

        doctor.setAvailable(
                updatedDoctor.getAvailable());

        return doctorRepository
                .save(doctor);
    }

    public void deleteDoctor(
            Long id) {

        Doctor doctor =
                getDoctorById(id);

        doctorRepository.delete(doctor);
    }
}