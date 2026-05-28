package com.aihealthcare.patient_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

@Service
public class PatientKafkaConsumer {

    @KafkaListener(
            topics = "patient-topic",

            groupId = "patient-group")

    public void consume(
            String message) {

        System.out.println(
                "Kafka Message Received: "
                        + message);
    }
}