package com.aihealthcare.ai_service.controller;

import com.aihealthcare.ai_service.dto.*;

import com.aihealthcare.ai_service.service.AiAnalysisService;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/ai")

@CrossOrigin(origins =
        "http://localhost:4200")

public class AiController {

    private final AiAnalysisService
            aiService;

    public AiController(
            AiAnalysisService aiService) {

        this.aiService =
                aiService;
    }

    @PostMapping("/analyze")
    public SymptomResponseDto
    analyzeSymptoms(

            @RequestBody
            SymptomRequestDto request) {

        return aiService
                .analyzeSymptoms(
                        request);
    }
}