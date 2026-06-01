package com.aihealthcare.auth_service.controller;

import com.aihealthcare.auth_service.dto.DashboardStats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {


    @GetMapping("/stats")
    public DashboardStats getStats() {

        DashboardStats stats =
                new DashboardStats();

        stats.setPatients(120L);

        stats.setDoctors(35L);

        stats.setAppointments(80L);

        stats.setPrescriptions(40L);

        return stats;
    }


}
