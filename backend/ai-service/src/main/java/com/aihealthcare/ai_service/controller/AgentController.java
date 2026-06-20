package com.aihealthcare.ai_service.controller;

import com.aihealthcare.ai_service.service.AgentService;
import com.aihealthcare.ai_service.service.MedicalAgentOrchestrator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
@CrossOrigin(origins = "*")
public class AgentController {

    private final AgentService agentService;
    private final MedicalAgentOrchestrator medicalAgentOrchestrator;

    public AgentController(
            AgentService agentService,
            MedicalAgentOrchestrator medicalAgentOrchestrator) {

        this.agentService = agentService;
        this.medicalAgentOrchestrator = medicalAgentOrchestrator;
    }

    @GetMapping("/ask")
    public String askAgent(
            @RequestParam String query) {

        return agentService.process(query);
    }

    @PostMapping("/orchestrate")
    public String orchestrateAgent(
            @RequestBody OrchestrationRequest request) {

        return medicalAgentOrchestrator.handle(request.getQuery());
    }

    static class OrchestrationRequest {
        private String query;

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }
    }
}