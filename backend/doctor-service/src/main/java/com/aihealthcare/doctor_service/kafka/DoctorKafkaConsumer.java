package com.aihealthcare.doctor_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

@Service
public class DoctorKafkaConsumer {

    @KafkaListener(

            topics = "doctor-topic",

            groupId = "doctor-group")

    public void consume(
            String message) {

        System.out.println(

                "Doctor Kafka Message: "

                        + message);
    }
}