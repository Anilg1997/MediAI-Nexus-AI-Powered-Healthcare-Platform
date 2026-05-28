package com.aihealthcare.patient_service.service;

import com.aihealthcare.patient_service.dto.PatientRequestDto;

import com.aihealthcare.patient_service.entity.Patient;

import com.aihealthcare.patient_service.exception.PatientNotFoundException;

import com.aihealthcare.patient_service.kafka.PatientKafkaProducer;

import com.aihealthcare.patient_service.repository.PatientRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository
            patientRepository;

    private final PatientKafkaProducer
            kafkaProducer;

    public PatientService(

            PatientRepository patientRepository,

            PatientKafkaProducer kafkaProducer) {

        this.patientRepository =
                patientRepository;

        this.kafkaProducer =
                kafkaProducer;
    }

    public Patient addPatient(
            PatientRequestDto dto) {

        Patient patient =
                new Patient();

        patient.setName(
                dto.getName());

        patient.setAge(
                dto.getAge());

        patient.setDisease(
                dto.getDisease());

        patient.setEmail(
                dto.getEmail());

        Patient savedPatient =
                patientRepository.save(
                        patient);

        kafkaProducer.sendPatientEvent(

                "New Patient Added: "

                        + patient.getEmail());

        return savedPatient;
    }

    public List<Patient> getAllPatients() {

        return patientRepository
                .findAll();
    }

    public Patient getPatientById(
            Long id) {

        return patientRepository

                .findById(id)

                .orElseThrow(() ->

                        new PatientNotFoundException(

                                "Patient Not Found"));
    }

    public Patient updatePatient(

            Long id,

            Patient updatedPatient) {

        Patient patient =
                getPatientById(id);

        patient.setName(
                updatedPatient.getName());

        patient.setAge(
                updatedPatient.getAge());

        patient.setDisease(
                updatedPatient.getDisease());

        patient.setEmail(
                updatedPatient.getEmail());

        return patientRepository
                .save(patient);
    }

    public void deletePatient(
            Long id) {

        Patient patient =
                getPatientById(id);

        patientRepository
                .delete(patient);
    }
}