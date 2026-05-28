package com.aihealthcare.lab_service.controller;

import com.aihealthcare.lab_service.dto.LabReportRequestDto;

import com.aihealthcare.lab_service.entity.LabReport;

import com.aihealthcare.lab_service.service.LabReportService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/labs")

@CrossOrigin(origins =
        "http://localhost:4200")

public class LabReportController {

    private final LabReportService
            labReportService;

    public LabReportController(

            LabReportService labReportService) {

        this.labReportService =
                labReportService;
    }

    @PostMapping
    public LabReport addReport(

            @Valid

            @RequestBody
            LabReportRequestDto dto) {

        return labReportService
                .addReport(dto);
    }

    @GetMapping
    public List<LabReport> getAllReports() {

        return labReportService
                .getAllReports();
    }
}