package com.aihealthcare.prescription_service.service;

import com.aihealthcare.prescription_service.dto.PrescriptionRequestDto;

import com.aihealthcare.prescription_service.entity.Prescription;

import com.aihealthcare.prescription_service.exception.PrescriptionNotFoundException;

import com.aihealthcare.prescription_service.kafka.PrescriptionKafkaProducer;

import com.aihealthcare.prescription_service.repository.PrescriptionRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository
            prescriptionRepository;

    private final PrescriptionKafkaProducer
            kafkaProducer;

    public PrescriptionService(

            PrescriptionRepository prescriptionRepository,

            PrescriptionKafkaProducer kafkaProducer) {

        this.prescriptionRepository =
                prescriptionRepository;

        this.kafkaProducer =
                kafkaProducer;
    }

    public Prescription addPrescription(
            PrescriptionRequestDto dto) {

        Prescription prescription =
                new Prescription();

        prescription.setAppointmentId(
                dto.getAppointmentId());

        prescription.setPatientId(
                dto.getPatientId());

        prescription.setDoctorId(
                dto.getDoctorId());

        prescription.setMedicines(
                dto.getMedicines());

        prescription.setDosage(
                dto.getDosage());

        prescription.setInstructions(
                dto.getInstructions());

        prescription.setCreatedDate(
                dto.getCreatedDate());

        Prescription savedPrescription =
                prescriptionRepository.save(
                        prescription);

        kafkaProducer.sendPrescriptionEvent(

                "Prescription Created For Patient ID: "

                        + prescription.getPatientId());

        return savedPrescription;
    }

    public List<Prescription> getAllPrescriptions() {

        return prescriptionRepository.findAll();
    }

    public Prescription getPrescriptionById(
            Long id) {

        return prescriptionRepository

                .findById(id)

                .orElseThrow(() ->

                        new PrescriptionNotFoundException(

                                "Prescription Not Found"));
    }

    public Prescription updatePrescription(

            Long id,

            Prescription updatedPrescription) {

        Prescription prescription =
                getPrescriptionById(id);

        prescription.setMedicines(
                updatedPrescription.getMedicines());

        prescription.setDosage(
                updatedPrescription.getDosage());

        prescription.setInstructions(
                updatedPrescription.getInstructions());

        return prescriptionRepository
                .save(prescription);
    }

    public void deletePrescription(
            Long id) {

        Prescription prescription =
                getPrescriptionById(id);

        prescriptionRepository.delete(
                prescription);
    }
}