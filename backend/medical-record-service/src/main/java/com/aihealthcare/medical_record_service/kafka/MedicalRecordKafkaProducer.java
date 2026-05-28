package com.aihealthcare.medical_record_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service
public class MedicalRecordKafkaProducer {

    private final KafkaTemplate<String, String>
            kafkaTemplate;

    public MedicalRecordKafkaProducer(

            KafkaTemplate<String, String>
                    kafkaTemplate) {

        this.kafkaTemplate =
                kafkaTemplate;
    }

    public void sendMedicalRecordEvent(
            String message) {

        kafkaTemplate.send(

                "medical-record-topic",

                message);
    }
}