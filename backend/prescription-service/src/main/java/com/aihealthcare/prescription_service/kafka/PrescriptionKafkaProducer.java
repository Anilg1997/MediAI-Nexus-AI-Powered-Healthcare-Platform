package com.aihealthcare.prescription_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service
public class PrescriptionKafkaProducer {

    private final KafkaTemplate<String, String>
            kafkaTemplate;

    public PrescriptionKafkaProducer(

            KafkaTemplate<String, String>
                    kafkaTemplate) {

        this.kafkaTemplate =
                kafkaTemplate;
    }

    public void sendPrescriptionEvent(
            String message) {

        kafkaTemplate.send(

                "prescription-topic",

                message);
    }
}