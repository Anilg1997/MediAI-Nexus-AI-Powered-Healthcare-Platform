package com.aihealthcare.ai_service.controller;

import com.aihealthcare.ai_service.service.MedicalAgentOrchestrator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agentic")
public class AgenticController {

    private final MedicalAgentOrchestrator
            orchestrator;

    public AgenticController(
            MedicalAgentOrchestrator orchestrator) {

        this.orchestrator =
                orchestrator;
    }

    @GetMapping("/ask")
    public String ask(
            @RequestParam String query) {

        return orchestrator
                .handle(query);
    }
}