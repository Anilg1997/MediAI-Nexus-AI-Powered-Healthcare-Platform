package com.aihealthcare.patient_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service
public class PatientKafkaProducer {

    private final KafkaTemplate<String, String>
            kafkaTemplate;

    public PatientKafkaProducer(
            KafkaTemplate<String, String>
                    kafkaTemplate) {

        this.kafkaTemplate =
                kafkaTemplate;
    }

    public void sendPatientEvent(
            String message) {

        kafkaTemplate.send(
                "patient-topic",
                message);
    }
}