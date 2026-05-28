package com.aihealthcare.notification_service.controller;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/notifications")

public class NotificationController {

    @GetMapping
    public String testNotificationService() {

        return "Notification Service Running";
    }
}