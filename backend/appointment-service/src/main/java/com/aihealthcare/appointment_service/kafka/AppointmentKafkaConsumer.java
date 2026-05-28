package com.aihealthcare.appointment_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

@Service
public class AppointmentKafkaConsumer {

    @KafkaListener(

            topics = "appointment-topic",

            groupId = "appointment-group")

    public void consume(
            String message) {

        System.out.println(

                "Appointment Kafka Message: "

                        + message);
    }
}