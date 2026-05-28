package com.aihealthcare.notification_service.consumer;

import com.aihealthcare.notification_service.service.NotificationService;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private final NotificationService
            notificationService;

    public NotificationConsumer(

            NotificationService notificationService) {

        this.notificationService =
                notificationService;
    }

    @KafkaListener(

            topics = "appointment-topic",

            groupId = "notification-group")

    public void consumeAppointmentEvent(
            String message) {

        notificationService.sendNotification(

                "Appointment Event: "

                        + message);
    }

    @KafkaListener(

            topics = "prescription-topic",

            groupId = "notification-group")

    public void consumePrescriptionEvent(
            String message) {

        notificationService.sendNotification(

                "Prescription Event: "

                        + message);
    }

    @KafkaListener(

            topics = "medical-record-topic",

            groupId = "notification-group")

    public void consumeMedicalRecordEvent(
            String message) {

        notificationService.sendNotification(

                "Medical Record Event: "

                        + message);
    }

    @KafkaListener(

            topics = "lab-topic",

            groupId = "notification-group")

    public void consumeLabEvent(
            String message) {

        notificationService.sendNotification(

                "Lab Event: "

                        + message);
    }
}