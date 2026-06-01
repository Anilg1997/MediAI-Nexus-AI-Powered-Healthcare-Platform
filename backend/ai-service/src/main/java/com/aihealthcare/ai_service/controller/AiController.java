package com.aihealthcare.ai_service.controller;

import com.aihealthcare.ai_service.dto.*;

import com.aihealthcare.ai_service.service.AIService;

import com.aihealthcare.ai_service.service.EmbeddingService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "http://localhost:4200")
public class AiController {

    private final AIService aiService;

    private final EmbeddingService embeddingService;

    public AiController(
            AIService aiService,
            EmbeddingService embeddingService) {

        this.aiService = aiService;
        this.embeddingService = embeddingService;
    }

    @PostMapping("/chat")
    public String chat(
            @RequestBody ChatRequest request) {

        return aiService.chat(
                request.getQuestion());
    }

    @PostMapping("/symptom-check")
    public String symptomCheck(
            @RequestBody SymptomRequest request) {

        return aiService.symptomChecker(
                request.getSymptoms());
    }

    @PostMapping("/embedding")
    public String embedding(
            @RequestBody String text) {

        float[] vector =
                embeddingService.createEmbedding(text);

        return "Vector Size : "
                + vector.length;
    }

    @PostMapping("/rag-chat")
    public String ragChat(
            @RequestBody RagRequest request) {

        return aiService.ragChat(
                request.getQuestion());
    }

    @PostMapping("/summarize")
    public String summarize(
            @RequestBody SummaryRequest request) {

        return aiService.summarizeReport(
                request.getReport());
    }

    @PostMapping("/analyze-prescription")
    public String analyzePrescription(
            @RequestBody PrescriptionRequest request) {

        return aiService.analyzePrescription(
                request.getPrescription());
    }

    @PostMapping("/analyze-lab")
    public String analyzeLab(
            @RequestBody LabReportRequest request) {

        return aiService.analyzeLabReport(
                request.getReport());
    }

    @PostMapping("/medical-qa")
    public String medicalQA(
            @RequestBody
            MedicalQuestionRequest request) {

        return aiService.ragChat(
                request.getQuestion());
    }

    @PostMapping("/medical-assistant")
    public String medicalAssistant(
            @RequestBody
            MedicalQuestionRequest request) {

        return aiService.medicalAssistant(
                request.getQuestion());
    }
}