package com.aihealthcare.notification_service.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(
            String message) {

        System.out.println(

                "================================");

        System.out.println(

                "NOTIFICATION RECEIVED:");

        System.out.println(message);

        System.out.println(

                "================================");
    }
}