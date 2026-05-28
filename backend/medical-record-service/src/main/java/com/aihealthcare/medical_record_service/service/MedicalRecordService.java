package com.aihealthcare.medical_record_service.service;

import com.aihealthcare.medical_record_service.dto.MedicalRecordRequestDto;

import com.aihealthcare.medical_record_service.entity.MedicalRecord;

import com.aihealthcare.medical_record_service.kafka.MedicalRecordKafkaProducer;

import com.aihealthcare.medical_record_service.repository.MedicalRecordRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository
            repository;

    private final MedicalRecordKafkaProducer
            kafkaProducer;

    public MedicalRecordService(

            MedicalRecordRepository repository,

            MedicalRecordKafkaProducer kafkaProducer) {

        this.repository =
                repository;

        this.kafkaProducer =
                kafkaProducer;
    }

    public MedicalRecord addRecord(
            MedicalRecordRequestDto dto) {

        MedicalRecord record =
                new MedicalRecord();

        record.setPatientId(
                dto.getPatientId());

        record.setDoctorId(
                dto.getDoctorId());

        record.setDiagnosis(
                dto.getDiagnosis());

        record.setTestResults(
                dto.getTestResults());

        record.setDoctorNotes(
                dto.getDoctorNotes());

        record.setVisitDate(
                dto.getVisitDate());

        MedicalRecord saved =
                repository.save(record);

        kafkaProducer.sendMedicalRecordEvent(

                "Medical Record Added For Patient ID: "

                        + record.getPatientId());

        return saved;
    }

    public List<MedicalRecord> getAllRecords() {

        return repository.findAll();
    }
}